/** Step1：会員登録画面を追加してください */
/** Step2：会員登録処理を追加してください */
/** Step3：会員登録時に以下の入力チェックを行ってください
 * エラーの場合、直前に入力されたテキストボックスの情報も保持されるパスワード欄のみは内容が保持されないようにする */
/** Step4：ログイン機能を追加してください
 * メールアドレスとパスワードが一致した場合はセッションスコープのaccountオブジェクトに「顧客IDと名前」を保持して、商品一覧画面にリダイレクトする
 * メールアドレスとパスワードが一致しなかった場合は、「メールアドレスとパスワードが一致しませんでした」のメッセージをログイン画面に出力する */


package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Customer;
import com.example.demo.model.Account;
import com.example.demo.repository.CustomerRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AccountController {

	@Autowired
	HttpSession session;

	@Autowired
	Account account;

	@Autowired
	CustomerRepository customerRepository;

	// ログイン画面を表示
	@GetMapping({ "/", "/login", "/logout" })
	public String index(
			@RequestParam(name = "error", defaultValue = "") String error,
			Model model) {
		// セッション情報を全てクリアする
		session.invalidate();
		// エラーパラメータのチェック
		if (error.equals("notLoggedIn")) {
			model.addAttribute("message", "ログインしてください");
		}

		return "login";
	}

	/** Step4：ログイン機能を追加してください */
	// ログインを実行
	@PostMapping("/login")
	public String login(
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model) {
		// 名前が空の場合にエラーとする
		if (email.length() == 0 || password.length() == 0) {
			model.addAttribute("message", "入力してください");
			return "login";
		}

		List<Customer> customerList = customerRepository.findByEmailAndPassword(email, password);
		if (customerList == null || customerList.size() == 0) {
			// 存在しなかった場合
			model.addAttribute("message", "メールアドレスとパスワードが一致しませんでした");
			return "login";
		}

		// 存在した場合
		// get(0)で最初の要素を取得
		// 1件しか取得しないので、最初の要素を取得する
		Customer customer = customerList.get(0);

		// セッション管理されたアカウント情報にIDと名前をセット
		account.setId(customer.getId());
		account.setName(customer.getName());

		// 「/items」へのリダイレクト
		return "redirect:/items";
	}

	/** Step1：会員登録画面を追加してください */
	// 会員登録画面の表示
	@GetMapping("/account")
	public String create() {
		return "accountForm";
	}

	/** Step2：会員登録処理を追加してください */
	/** Step3：会員登録時に以下の入力チェックを行ってください */
	// 会員登録実行
	@PostMapping("/account")
	public String store(
			@RequestParam("name") String name,
			@RequestParam("address") String address,
			@RequestParam("tel") String tel,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model) {

		// エラーチェック
		List<String> errorList = new ArrayList<>();
		if (name.length() == 0) {
			errorList.add("名前は必須です");
		}
		if (address.length() == 0) {
			errorList.add("住所は必須です");
		}
		if (address.length() == 0) {
			errorList.add("電話番号は必須です");
		}
		if (email.length() == 0) {
			errorList.add("メールアドレスは必須です");
		}
		// メールアドレス存在チェック
		List<Customer> customerList = customerRepository.findByEmail(email);
		if (customerList != null && customerList.size() > 0) {
			// 登録済みのメールアドレスが存在した場合
			errorList.add("登録済みのメールアドレスです");
		}
		if (password.length() == 0) {
			errorList.add("パスワードは必須です");
		}

		// エラー発生時はお問い合わせフォームに戻す
		if (errorList.size() > 0) {
			model.addAttribute("errorList", errorList);
			model.addAttribute("name", name);
			model.addAttribute("address", address);
			model.addAttribute("tel", tel);
			model.addAttribute("email", email);
			return "accountForm";
		}

		Customer customer = new Customer(name, address, tel, email, password);
		customerRepository.save(customer);

		return "redirect:/";
	}
}

/**

* 補足：

 * return "accountForm"
→ 今いるControllerのメソッド内で 直接テンプレート名を返す
→ URLは変わらないので、Controllerのメソッドは通らない
※ オブジェクト渡しが必要な場合は、直接 return の前に model に詰める必要がある

 * return "redirect:/account"
→ クライアント（ブラウザ）に、もう一度アクセスし直しなおさせる
→ URLが変わるので、Controllerの別メソッドを通る
→ （@GetMapping("/account") などに再度アクセスされる）
※ リダイレクト先の Controller メソッドで再取得・再生成が必要（または RedirectAttributes を使う）

 */