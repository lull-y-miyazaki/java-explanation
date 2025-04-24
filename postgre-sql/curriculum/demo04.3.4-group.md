# 4.3.4 実習：グループ集計

## 1. 商品表[product]から、標準単価[cost]の合計・平均・最小値・最大値を照会してください。

```sql
SELECT sum(cost), avg(cost), min(cost), max(cost) FROM product;
```

**解説：**  
全商品の標準単価（cost）について、合計・平均・最小・最大をまとめて計算します。  
集計関数 `sum`, `avg`, `min`, `max` を使う基本パターンです。

カリキュラム：p65~

---

## 2. 商品表[product]から、行数・割引率[discount]の統計情報（合計・平均など）を照会してください。

```sql
SELECT count(*), count(discount), count(DISTINCT discount),
       sum(discount), avg(discount), min(discount), max(discount)
FROM product;
```

**解説：**  
`count(*)`は全体の行数、`count(discount)`はNULL以外の件数を取得。  
`DISTINCT`は「重複を取り除いた値のみ」を対象に数えます。

カリキュラム：p65~

---

## 3. 商品表[product]から、限界割引率[discount]ごとに個数・合計・平均・最小・最大を照会してください。

```sql
SELECT discount, count(discount), sum(discount), avg(discount),
       min(discount), max(discount)
FROM product
GROUP BY discount
ORDER BY discount;
```

**解説：**  
`GROUP BY`で割引率ごとにデータをグループ分けし、集計を行います。  
`ORDER BY`で割引率の昇順に並べています。

カリキュラム：p65~,p70~

---

## 4. 割引率[discount]ごとに集計し、「5件未満のグループ」は除いて表示してください。

```sql
SELECT discount, count(discount), sum(discount), avg(discount),
       min(discount), max(discount)
FROM product
GROUP BY discount
HAVING count(discount) >= 5
ORDER BY discount;
```

**解説：**  
`HAVING`はグループ化された後の集計結果に条件を付けるために使います。  
ここでは「5件以上のグループのみ」を表示しています。

カリキュラム：p65~,p70~

---

## 5. 標準単価[cost]が15000円以上の商品だけを対象に、割引率[discount]ごとの集計を行ってください。

```sql
SELECT discount, count(discount), sum(discount), avg(discount),
       min(discount), max(discount)
FROM product
WHERE cost >= 15000
GROUP BY discount
ORDER BY discount;
```

**解説：**  
`WHERE`で条件を指定すると、対象行を集計前に絞ることができます。  
今回は「単価が15000円以上」の商品のみ対象としています。

カリキュラム：p65~,p70~

---

## 6. 売上表[packedsales]から、担当者ID[emp_id]ごとの売上金額[total]の平均を表示してください。

```sql
SELECT emp_id, avg(total)
FROM packedsales
GROUP BY emp_id
ORDER BY emp_id;
```

**解説：**  
`GROUP BY`で担当者ごとに売上をまとめ、`avg`で平均を計算します。  
`ORDER BY`でID順に並び替えています。

カリキュラム：p70~

---

## 7. 売上日[psales_date]ごとの売上合計金額[total]を集計し、多い順に5件表示してください。

```sql
SELECT psales_date, sum(total)
FROM packedsales
GROUP BY psales_date
ORDER BY 2 DESC
LIMIT 5;
```

**解説：**  
`ORDER BY 2`は「2列目（sum）」を降順で並べる意味です。  
`LIMIT 5`で上位5件だけを表示します。

カリキュラム：p70~

---

## 8. 売上表[packedsales]から、重複を除いた担当者ID[emp_id]の一覧を表示してください。

```sql
SELECT DISTINCT emp_id FROM packedsales;
```

**解説：**  
`DISTINCT`は同じ値を1つにまとめて、重複を除いた一覧にできます。  
このSQLで、担当者IDを重複なく表示できます。

カリキュラム：p74~