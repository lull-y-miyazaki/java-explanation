package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;

@Controller
public class AccountController {
	// 初期画面表示
	@GetMapping("/account")
	public String index(Model model) {
		// 空のAccountオブジェクトを生成
		Account account = new Account();
		model.addAttribute("account", account);
		return "accountForm";
	}

	// 確認ボタンクリック時
	@PostMapping("/account/confirm")
	public String confirm(
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model) {

		// エラーチェック
		List<String> errorList = new ArrayList<>();
		if (name.length() == 0) {
			errorList.add("名前は必須です");
		} else if (name.length() > 20) {
			errorList.add("名前は20字以内で入力してください");
		}
		if (email.length() == 0) {
			errorList.add("メールアドレスは必須です");
		}
		if (password.length() == 0) {
			errorList.add("パスワードは必須です");
		}

		// 会員クラスのオブジェクト（モデル）を生成
		Account account = new Account(name, email, password);
		// Thymeleafに渡すデータ（モデル）を追加
		model.addAttribute("account", account);

		// エラー発生時はお問い合わせフォームに戻す
		if (errorList.size() > 0) {
			model.addAttribute("errorList", errorList);
			return "accountForm";
		}

		// accountConfirm.htmlを出力
		return "accountConfirm";
	}

	// 登録ボタンクリック時
	@PostMapping("/account")
	public String store(
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model) {

		// 会員クラスのオブジェクト（モデル）を生成
		Account account = new Account(name, email, password);
		// Thymeleafに渡すデータ（モデル）を追加
		model.addAttribute("account", account);
		// accountFinish.htmlを出力
		return "accountFinish";
	}
}
