package com.example.demo.model;

// 会員クラス（Model）
public class Account {

	// フィールド
	private String name;

	private String email;

	private String password;

	// コンストラクタ
	public Account() {
	}

	public Account(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	// ゲッター
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
