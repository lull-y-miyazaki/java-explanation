package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;

	// 一覧画面の表示
	@GetMapping("/categories")
	public String index(Model model) {

		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categories", categoryList);

		return "categories";
	}

	// 新規登録画面の表示
	@GetMapping("/categories/add")
	public String create() {
		return "addCategory";
	}

	// 新規登録処理
	@PostMapping("/categories/add")
	public String store(
			@RequestParam(value = "name", defaultValue = "") String name) {

		// オブジェクトの生成
		Category category = new Category(name);
		// テーブルへの反映（INSERT）
		categoryRepository.save(category);
		// 「/categories」にGETでリクエストし直せ（リダイレクト）
		return "redirect:/categories";
	}

	// 更新画面表示
	@GetMapping("/categories/{id}/edit")
	public String edit(@PathVariable("id") Integer id, Model model) {

		// テーブルをID（主キー）で検索
		Category category = categoryRepository.findById(id).get();
		model.addAttribute("category", category);

		return "editCategory";
	}

	// 更新処理
	@PostMapping("/categories/{id}/edit")
	public String update(
			@PathVariable("id") Integer id,
			@RequestParam(value = "name", defaultValue = "") String name) {

		// テーブルをID（主キー）で検索
		Category category = categoryRepository.findById(id).get();
		// セッターを利用して、カテゴリーオブジェクトのフィールドを書きかえる
		category.setName(name);

		// テーブルへの反映（UPDATE）
		categoryRepository.save(category);
		// 「/categories」にGETでリクエストし直せ（リダイレクト）
		return "redirect:/categories";
	}

	// 削除処理
	@PostMapping("/categories/{id}/delete")
	public String delete(@PathVariable("id") Integer id) {

		// テーブルから削除（DELETE）
		categoryRepository.deleteById(id);
		// 「/categories」にGETでリクエストし直せ（リダイレクト）
		return "redirect:/categories";
	}

}
