package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users") // 対応テーブル
public class User {
	@Id // このアノテーションは、IDフィールドを主キーとして指定するために使用
	@GeneratedValue(strategy = GenerationType.IDENTITY) //このアノテーションは、IDの自動生成を指定するために使用
	private Integer id;
	private String name;
	private String email;
	private String password;

	// コンストラクタ
	public User() {
	}

	// 新規登録用のコンストラクタ
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	// 更新用コンストラクタ
	public User(Integer id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	// ゲッター
	public Integer getId() {
		return id;
	}

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
