package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;
import com.example.demo.model.Post;
import com.example.demo.model.PostList;

import jakarta.servlet.http.HttpSession;

@Controller
public class BlogController {

	@Autowired
	HttpSession session; // セッションスコープ全体

	@Autowired
	Account account;

	@Autowired
	PostList postList;

	// ログイン画面の表示
	@GetMapping({ "/", "/logout" })
	public String index() {
		// 全セッション情報の破棄
		session.invalidate();
		return "login";
	}

	// ログインボタンクリック時
	@PostMapping("/login")
	public String login(
			@RequestParam("name") String name) {

		// セッションスコープに保持されたアカウント情報に名前をセット
		account.setName(name);

		return "blog";
	}

	// 投稿するボタンクリック時
	@PostMapping("/blog")
	public String posts(
			@RequestParam("title") String title,
			@RequestParam("content") String content) {

		// セッションスコープに保持された投稿リストを取得
		List<Post> allPosts = postList.getPosts();
		// 受け取ったパラメータ（投稿データ）をリストに追加
		allPosts.add(new Post(title, content));

		return "blog";
	}
}