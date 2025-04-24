# 10.3.2 実習：ALTER TABLE（外部キー制約）

---

## 1. 売上表[packedsales]の顧客ID列[cust_id]に、顧客表[customer]の主キーへの外部キー制約を追加してください。

```sql
ALTER TABLE packedsales
ADD FOREIGN KEY (cust_id) REFERENCES customer;
```

**解説：**  
- `ALTER TABLE` はテーブルの構造を変更する命令です。  
- `ADD FOREIGN KEY` で、`cust_id` に外部キー制約を追加しています。  
- `REFERENCES customer` により、`customer` テーブルの主キー（cust_id）を参照します。  
- これにより、`packedsales.cust_id` に存在しない顧客IDを登録できなくなります。

（P175参照）

---

## 2. 外部キー制約のある状態で、存在しない顧客ID（cust_id）=100 を挿入しようとしたら？

```sql
INSERT INTO packedsales (psales_no, cust_id) VALUES (100, 100);
```

**結果例：**
```
-- INSERT 0 1 （顧客ID=100がcustomerに存在する場合）
-- エラー（存在しない場合）
```

**解説：**  
- `cust_id = 100` が `customer` テーブルに存在しない場合、外部キー制約に違反してエラーになります。  
- 逆に、存在していれば問題なく挿入できます。  
- 外部キーは「指定された参照先に存在する値しか入れられない」というルールです。

（P175参照）

---

## 3. 売上NO[psales_no]=1 の行の顧客IDを 100 に変更しようとすると？

```sql
UPDATE packedsales SET cust_id = 100 WHERE psales_no = 1;
```

**エラー：**
```
ERROR: テーブル"packedsales"への挿入、更新は外部キー制約に違反しています
DETAIL: テーブル"customer"にキー(cust_id)=(100)がありません
```

**解説：**  
- `UPDATE` によって、存在しない顧客ID（100）を設定しようとしています。  
- `customer` テーブルに `cust_id = 100` がないため、外部キー制約に違反します。  
- 外部キー制約によって、整合性の取れないデータの登録が防止されています。

（P176参照）

---

## 4. 顧客表[customer]の `cust_id = 1` を `100` に変更しようとすると？

```sql
UPDATE customer SET cust_id = 100 WHERE cust_id = 1;
```

**エラー：**
```
ERROR: "customer" の更新または削除は、"packedsales" の外部キー制約に違反します
DETAIL: cust_id = 1 はまだ packedsales に参照されています
```

**解説：**  
- `packedsales` テーブルからまだ `cust_id = 1` が参照されているため、変更できません。  
- 外部キー制約は「親テーブルのIDが使われている限り、変更できない」ように働きます。  
- 先に参照しているデータを更新・削除する必要があります。

（P177参照）

---

## 5. 顧客IDが参照されていない場合（例：cust_id = 11）、変更は可能です。

```sql
UPDATE customer SET cust_id = 100 WHERE cust_id = 11;
```

**結果：**
```
UPDATE 1
```

**解説：**  
- `cust_id = 11` が `packedsales` から参照されていなければ、更新できます。  
- 外部キー制約は「現在参照されているかどうか」で制限がかかります。  
- このように、未参照のデータであれば安全に更新が可能です。

（P115参照）

---

## 6. 顧客表から、参照されている `cust_id = 1` の行を削除しようとすると？

```sql
DELETE FROM customer WHERE cust_id = 1;
```

**エラー：**
```
ERROR: "customer" の更新または削除は、"packedsales" の外部キー制約に違反します
DETAIL: cust_id = 1 はまだ packedsales に参照されています
```

**解説：**  
- 他のテーブル（ここでは `packedsales`）で参照されている場合、削除はできません。  
- 外部キー制約は、データの整合性を保つために削除操作も制限します。  
- 先に `packedsales` から該当データを削除しない限り、削除はできません。

（P177参照）

---

## 7. 【応用】上記の例以外にも、異なるパターンで試してみましょう。

### 例1：参照されていない `cust_id` を削除（制約違反なし）

```sql
-- まず確認：customer に cust_id = 11 が存在し、packedsales に存在しないこと
DELETE FROM customer WHERE cust_id = 11;
```

**結果：**
```
DELETE 1
```

**解説：**  
`cust_id = 11` が他のテーブルから参照されていなければ、削除は問題なく完了します。  
このように、外部キー制約に影響されない場合の削除は正常に行えます。

---

### 例2：存在しない `cust_id` を登録（制約違反）

```sql
-- customer テーブルに cust_id = 999 が存在しないとき
INSERT INTO packedsales (psales_no, cust_id) VALUES (200, 999);
```

**結果：**
```
ERROR: 外部キー制約に違反しています
```

**解説：**  
参照先の `customer` テーブルに存在しない ID を指定すると、外部キー制約により拒否されます。  
これにより、整合性のとれないデータを登録できなくなっています。

---

### 例3：ON DELETE CASCADE を使ってみる（削除連動動作）

```sql
-- 外部キー制約を一度削除してから、ON DELETE CASCADE を再設定
ALTER TABLE packedsales DROP CONSTRAINT packedsales_cust_id_fkey;

ALTER TABLE packedsales
ADD CONSTRAINT packedsales_cust_id_fkey
FOREIGN KEY (cust_id) REFERENCES customer(cust_id)
ON DELETE CASCADE;
```

**確認：**
```sql
-- その後、customer.cust_id = 1 を削除してみる
DELETE FROM customer WHERE cust_id = 1;
```

**結果：**
```
DELETE 1
-- そして packedsales からも自動で削除される
```

**解説：**  
`ON DELETE CASCADE` を指定すると、親テーブル（customer）から行が削除されたとき、  
それを参照している子テーブル（packedsales）の行も**自動で削除されます**。  
大量の関連データがある場合に便利ですが、誤削除に注意が必要です。

（P177応用）

---
