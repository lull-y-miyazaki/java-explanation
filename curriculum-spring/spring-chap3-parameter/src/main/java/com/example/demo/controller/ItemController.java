package com.example.demo.controller; // package宣言

import java.time.LocalDate; // 日付を扱うためのクラス

import org.springframework.stereotype.Controller; // アノテーションを使うためにコントローラーと認識させる
import org.springframework.ui.Model; // Modelクラスを使うことでview(HTML)にデータを渡せるように
import org.springframework.web.bind.annotation.GetMapping; // HTTPのGETリクエストを処理する
import org.springframework.web.bind.annotation.PathVariable; // URLのパスパラメータを取得できる
import org.springframework.web.bind.annotation.PostMapping;// HTTPのPOSTリクエストを処理する
import org.springframework.web.bind.annotation.RequestParam; // フォームデータ(nameとか)を取得できる

@Controller // Controllerのアノテーション
public class ItemController {

	// itemForm.html(登録画面)の表示
	@GetMapping("/")
	public String index() {

		return "itemForm";
	}

	//
	@PostMapping("/item")
	public String confirm(
			// ブラウザからのリクエストの値（パラメータ）を取得することができるアノテーション
			@RequestParam(name = "name", defaultValue = "未設定") String name, // String nameは型定義
			@RequestParam(name = "price", defaultValue = "100") int price, // int priceは型定義
			Model model) {

		// model.addAttribute(キー, 値); Controller から View(Thymeleaf)にデータを渡すためのメソッド
		model.addAttribute("name", name); // 取得した name を Thymeleaf に渡す
		model.addAttribute("price", price); // 取得した price を Thymeleaf に渡す

		return "itemConfirm"; // itemConfirm.html(確認画面)の表示
	}

	// hiddenでパラメーターを隠して送信する場合
	@GetMapping("/item/hidden")
	public String itemFormHidden() {
		return "itemFormHidden";
	}

	// パスパラメータ
	@GetMapping("/item/{id}")
	public String show(
			@PathVariable("id") int id, // パスパラメータで取得した商品IDを格納
			Model model) {

		// switchで商品idに応じて表示を変更する
		switch (id) {
		case 101:
			// model.addAttribute(キー, 値); Controller から View(Thymeleaf)にデータを渡すためのメソッド
			model.addAttribute("name", "ボールペン");
			model.addAttribute("price", 100);
			break;
		case 102:
			model.addAttribute("name", "消しゴム");
			model.addAttribute("price", 50);
			break;
		default:
			model.addAttribute("name", "未設定");
			model.addAttribute("price", 0);
			break;
		}

		return "itemConfirm";
	}

	@GetMapping("/item/detail")
	public String detail() {
		return "itemDetailForm"; // itemDetailForm.html(商品詳細登録)の表示
	}

	// itemDetailConfirm.html(商品詳細確認)の表示
	@PostMapping("/item/detail")
	public String confirmDetail(
			// ブラウザからのリクエストの値（パラメータ）を取得することができるアノテーション
			@RequestParam(name = "name", defaultValue = "未設定") String name,
			@RequestParam(name = "price", defaultValue = "") Integer price,
			@RequestParam(name = "categoryId", defaultValue = "") Integer categoryId,
			@RequestParam(name = "genre", defaultValue = "") String[] genreList,
			@RequestParam(name = "releaseDate", defaultValue = "") LocalDate releaseDate,
			Model model) {

		// model.addAttribute(キー, 値); Controller から View(Thymeleaf)にデータを渡すためのメソッド
		model.addAttribute("name", name);
		model.addAttribute("price", price);
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("genreList", genreList);
		model.addAttribute("releaseDate", releaseDate);

		return "itemDetailConfirm";
	}

}
