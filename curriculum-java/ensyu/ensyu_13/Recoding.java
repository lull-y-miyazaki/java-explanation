/**
 * 【問題13】
 * 実行結果になるように Recording クラスを完成させなさい。
 * なお、表示されている日付はプログラムを実行した日付が表示されるようにしなさい。
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Recoding {

	//フィールド
	private String title;
	private String category;
	private String story;
	private Date date;

	//コンストラクタ
	public Recoding(String title, String category, String story) {
	this.title = title;
	this.category = category;
	this.story = story;
	this.date = new Date(); // 現在の日時を設定
	}

	public void showInfo() {

		// Locale.ENGLISH:英語の曜日や月名を使って出力する
		SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy",Locale.ENGLISH);
		String fullDate = sdf.format(date);

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);

		System.out.println("ーーーーーーー作品紹介ーーーーーーーーーーー");
		System.out.println("タイトル：" + title);
		System.out.println("新旧区分：" + category);
		System.out.println("ストーリー：" + story);
		System.out.println("日付：" + fullDate);
		System.out.println("日付：年" + year);
		System.out.println("日付：月" + month);
		System.out.println("日付：日" + day);
		System.out.println("ーーーーーーーーーーーーーーーーーーーーーー");
	}

}



