# 10.4.2 実習：DROP TABLE（テーブルの削除）

---

## 1. 顧客表[customer]を削除してください。

```sql
DROP TABLE customer CASCADE;
```

**解説：**  
- `DROP TABLE` は、指定したテーブル自体を完全に削除するSQL命令です。  
- `CASCADE` オプションを付けると、そのテーブルを参照している外部キー制約や他の依存オブジェクトも一緒に削除されます。  
- たとえば、`packedsales` テーブルが `customer.cust_id` を外部キーで参照している場合、  
  通常の `DROP TABLE customer;` ではエラーになりますが、`CASCADE` を付ければ削除可能です。

**補足：**  
誤って重要なテーブルや依存関係を削除しないように、`CASCADE` の使用には注意が必要です。  
事前に `\d customer` などで依存関係を確認すると安全です。

（P179参照）

---

