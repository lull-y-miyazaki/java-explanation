/**
 * Step1：商品追加用の画面を作成しなさい
 * Step2：商品を1つだけ追加できるようにしてください
 * Step3：セッションスコープで管理されたカートクラスを作成し利用しなさい(これまで一個しかできなかったのを、複数商品を追加できるようにする）
 * Step4：カートの商品一覧をクリア（全削除）できるようにしてください
 * Step5：名前によるログイン・ログアウト処理を追加しなさい
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
import com.example.demo.model.Cart;
import com.example.demo.model.Item;

// HttpSessionは、HTTPリクエストのセッションを管理するためのインターフェース
import jakarta.servlet.http.HttpSession;

// Controllerのアノテーションが無いと、SpringがこのクラスをControllerとして認識しない
// アノテーションがないとinternalエラーになる
@Controller
public class CartController {

	// @AutowiredはSpringがDI（Dependency Injection）を行うためのアノテーション
	// DIとは、オブジェクトの依存関係や管理をSpringが自動で行うこと
	// ここで定義しておくことでこのController内にあるメソッドで使用できるようになる
	@Autowired
	HttpSession session; // セッションスコープ全体

	@Autowired
	Cart cart;

	@Autowired
	Account account;

	// getリクエストかつ/carts/login&logoutのURLにアクセスされた場合
	@GetMapping({ "/cart/login", "/cart/logout" })
	public String index() {

		// セッション情報全てをクリア
		session.invalidate();

		return "cartLogin";
	}

	@PostMapping("/cart/login")
	public String login(@RequestParam("name") String name) {

		// sccountオブジェクトにログインしたアカウント名をセット
		account.setName(name);
		return "cart";
	}

	// カート追加画面の表示
	@GetMapping("/cart")
	public String showCart() {
		return "cart";
	}

	// カート追加
	@PostMapping("/cart/add")
	public String addCart(
			@RequestParam("name") String name,
			@RequestParam("price") Integer price,
			Model model) {

		// cart(セッションスコープ)オブジェクトのgetItemsメソッドを呼び出して商品リストを取得
		// ここのcartは@Autowired Cart cart;のところから取得したcartオブジェクト
		List<Item> items = cart.getItems();

		// リストに商品を追加
		items.add(new Item(name, price));

		return "cart";
	}

	// ログイン画面の表示
	@GetMapping("/cart/clear")
	public String clearCart() {

		// カート内商品一覧の削除
		// .clear()メソッドは、リストの要素を全て削除する
		cart.getItems().clear();
		return "cart";
	}
}
