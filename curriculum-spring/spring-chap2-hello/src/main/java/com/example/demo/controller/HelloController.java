package com.example.demo.controller;

import org.springframework.stereotype.Controller; //アノテーション記述後に自動補完
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping; //アノテーション記述後に自動補完
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //Controllerを表すアノテーション
public class HelloController {
	@GetMapping({ "/", "/test" }) //GETリクエストを受け取るURLの指定
	public String index() {

		return "hello"; //hello.htmlを出力する
	}

	@GetMapping("/hello")
	public String hello(@RequestParam("msg") String message, Model model) {
		// 画面に情報を渡す
		model.addAttribute("memo", message);
		// hello.htmlの出力
		return "hello";
	}

	@PostMapping("/hello")
	public String helloByPost(@RequestParam("msg") String message, Model model) {
		// 画面に情報を渡す
		model.addAttribute("memo", message);
		// helloPost.htmlの出力
		return "helloPost";
	}

}
