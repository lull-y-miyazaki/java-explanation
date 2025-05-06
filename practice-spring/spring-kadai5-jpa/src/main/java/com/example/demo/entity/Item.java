/**
 * Step1：商品一覧画面を作りなさい（復習）
 */

package com.example.demo.entity;

import jakarta.persistence.Column; // JPAでカラム情報を設定するためのアノテーション
import jakarta.persistence.Entity; // このクラスがエンティティ（テーブルに対応するクラス）であることを示す
import jakarta.persistence.GeneratedValue; // 主キーの値を自動で生成する設定に使う
import jakarta.persistence.GenerationType; // 主キーの生成方法（今回はIDENTITY＝DB任せ）を指定
import jakarta.persistence.Id; // 主キーを表すアノテーション
import jakarta.persistence.Table; // このエンティティが対応するテーブル名を指定する

@Entity // このクラスはDBのテーブルに対応していることを意味する
@Table(name = "items") // このエンティティは「items」テーブルと対応している
public class Item { // 商品を表すクラス

	// --- フィールド（テーブルのカラムに対応） ---
	
	@Id // 主キー（テーブルの一意の識別子）として使用する
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主キーの値はDB側で自動採番（1,2,3…）
	private Integer id; // 商品ID（自動で割り振られる）

	@Column(name = "category_id") // カラム名を「category_id」として指定（DBの列名とJavaの変数名が異なる場合に使う）
	private Integer categoryId;

	private String name;

	private Integer price;

	// --- ゲッター（各フィールドの値を外部から取得するためのメソッド） ---

	public Integer getId() {
		return id; // 商品IDを返す
	}

	public Integer getCategoryId() {
		return categoryId; // カテゴリーIDを返す
	}

	public String getName() {
		return name; // 商品名を返す
	}

	public Integer getPrice() {
		return price; // 価格を返す
	}
}
