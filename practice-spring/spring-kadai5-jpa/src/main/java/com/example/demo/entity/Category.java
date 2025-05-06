package com.example.demo.entity;



import jakarta.persistence.Entity; // エンティティ（データベースのテーブルと対応するクラス）を示すアノテーション
import jakarta.persistence.GeneratedValue; // 主キーの値を自動生成するために使用する
import jakarta.persistence.GenerationType; // 自動生成の方法を指定（IDENTITYはDBが自動で採番）
import jakarta.persistence.Id; // 主キーであることを示すアノテーション
import jakarta.persistence.Table; // 対応するテーブル名を指定するためのアノテーション




@Entity // このクラスがエンティティであることを指定
@Table(name = "categories") // 対応するテーブル名を「categories」と指定
public class Category { // カテゴリーを表すクラス



	// --- フィールド（テーブルのカラムに対応） ---

	@Id // 主キー（テーブルで一意の識別子）を指定
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主キーはDB側で自動採番される
	private Integer id;

	private String name;



	// --- ゲッター（値を取得するメソッド） ---

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
