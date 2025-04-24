# 5.1.2 実習：INSERT

## 1. 担当者表[employee]に、自分の情報を追加してください（担当者IDは100とする）。

```sql
INSERT INTO employee VALUES
(100, 10, '丸野 一夫', '1972-07-01', CURRENT_DATE, 1, 5000, NULL);
```

**解説：**  
`INSERT INTO` は、テーブルに新しいデータ（行）を追加する命令です。  
この場合、すべての列の順番通りに値を並べているため、列名は省略できます。  
`CURRENT_DATE` は今日の日付を自動的に入れてくれる関数です。  
`NULL` は「まだ値が決まっていない」ことを表す特別な値で、退職日などに使えます。  
文字列はシングルクォート `' '` で囲む必要があります。

（P110参照）

---

## 2. 担当者表[employee]のデータを使って、顧客表[customer]に一部の情報を追加してください。  
顧客ID ← 担当者IDに1000を加えた値、顧客名 ← 担当者名をコピー

```sql
INSERT INTO customer(cust_id, cust_name)
SELECT emp_id + 1000, emp_name FROM employee;
```

**解説：**  
`INSERT INTO customer(...)` は、customerテーブルの特定の列にだけデータを追加する書き方です。  
後半の `SELECT` 文は、employeeテーブルのデータを加工して取得しています。  
`emp_id + 1000` によって、既存のIDとかぶらないように顧客IDを作っています。  
`emp_name` をそのまま `cust_name` に入れて、担当者名を顧客名として使います。  
このように、別のテーブルのデータを元にして新しいデータを作ることができます。

（P110参照）

---
