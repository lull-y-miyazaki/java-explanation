package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Controller
public class AccountController {

	@Autowired
	private HttpSession session;

	@Autowired
	private UserRepository userRepository;

	// ログイン画面の表示
	@GetMapping({ "/", "/login", "/logout" })
	public String index(
			@RequestParam(defaultValue = "") String error,
			Model model) {

		// セッション情報をクリア
		session.invalidate();

		// エラーチェック
		if (error.equals("notLoggedIn")) {
			model.addAttribute("message", "ログインしてください");
		}

		return "login";
	}

	// ログインの処理内容
	@PostMapping("/login")
	public String login(
			@RequestParam String email,
			@RequestParam String password,
			Model model) {

		// email または password が空の場合にエラーメッセージを表示
		if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
			model.addAttribute("message", "メールアドレスとパスワードを入力してください");
			return "login";
		}

		// データーベースからユーザー情報を取得
		User user = userRepository.findByEmailAndPassword(email, password);

		// email または password が正しくない場合にエラーメッセージを表示
		if (user == null) {
			model.addAttribute("message", "メールアドレスまたはパスワードが正しくありません");
			return "login";
		}

		session.setAttribute("user", user);

		return "redirect:/users";
	}
}