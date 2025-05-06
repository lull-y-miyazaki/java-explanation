package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "items") // 対応するテーブル名
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動採番(SIRIAL型)
	private Integer id; // 商品ID

	@Column(name = "category_id")
	private Integer categoryId; // カテゴリーID
	private String name; // 商品名
	private Integer price; // 価格

	// 引数なしコンストラクタ
	public Item() {
	}

	// 引数4つのコンストラクタ(更新処理用)
	public Item(Integer id, Integer categoryId, String name, Integer price) {
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;

	}

	// 引数3つのコンストラクタ
	public Item(Integer categoryId, String name, Integer price) {
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;

	}

	public Integer getId() {

		return id;
	}

	public Integer getCategoryId() {

		return categoryId;
	}

	public String getName() {

		return name;
	}

	public Integer getPrice() {

		return price;
	}

}
