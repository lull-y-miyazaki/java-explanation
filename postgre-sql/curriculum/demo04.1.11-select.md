# 4.1.11 実習：SELECT句

## 1. 商品表[product]を全て紹介してください。

```sql
SELECT * FROM product;
```

**解説：**  
`SELECT` はデータベースから情報を取り出す命令です。  
`*`（アスタリスク）は「すべての列」を意味するワイルドカードです。  
つまりこのSQLは、productテーブルにあるすべての列とすべての行を表示する命令です。  
表の中身を最初にざっくり確認したいときによく使います。

（P33参照）

---

## 2. 商品表[product]から商品名、標準単価、限界割引率を紹介してください。

```sql
SELECT prod_name, cost, discount FROM product;
```

**解説：**  
`SELECT` のあとに表示したい列名をカンマ区切りで指定することで、必要な情報だけを取り出せます。  
ここでは、商品名（prod_name）、標準単価（cost）、限界割引率（discount）という3つの列だけを表示します。  
`*` を使わずに列を明示することで、無駄なデータを省くことができ、表示も見やすくなります。

（P33参照）

---

## 3. 割引価格（価格×割引率）を「割引価格」という列名で表示してください。

```sql
SELECT prod_name, cost, discount, cost * discount AS 割引価格 FROM product;
```

**解説：**  
列の値同士を `*` で掛け算すると、計算結果を新しく作ることができます。  
このSQLでは、標準単価（cost）と限界割引率（discount）を掛け算して、割引後の価格を求めています。  
`AS 割引価格` によって、その計算結果に「割引価格」という分かりやすい列名をつけています。  
こうすることで、計算結果が何を意味しているのかが明確になります。

（P35参照）

---

## 4. 割引率がNULLなら1として計算し、割引価格を表示してください。

```sql
SELECT prod_name, cost, discount, cost * COALESCE(discount, 1) AS 割引価格 FROM product;
```

**解説：**  
`discount` が NULL の場合、そのまま掛け算すると結果も NULL になります。  
`COALESCE(discount, 1)` は「discountがNULLなら代わりに1を使う」という意味です。  
1を使うことで「割引がない＝定価で販売する」という扱いになります。  
これにより、NULLが含まれていても安全に割引価格を計算できます。

（P41参照）

---

## 5. 割引価格を3桁区切り・小数点2位で表示してください。

```sql
SELECT prod_name, cost, discount,
       to_char(cost * COALESCE(discount, 1), '99G999D99') AS 割引価格
FROM product;
```

**解説：**  
`to_char` 関数は、数値を「文字列」として見た目を整えて表示するために使います。  
書式 `'99G999D99'` の中で、`G` は3桁区切りのカンマ、`D` は小数点を表します。  
たとえば「12345.67」は「12,345.67」のように表示されます（ロケールが日本ならG=カンマ, D=ピリオド）。  
このように表示形式を整えることで、金額などを読みやすくすることができます。

（P37，41参照）

---

## 6-① 割引価格を降順で並べて表示してください（式を使うパターン）。

```sql
SELECT prod_name, cost, discount,
       to_char(cost * COALESCE(discount, 1), '99G999D99') AS 割引価格
FROM product
ORDER BY cost * COALESCE(discount, 1) DESC;
```

**解説：**  
`ORDER BY` は表示する順番を指定する命令です。  
ここでは、割引価格（計算式）を基準にして、数値が大きい順（DESC）に並べています。  
文字列として整形された割引価格ではなく、元の数値を使って並び替えている点がポイントです。  
計算式をそのまま `ORDER BY` に使うことで、正確に数値順に並べられます。

（P37，41，45参照）

---

## 6-② 割引価格を降順で並べて表示してください（列番号を使うパターン）。

```sql
SELECT prod_name, cost, discount,
       to_char(cost * COALESCE(discount, 1), '99G999D99') AS 割引価格
FROM product
ORDER BY 4 DESC;
```

**解説：**  
`ORDER BY 4` は、「SELECTで指定した4番目の列」で並べるという意味です。  
この場合、4番目の列は割引価格なので、それを使って降順に表示します。  
列番号で指定するとSQLが短くなりますが、列の順番が変わると誤動作するため注意が必要です。

---

## 7. 割引価格のベスト3を表示してください。

```sql
SELECT prod_name, cost, discount,
       to_char(cost * COALESCE(discount, 1), '99G999D99') AS 割引価格
FROM product
ORDER BY 4 DESC
LIMIT 3;
```

**解説：**  
`LIMIT` は表示する件数を制限する命令で、ここでは上位3件のみ表示します。  
`ORDER BY 4 DESC` によって、割引価格が高い順に並び替えた後、  
そのうち上から3件だけを出力します。  
ランキング表示やおすすめ商品の上位を出したいときによく使います。

（P37，41，45，48参照）
