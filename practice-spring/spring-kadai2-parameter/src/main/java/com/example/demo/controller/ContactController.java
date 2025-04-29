/**
 * Step1：名前とメールアドレスを入力できるお問い合わせ画面を作成しなさい。
 * Step2：名前が未入力だった場合、問い合わせフォーム画面でエラーメッセージを表示させなさい。
 * Step3：同時に複数のエラーチェックを可能にしてください。
 * Step4：お問い合わせの項目として、「種別」「言語」「詳細内容」「実施予定日」を追加しなさい。
 * Step5：お問い合わせの項目として、「言語」「実施予定日」のエラーチェックを追加しなさい。
 */

package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

// 別のModelクラスもあるのでインポート文に注意
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// コントローラーのアノテーションがないとinternalエラーになる
@Controller
public class ContactController {

	// GETリクエストで/contactのURLにアクセスしたときに表示する画面を指定
	@GetMapping("/contact")
	public String index() {

		// contactForm.htmlを表示
		return "contactForm";
	}

	// POSTリクエストで/contactのURLにアクセスしたときに表示する画面を指定
	@PostMapping("/contact")
	public String contact(
			// @RequestParamを使ってリクエストパラメータを取得
			@RequestParam(name = "genre", defaultValue = "") String genre,
			@RequestParam(name = "lang", defaultValue = "") String[] langList,
			@RequestParam(name = "detail", defaultValue = "") String detail,
			@RequestParam(name = "dueDate", defaultValue = "") LocalDate dueDate,
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "email", defaultValue = "") String email,
			// Model modelはリクエストパラメータを格納するためのオブジェクト
			Model model) {

		// エラーチェック用のリストを作成
		// List<String> errorListは、エラーが発生した場合にエラーメッセージを格納するためのリスト
		// new ArrayList<String>()は、空のArrayListを作成
		List<String> errorList = new ArrayList<>();
		if (langList.length == 0) {

			// addメソッドは、リストに追加するためのメソッド
			errorList.add("言語は必須です");
		}

		// dueDateはLocalDate型で、日付を取得するためのクラス
		// LocalDate.now()は、現在の日付を取得するためのメソッド
		LocalDate today = LocalDate.now();

		// compareToメソッドは、日付を比較するためのメソッド
		if (dueDate != null && dueDate.compareTo(today) <= 0) {
			errorList.add("実施予定日は翌日以降を選択してください");
		}
		if (name.length() == 0) {
			errorList.add("名前は必須です");
		} else if (name.length() > 20) {
			errorList.add("名前は20字以内で入力してください");
		}
		if (email.length() == 0) {
			errorList.add("メールアドレスは必須です");
		}

		// エラー発生時はお問い合わせフォームに戻す
		// size()メソッドは、リストの要素数を取得するためのメソッド
		if (errorList.size() > 0) {
			model.addAttribute("errorList", errorList);
			return "contactForm";
		}

		// addAttributeメソッドは、リクエストパラメータを格納するためのメソッド
		model.addAttribute("genre", genre);
		model.addAttribute("langList", langList);
		model.addAttribute("detail", detail);
		model.addAttribute("dueDate", dueDate);
		model.addAttribute("name", name);
		model.addAttribute("email", email);

		return "contactResult";
	}

	// GETリクエストで/training/{lang}のURLにアクセスしたときに表示する画面を指定
	@GetMapping("/training/{lang}")
	public String detail(

			// @PathVariableは、URLのパスに含まれる変数を取得するためのアノテーション
			@PathVariable("lang") String lang,
			Model model) {

		model.addAttribute("lang", lang);

		// langの値によって表示するメッセージを変更
		switch (lang) {
		case "Java":
			model.addAttribute("memo", "大規模開発でオールラウンドに活躍できるエンジニアを育成します");
			break;

		case "PHP":
			model.addAttribute("memo", "Webアプリケーションに特化して活躍できるエンジニアを育成します");
			break;

		case "Python":
			model.addAttribute("memo", "AI開発やデータ分析の領域で活躍できるエンジニアを育成します");
			break;
		}

		// training.htmlを表示
		return "training";
	}
}


/**
 *
 * 補足：
 *isAfter(date)	指定した date より後の日付かを判定	boolean	true → this > date（未来）
 *isBefore(date)	指定した date より前の日付かを判定	boolean	true → this < date（過去）
 *isEqual(date)	指定した date と同じ日付かを判定	boolean	true → 年月日すべて一致
 *compareTo(date)	指定した date との前後関係を数値で返す	int	0 = 同日、>0 = 後、<0 = 前
 *
 */