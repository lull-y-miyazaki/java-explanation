-- Step0：（準備）プロジェクトを作成後、「application.properties」「schema.sql」「data.sql」を
-- サンプルプロジェクトの「spring-chap7-jpa」よりコピーしてきます

-- テーブル削除
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS items;

-- カテゴリーテーブル
CREATE TABLE categories
(
   id SERIAL PRIMARY KEY,
   name TEXT
);
-- 商品テーブル
CREATE TABLE items
(
   id SERIAL PRIMARY KEY,
   category_id INTEGER,
   name TEXT,
   price INTEGER
);