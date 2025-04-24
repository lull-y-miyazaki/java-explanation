# 4.4.4 実習：結合

## 1. 売上NOが3の顧客の名前・住所・届け予定日を表示してください。

```sql
SELECT cust_name, cust_address, delivery_date
  FROM packedsales ps JOIN customer c ON ps.cust_id = c.cust_id
  WHERE ps.psales_no = 3;
```

**解説：**  
これは内部結合（INNER JOIN）で、両方の表に一致するcust_idがあるデータのみ取得します。  
`JOIN` はON句で結合条件を明示し、主キーと外部キーの関係を使っています。  
売上NOが3の行だけを `WHERE` で絞り込みます。  
`USING` や `NATURAL JOIN` は別構文での同様の内部結合です。

カリキュラム：p79,p80~

---

## 2. 数量が3以上の商品の売上額（数量×単価）を表示してください。

```sql
SELECT prod_name, price * quantity AS amount
  FROM sales s JOIN product p ON s.prod_id = p.prod_id
  WHERE quantity >= 3;
```

**解説：**  
`JOIN` は内部結合で、売上明細と商品情報をprod_idで結びます。  
売上額を `price * quantity` で計算し、列名に `AS amount` を使用。  
`WHERE` で数量が3以上の商品を対象にしています。  
`USING` や `NATURAL JOIN` でも同じ結果が得られます。

カリキュラム：p79,p80~

---

## 3. 顧客名が「田中」で始まる売上と明細情報を表示してください。

```sql
SELECT p.psales_no, p.psales_date, p.total, s.prod_id, s.quantity, s.price
  FROM packedsales p JOIN sales s ON p.psales_no = s.psales_no
                     JOIN customer c ON p.cust_id = c.cust_id
  WHERE c.cust_name LIKE '田中%'
  ORDER BY p.psales_no;
```

**解説：**  
複数の内部結合（JOIN）を使い、売上・顧客・明細表を結びます。  
`LIKE '田中%'` で顧客名が「田中」で始まるデータを抽出。  
`JOIN`はそれぞれ外部キーと主キーでつなげます。  
SELECTで指定した複数項目を出力しています。

カリキュラム：p79,p80~

---

## 4. 担当者ごとの平均売上金額と名前を表示してください。

```sql
SELECT e.emp_id, e.emp_name, avg(ps.total)
  FROM packedsales ps JOIN employee e ON ps.emp_id = e.emp_id
  GROUP BY e.emp_id, e.emp_name
  ORDER BY e.emp_id;
```

**解説：**  
内部結合で売上と担当者をemp_idで結びます。  
`GROUP BY`で担当者ごとにグループ化し、`avg`で平均売上を計算。  
集計関数とJOINを組み合わせた基本的な分析SQLです。

カリキュラム：p65~,p79,p80~

---

## 5. 売価合計が50万円以上の商品の情報を表示してください。

```sql
SELECT p.prod_id, p.prod_name, sum(s.quantity), sum(s.price)
  FROM sales s JOIN product p ON s.prod_id = p.prod_id
  GROUP BY p.prod_id, p.prod_name
  HAVING sum(s.price) >= 500000
  ORDER BY p.prod_id;
```

**解説：**  
内部結合で明細と商品を結び、商品ごとの合計を集計します。  
`HAVING`は集計後の条件指定に使用。  
`GROUP BY`はprod_idとprod_nameのセットが必須です。

カリキュラム：p65~,p70~,p79,p80~

---

## 6. 商品名ごとに売上額の合計を降順で表示してください。

```sql
SELECT prod_name, sum(price * quantity) AS total
  FROM sales s JOIN product p ON s.prod_id = p.prod_id
  GROUP BY prod_name
  ORDER BY total DESC;
```

**解説：**  
内部結合で売価と数量を結び、売上額を計算して合計します。  
`GROUP BY`で商品ごとに集計し、`ORDER BY`で多い順に並べます。  
`AS total`で列名を分かりやすくしています。

カリキュラム：p65~,p70~,p79,p80~

---

## 7. 売上NOが3の顧客と商品情報をまとめて表示してください。

```sql
SELECT cust_name, cust_address, delivery_date, prod_name, quantity
  FROM packedsales ps JOIN customer c ON ps.cust_id = c.cust_id
                      JOIN sales s ON ps.psales_no = s.psales_no
                      JOIN product p ON s.prod_id = p.prod_id
  WHERE ps.psales_no = 3;
```

**解説：**  
4つの表をすべて内部結合で結び、売上NO=3のデータに限定。  
それぞれ主キーと外部キーの組合せで結合しています。  
3つ以上のテーブルを JOIN でつなげていく構文です。

カリキュラム：p79,p80~

---

## 8. 顧客住所と部門の場所を1つの表にまとめて表示してください（UNION）。

```sql
SELECT address FROM customer
UNION
SELECT loc FROM department;
```

**解説：**  
`UNION`は縦にデータを結合し、重複を自動で排除します。  
列のデータ型と数が一致している必要があります。  
異なる表から似た形式のデータをまとめたいときに使います。

カリキュラム：p92~

---

## 9. 偶数商品は5%引き、奇数商品は定価の売価を表示してください。

```sql
SELECT *, cost * COALESCE(discount, 1) * 0.95 FROM product WHERE prod_id % 2 = 0
UNION
SELECT *, cost * COALESCE(discount, 1) FROM product WHERE prod_id % 2 = 1
ORDER BY 6 DESC;
```

**解説：**  
`COALESCE`でNULLの割引率を1として補完。  
`%`演算子で偶数・奇数を判定し、`UNION`でまとめています。  
値引きと定価を分けた処理の合成例です。

カリキュラム：p92~

---

## 10. 特定の条件に当てはまらない売上データをEXCEPTで表示してください。

```sql
SELECT psales_no, emp_id, cust_id, cust_address FROM packedsales
EXCEPT
SELECT psales_no, emp_id, cust_id, cust_address FROM packedsales
WHERE psales_no BETWEEN 200 AND 800
   OR emp_id IN (2, 4)
   OR cust_id = 2;
```

**解説：**  
`EXCEPT`は1つ目の結果から2つ目の結果を引いた差集合を返します。  
特定条件のデータを除外したい場合に有効です。  
`BETWEEN`, `IN`, `OR`など複合条件と合わせて使います。

カリキュラム：p92~
