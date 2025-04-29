/**
 * Step6：投稿時に未入力チェックを追加してください
 * Step7：投稿する項目に「気分」を追加できるようにしてください。絵文字を利用します。
 * Step8：内容にURLが存在した場合、リンクを自動生成しなさい
 * (内容の先頭が「http://」または「https://」から始まっている場合はリンクにする)
 */

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
			@RequestParam("name") String name,
			Model model) {

		// セッションスコープに保持されたアカウント情報に名前をセット
		account.setName(name);

		return "blog";
	}

	// 投稿するボタンクリック時
	@PostMapping("/blog")
	public String posts(
			@RequestParam("title") String title,
			@RequestParam("feeling") String feeling,
			@RequestParam("content") String content,
			Model model) {

		// Step6：engthで0で長さを取得し、0の場合はエラーメッセージを表示する
		if (title.length() == 0 || content.length() == 0) {

			// addAttributeでHTMLに渡す
			model.addAttribute("error", "タイトルと書き込み内容を入力してください");
			return "blog";
		}

		// PostListクラスにあるgetPostsメソッドを使用
		List<Post> allPosts = postList.getPosts();

		// 受け取ったパラメータ（投稿データ）をリストに追加
		allPosts.add(new Post(title, feeling, content));

		return "blog";
	}
}

/**
 * 補足：
 *
 * PostListクラスがなかった場合は下記のようになる：
 * List<Post> allPosts = new ArrayList<>();
 ** Postのインスタンスを作成して追加
 * Post post = new Post("タイトル1", "本文の内容です");
 * allPosts.add(post);
 *
 ** もしくは1行で書くことも可能
 * allPosts.add(new Post("タイトル2", "別の投稿本文"));
 *
 * PostListクラスがなかった場合は下記のようになる（DBあった場合）：
 * List<Post> posts = postRepository.findAll();
 *
 ** 追加
 * Post post = new Post("新しいタイトル", "新しい本文");
 * postRepository.save(post);
 */