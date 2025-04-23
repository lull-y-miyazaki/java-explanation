# 5.2.2 実習：UPDATE

## 1. 部門IDが20以上30以下の部門の場所を「神奈川県川崎市」に更新してください。

```sql
UPDATE department
SET loc = '神奈川県川崎市'
WHERE dept_id BETWEEN 20 AND 30;
```

**解説：**  
`UPDATE` は、テーブルの中の値を変更する命令です。  
ここでは `department` テーブルの `loc` 列の値を変更しています。  
`WHERE dept_id BETWEEN 20 AND 30` は、dept_idが20～30の範囲にある行を指定します。  
その条件に合う行の `loc` の値をすべて「神奈川県川崎市」に書き換えます。

参照：p115~

---

## 2. 管理部門IDが40の部門の管理者IDを、最も給与が低い担当者のIDに変更してください。

```sql
UPDATE department
SET mgr_id = (
  SELECT emp_id FROM employee
  WHERE sal = (SELECT min(sal) FROM employee)
)
WHERE adept_id = 40;
```

**解説：**  
まず `SELECT min(sal) FROM employee` で最も給与が低い金額を調べています。  
その金額と一致する `sal` を持つ `emp_id`（担当者ID）を、次の `SELECT` で取り出しています。  
このようにして取り出した `emp_id` を、管理部門IDが40の行の `mgr_id` に設定します。  
つまり「一番給料が安い人のIDを、管理者IDとして登録する」更新です。  
他の表の情報をもとに、値を自動で更新できる点がポイント。

参照：p115~

---