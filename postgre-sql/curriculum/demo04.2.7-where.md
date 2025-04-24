# 4.2.7 実習：WHERE句による条件指定

---

## 1. 標準単価が20,000円以上の商品を表示してください。

```sql
SELECT * FROM product WHERE cost >= 20000;
```

**解説：**  
`WHERE` を使って、cost（標準単価）が2万円以上のレコードを条件付きで取得します。  
`>=` は「以上」を表す比較演算子です。  
`SELECT *` はすべての列を取得する命令です。

（P52参照）

---

## 2. FAX番号が未登録（NULL）の顧客IDと名前を表示してください。

```sql
SELECT cust_id, cust_name FROM customer WHERE fax IS NULL;
```

**解説：**  
`IS NULL` は、その列に値が入っていない（空白）ものを検索する構文です。  
NULLは「値が存在しない」という意味で、`=` や `!=` では判定できません。  
必要な列（IDと名前）のみ指定しています。

（P62参照）

---

## 3. 売上NOが110番台（110〜119）の売上明細を価格の高い順で表示してください。

```sql
SELECT sales_no, psales_no, prod_id, price
FROM sales
WHERE psales_no BETWEEN 110 AND 119
ORDER BY price DESC;
```

**解説：**  
`BETWEEN` は範囲指定（両端含む）に使います。  
`ORDER BY price DESC` で、売価が高い順（降順）に並べ替えます。  
並べ替えのデフォルトは昇順（ASC）ですが、ここでは `DESC` を使用しています。

（P58参照）

---

## 4. 商品IDが102・104・106の商品の割引価格を高い順に表示してください。

```sql
SELECT prod_id, prod_name, cost * discount
FROM product
WHERE prod_id IN (102, 104, 106)
ORDER BY cost * discount DESC;
```

**解説：**  
`IN (...)` は、指定した複数の値のいずれかに一致するレコードを抽出します。  
`cost * discount` は割引後の価格を計算して表示しています。  
`ORDER BY` で割引価格の高い順に並べています。

（P56参照）

---

## 5. 渋谷区に配送された1996年のデータを、3通りの方法で表示してください。

### ① BETWEENを使った方法

```sql
SELECT cust_id, cust_address, delivery_date
FROM packedsales
WHERE cust_address LIKE '%渋谷区%'
AND delivery_date BETWEEN '1996-01-01' AND '1996-12-31';
```

**解説：**  
`LIKE '%渋谷区%'` は、「渋谷区」を含む住所を検索します（部分一致）。  
`BETWEEN '1996-01-01' AND '1996-12-31'` は日付の範囲検索です。  
両端（1月1日と12月31日）も含まれます。

（P60参照）

---

### ② to_char関数で年だけを抽出する方法

```sql
SELECT cust_id, cust_address, delivery_date
FROM packedsales
WHERE cust_address LIKE '%渋谷区%'
AND to_char(delivery_date, 'yyyy') = '1996';
```

**解説：**  
`to_char(...)` で日付型を文字列（年）に変換しています。  
比較対象が文字列なので、`'1996'` のようにシングルクォートで囲みます。

（P60参照）

---

### ③ EXTRACT関数で年を抽出する方法

```sql
SELECT cust_id, cust_address, delivery_date
FROM packedsales
WHERE cust_address LIKE '%渋谷区%'
AND EXTRACT(YEAR FROM delivery_date) = 1996;
```

**解説：**  
`EXTRACT(YEAR FROM ...)` を使うと、日付から年だけを取り出して比較できます。  
年での絞り込みをしたいときにPostgreSQLなどでよく使われます。

（P60参照）

---

## 6. 電話番号が「03」「06」で始まらない顧客を表示してください（2通りの方法）

### ① NOT + OR のパターン

```sql
SELECT cust_id, cust_name, tel
FROM customer
WHERE NOT (tel LIKE '03%' OR tel LIKE '06%');
```

**解説：**  
`NOT (...)` で「03または06で始まる番号ではない」条件を指定しています。  
`LIKE '03%'` は「03から始まる文字列」を意味します（`%`はワイルドカード）。

（P60, P61参照）

---

### ② ANDで否定を2回書くパターン

```sql
SELECT cust_id, cust_name, tel
FROM customer
WHERE tel NOT LIKE '03%'
AND tel NOT LIKE '06%';
```

**解説：**  
こちらは個別に否定条件を2つ書くスタイルです。  
どちらでも同じ意味になりますが、シンプルで読みやすい方を選ぶのが良いです。

（P60, P61参照）

---
