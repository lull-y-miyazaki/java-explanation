/** Step1：商品一覧画面にキーワード検索を追加してください */
/** Step2：商品一覧画面に価格検索を追加してください */

package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	// SELECT * FROM items WHERE category_id = ?
	List<Item> findByCategoryId(Integer categoryId);

	// SELECT * FROM items WHERE name LIKE ?
	List<Item> findByNameContaining(String keyword);

	// SELECT * FROM items WHERE name LIKE ? AND price <= ?
	List<Item> findByNameContainingAndPriceLessThanEqual(String keyword, Integer maxPrice);

	// SELECT * FROM items WHERE price <= ?
	List<Item> findByPriceLessThanEqual(Integer maxPrice);
}
