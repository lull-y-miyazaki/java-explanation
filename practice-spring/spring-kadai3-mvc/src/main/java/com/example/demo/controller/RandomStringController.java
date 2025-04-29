/**
 * Step6：ランダム文字列の生成する個数を画面から入力できるようにしなさい
 * Step7：「英字を含める」チェックボックスを追加しなさい
 */

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

	// @Autowiredアノテーションを使って、Springにオブジェクトを管理させる
	// 便利になるんだなで大丈夫！気なるなら自分で調べてみて！って感じでOK
	@Autowired
	RandomStringService service;

	// ランダム文字列の生成画面を表示
	@GetMapping("/random")
	public String index() {
		return "random";
	}

	// 作成するボタンをクリックしたとき
	@PostMapping("/random")
	public String generate(
			@RequestParam("charLength") int charLength,
			@RequestParam(name = "withNumber", defaultValue = "false") boolean withNumber,
			@RequestParam(name = "withAlphabet", defaultValue = "false") boolean withAlphabet,
			@RequestParam(name = "createCount", defaultValue = "1") Integer createCount,
			Model model) {

		// ランダム文字列のListを生成
		// serviceクラスのgenerateメソッドを呼び出す
		// 引数は、charLength, withNumber, withAlphabet, createCount
		// 戻り値は複数あるのでList型で受取り、List型の変数listに格納
		List<String> list = service.generate(charLength, withNumber, withAlphabet, createCount);

		// Step8 条件の引継ぎ
		model.addAttribute("charLength", charLength);
		model.addAttribute("withNumber", withNumber);
		model.addAttribute("withAlphabet", withAlphabet);
		model.addAttribute("createCount", createCount);

		model.addAttribute("randList", list);

		return "random";
	}
}
