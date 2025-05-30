/**
 * Step1：商品一覧画面を作りなさい（復習）
 */

package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //Entityクラスであることを宣言
@Table(name = "items") //itemsテーブルに対応していることを示す
public class Item {
	//フィールド
	@Id //主キーであることを示す
	@GeneratedValue(strategy = GenerationType.IDENTITY) //自動で配番
	private Integer id; //商品ID

	@Column(name = "category_id") //テーブルのカラム名
	private Integer categoryId;//カテゴリー名

	private String name;// 商品名
	private Integer price;//値段

	//コンストラクタ
	public Item() { //JpaRepositoryはからのコンストラクタが必要
	}

	public Item(Integer categoryId, String name, Integer price) {
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
	}

	public Item(Integer id, Integer categoryId, String name, Integer price) {
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
	}

	//	ゲッター
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

	//	セッター
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
