package com.example.demo.model;

public class Item {
	// フィールド
	private String name;

	private Integer price;

	// コンストラクタ
	public Item(String name, Integer price) {
		this.name = name;
		this.price = price;
	}

	// ゲッター
	public String getName() {
		return name;
	}

	public Integer getPrice() {
		return price;
	}
}
