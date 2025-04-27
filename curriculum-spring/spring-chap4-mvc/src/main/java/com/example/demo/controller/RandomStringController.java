package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.RandomStringService;

@Controller
public class RandomStringController {

	@Autowired // 直後のクラスのインスタンスを自動で生成して利用できるようにする
	RandomStringService service; // 文字列をランダムに生成するクラス

	@GetMapping("/random")
	public String index() {
		return "random";
	}

	@PostMapping("/random")
	public String generate(

			@RequestParam("charLength") int charLength,
			@RequestParam(name = "withNumber", defaultValue = "false") boolean withNumber,
			Model model) {

		// 「文字列の長さ」と「数値を含むかどうか」
		List<String> list = service.generate(charLength, withNumber);

		model.addAttribute("randList", list);

		return "random";
	}
}
