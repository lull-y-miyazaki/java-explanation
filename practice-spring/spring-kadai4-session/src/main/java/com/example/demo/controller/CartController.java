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

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

	@Autowired
	HttpSession session; // セッションスコープ全体

	@Autowired
	Cart cart;

	@Autowired
	Account account;

	@GetMapping({ "/cart/login", "/cart/logout" })
	public String index() {
		session.invalidate();
		return "cartLogin";
	}

	@PostMapping("/cart/login")
	public String login(@RequestParam("name") String name) {
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

		// セッションスコープからカート内の商品リストを取得
		List<Item> items = cart.getItems();
		// リストに商品を追加
		items.add(new Item(name, price));

		return "cart";
	}

	// ログイン画面の表示
	@GetMapping("/cart/clear")
	public String clearCart() {
		// カート内商品一覧の削除
		cart.getItems().clear();
		return "cart";
	}
}
