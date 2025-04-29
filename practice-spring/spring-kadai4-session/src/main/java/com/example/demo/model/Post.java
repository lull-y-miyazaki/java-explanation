/**
 * Step8：内容にURLが存在した場合、リンクを自動生成しなさい
 * (内容の先頭が「http://」または「https://」から始まっている場合はリンクにする)
 * (Postクラスのゲッター内を修正してみましょう)
 */

package com.example.demo.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {

	// 日付の文字列フォーマット
	private final static DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

	// インスタンスフィールド
	private LocalDateTime createdAt; // 投稿日時
	private String title; // タイトル
	private String feeling; // 気分
	private String content; // 内容

	// コンストラクタ
	public Post(String title, String feeling, String contents) {
		this.title = title;
		this.feeling = feeling;
		this.content = contents;
		this.createdAt = LocalDateTime.now(); // 現在日時
	}

	// ゲッター
	public String getCreatedAt() {

		// createdAt.format(createdAt)を使ってLocalDateTime→String型に変換
		return createdAt.format(FMT);
	}

	public String getTitle() {
		return title;
	}

	public String getFeeling() {
		return feeling;
	}

	public String getContent() {

		// 書き込み内容が「http://」または「https://」からはじまっていた場合はリンクを生成
		if (content.startsWith("http://") || content.startsWith("https://")) {
			return "<a href='" + content + "'>" + content + "</a>";
		}

		return content.replaceAll("\n", "<br>"); // 改行文字列→<br>置換
	}
}

/**
 * 補足：
 *
 * startsWithメソッドは、文字列が指定した接頭辞で始まるかどうかを判定するメソッド
 * 文字列が指定した接頭辞で始まる場合はtrueを返し、そうでない場合はfalseを返す
 * 例えば、"http://example.com"という文字列に対して
 * startsWith("http://")を呼び出すと、trueが返される
 * 逆に"example.com"という文字列に対して
 * startsWith("http://")を呼び出すと、falseが返される
 * そのため、startsWithメソッドは文字列の先頭部分を確認するために使用される
 */