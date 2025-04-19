/*
問題４:
*（オプション）キーボードから任意の文字列を入力します。入力された文字列が、何文字あるかを画面に出力してください。
*また、入力した文字列に「today」という文字が入っているかどうか調べ、結果を表示してください。

*実行結果
	*文字列を入力してください：abctodayazd
	*入力された文字数は：11字です
	*today が含まれています
*/

import java.util.Scanner;


public class Lesson15_4_InputStringCheck {
	public static void main(String[] args) {

		// Scannerクラスを使用して、キーボードからの入力を受け取る
		Scanner scan = new Scanner(System.in);

		System.out.print("文字列を入力してください：");

		// nextLine()メソッドを使用して、1行まるごとの文字列を読み取る
		String str = scan.nextLine();

		// length()メソッドを使用して、文字列の長さを取得する
		int num = str.length();

		System.out.println("入力された文字数は：" + num + "字です");

		// StringクラスのindexOfメソッドで、文字列todayを探す
		// indexOfメソッドは、指定した文字列が見つかった場合、そのインデックス番号を返す
		if (str.indexOf("today") != -1) {

			System.out.println("todayが含まれています");

		// 見つからなかった場合は-1を返す
		} else {

			System.out.println("todayが含まれていません");

		}

		// Scannerクラスを閉じる
		scan.close();
	}
}

// 補足：
// Scannerクラスは、キーボードからの入力を受け取るためのクラス
	// nextLine　1行まるごとの文字列を読む
	// next　単語単位で読む（空白まで）
	// nextInt　整数を読み取る
	// nextDouble　実数を読み取る