package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Account {

	// フィード
	private String name;

	// コンストラクタ
	public Account() {
	}

	public Account(String name) {
		this.name = name;
	}

	// ゲッター＆セッター
	public String getName() {

		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
