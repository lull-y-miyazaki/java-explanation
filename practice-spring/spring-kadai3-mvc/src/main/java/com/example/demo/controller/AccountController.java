/**
 * Step1：MVCモデルを利用し、会員登録画面と確認画面を作成しなさい
 * Step2：入力値のチェック処理を入れてください
 * Step3：入力エラー時は、エラーメッセージの表示とともにテキストボックスに「名前」を残るようにしなさい
（テキストボックスの保持にAccountクラスを利用しないパターン）※addAttributeで可能
 * Step4：「名前」「メールアドレス」「パスワード」の入力エラー時は、エラーメッセージの表示とともにテキストボックスに情報が残るようにしなさい
（テキストボックスの保持にAccountクラスを利用するパターン）※accountオブジェクトを作成後にreturnで可能
 * Step5：確認画面に登録ボタンを配置し、登録完了画面に遷移できるようにしなさい
 */

package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

// 別のModelクラスもあるのでインポート文に注意
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;

// コントローラーのアノテーションがないとinternalエラーになる
@Controller
public class AccountController {

	// GETリクエストで/accountのURLにアクセスしたときに表示する画面を指定
	@GetMapping("/account")
	public String index(Model model) {
		// Model modelはリクエストパラメータを格納するためのオブジェクト

		// 空のAccountオブジェクトを生成
		Account account = new Account();

		// addAttributeメソッドでHTMLに渡すデータ（モデル）を追加
		model.addAttribute("account", account);
		return "accountForm";
	}

	// 確認ボタンクリック時
	// POSTリクエストで/account/confirmのURLにアクセスしたときに表示する画面を指定
	@PostMapping("/account/confirm")
	public String confirm(

			// @RequestParamを使ってリクエストパラメータを取得
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model) {

		// エラーチェック
		// List<String> errorListは、エラーが発生した場合にエラーメッセージを格納するためのリスト
		// new ArrayList<>()は、空のArrayListを作成
		// <>は自動で型を推測してくれている
		List<String> errorList = new ArrayList<>();

		// length()は、文字列の長さを取得するためのメソッド
		if (name.length() == 0) {

			// addメソッドは、リストに追加するためのメソッド
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
