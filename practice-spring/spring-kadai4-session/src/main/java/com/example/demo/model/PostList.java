/**
 * 「PostList」 は複数の 「Post」 をまとめて管理するクラス
 */

package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope // セッションスコープ管理
public class PostList {

	// 投稿一覧を格納するリスト
	private List<Post> posts = new ArrayList<>();

	// ゲッター
	// List<Post>になっているのは、Postクラスのリストを取得するため
	public List<Post> getPosts() {
		return posts;
	}
}

/**
 * 補足：
 *
 * PostListクラスは、複数のPostオブジェクトを管理するためのクラス
 * 追加や削除も PostList に責任を持たせることで、さらに管理しやすくなる
 *
 * では、PostListクラスでCRUDを実装する場合と、Serviceクラスで実装する場合の違いは？
 * 「一時的に投稿を保存したい」「ログインユーザーごとに一時リストを持ちたい」→ PostList
 * 「投稿をDBで永続化・共有・検索したい」→ PostService + Repository + Entity
 */