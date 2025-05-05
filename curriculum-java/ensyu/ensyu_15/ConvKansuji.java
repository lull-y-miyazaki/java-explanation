/**
 * 【問題15】
 * 実行結果になるように数値を漢数字に変換するプログラムを作成してください。
 *
 * ■ 実行イメージ：
 * 任意の数値を入力して Enter を押してください
 * 7891
 * 七千八百九十一
 */

import java.util.Scanner;

public class ConvKansuji {

	public static void main(String[] args) {
		// Scannerクラスのインスタンスを作成し、Scanner型の変数scanに格納
		Scanner scan = new Scanner(System.in);

		// ユーザーに入力を促すよう画面に表示
		System.out.println("任意の数値を入力してEnterを押してください");

		// 入力された値を変数numに格納（整数を入力してもらうためint型）
		int num = scan.nextInt();

		// 入力された変数numを整数を漢数字にするconversionメソッドに渡し、変数kanjiStringに格納
		String kanjiString = conversion(num);

		// 変換された値を画面に出力
		System.out.println(kanjiString);

		scan.close();
	}

	// 数字→漢数字に変換するための、メソッド
	public static String conversion(int num) {

		// 変数digitsに漢数字を格納した配列を格納（0は空文字）
		String[] digits = { "", "一", "二", "三", "四", "五", "六", "七", "八", "九" };

		// 変数unitsに単位の配列を格納
		String[] units = { "", "十", "百", "千", "万" };

		// StringBuilderクラスのインスタンスを作成し、変数stringBuilderに格納
		StringBuilder stringBuilder = new StringBuilder();

		// valueOfメソッドで引数の整数numを文字列に変換し、変数numStrに格納
		String numStr = String.valueOf(num);

		// 文字列の長さをlengthメソッドで調べて、変数lenに格納
		int len = numStr.length();

		// 数字を1文字ずつ読み取り、漢数字＋単位に変換する処理
		// 左から1文字ずつ処理するためのループ
		for (int i = 0; i < numStr.length(); i++) {

			// 文字を数字に変換 (charAt()でi番目の1文字を取り出し、-'0'することで文字を数値化)
			int n = numStr.charAt(i) - '0';

			// 0は漢数字で表示しないよう飛ばす処理
			if (n != 0) {

				// 【digits[n]】漢数字に変換するため、配列digitsのn番目を取得
				// 【units[len - i - 1]】なんの単位か、配列unitsの文字列数-文字列の左側から何文字目か
				// appendメソッドで連結(バッファに文字列を追加する)
				stringBuilder.append(digits[n]).append(units[len - i - 1]);
			}
		}

		// toString()メソッドで文字列を取り出す
		return stringBuilder.toString();

	}

}

// StringBuilderクラス・・・可変（mutable）な文字列を扱うためのクラス（文字をどんどん付けたしたり、途中の文字を変更したりできる）

// int n = numStr.charAt(i) - '0'
// （例：文字列が7のとき、文字列7はのunicodeの番号で55 - 0はunicodeの番号で48 '7'(55)-'0'(48)=7 ←数字になる）