/**
 * Step5：名前によるログイン・ログアウト処理を追加しなさい
 */

package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope // セッションスコープ管理
public class Account {

	// フィールド
	private String name;

	// ゲッター
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
