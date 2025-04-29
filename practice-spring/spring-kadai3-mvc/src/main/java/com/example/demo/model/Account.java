/**
 * Step1：MVCモデルを利用し、会員登録画面と確認画面を作成しなさい
 */

package com.example.demo.model;

// 会員クラス（Model）
public class Account {

	// フィールド
	// private修飾子は、クラスの外からアクセスできないようにする
	private String name;

	private String email;

	private String password;

	// デフォルトコンストラクタ
	public Account() {
	}

	// 引数ありコンストラクタ
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
