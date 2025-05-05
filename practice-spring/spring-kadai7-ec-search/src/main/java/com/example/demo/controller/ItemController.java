package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.model.Account;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;

@Controller
public class ItemController {

	@Autowired
	Account account;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ItemRepository itemRepository;

	// 商品一覧表示
	@GetMapping("/items")
	public String index(
			@RequestParam(value = "categoryId", defaultValue = "") Integer categoryId,
			@RequestParam(value = "keyword", defaultValue = "") String keyword,
			@RequestParam(value = "maxPrice", defaultValue = "") Integer maxPrice,
			Model model) {

		// 全カテゴリー一覧を取得
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categories", categoryList);

		/** Step1：商品一覧画面にキーワード検索を追加してください */
		/** Step2：商品一覧画面に価格検索を追加してください */
		// 商品一覧情報の取得
		List<Item> itemList = null;
		if (keyword.length() > 0 && maxPrice != null) {

			// 商品名かつ価格検索
			itemList = itemRepository.findByNameContainingAndPriceLessThanEqual(keyword, maxPrice);
		} else if (keyword.length() > 0) {

			// itemsテーブルを商品名で部分一致検索
			itemList = itemRepository.findByNameContaining(keyword);
		} else if (maxPrice != null) {

			// itemsテーブルを指定価格以下で検索
			itemList = itemRepository.findByPriceLessThanEqual(maxPrice);
		} else if (categoryId != null) {

			// itemsテーブルをカテゴリーIDを指定して一覧を取得
			itemList = itemRepository.findByCategoryId(categoryId);
		} else {

			// 全商品一覧
			itemList = itemRepository.findAll();
		}

		/** Step3：検索結果が出力されたとき、検索条件がテキストボックスに保持されるようにしてください */
		model.addAttribute("keyword", keyword);
		model.addAttribute("maxPrice", maxPrice);
		model.addAttribute("items", itemList);

		return "items";
	}

	/** Step4：商品一覧の「商品名」をリンクにしなさい */
	/** Step5：商品詳細の画面を作成し表示しなさい */
	@GetMapping("/items/{id}")
	public String show(
			// PathVariableはURLの変数を取得する
			@PathVariable("id") Integer id,
			Model model) {

		// 主キー検索
		Item item = itemRepository.findById(id).get();
		model.addAttribute("item", item);

		return "itemDetail";
	}
}
