/**
 * Step3：セッションスコープで管理されたカートクラスを作成し利用しなさい(これまで一個しかできなかったのを、複数商品を追加できるようにする）
 */

package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope // セッションスコープ管理
public class Cart {

	// カート商品一覧
	// privateにしているのは、カプセル化のため(今回に特別な理由はない)
	private List<Item> items = new ArrayList<>();

	// ゲッター
	public List<Item> getItems() {
		return items;
	}
}
