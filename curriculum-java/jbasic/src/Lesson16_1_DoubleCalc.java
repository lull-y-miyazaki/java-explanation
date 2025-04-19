/*
問題１:
*キーボードから2つの小数を入力し、足し算するプログラムを作成してください。
*入力した値が小数ではない場合は、「入力された値は小数ではありません」と表示します。

*【実行結果（正常系）】
	*1つ目の小数を入力してください：2.45
	*2つ目の小数を入力してください：3.14
	*合計は5.59です

*【実行結果（異常系）】
	*1つ目の小数を入力してください：2.45
	*2つ目の小数を入力してください：abc
	*入力された値は小数ではありません
*/

import java.util.Scanner;

public class Lesson16_1_DoubleCalc {
	public static void main(String[] args) {

		// Scannerクラスを使ってキーボードからの入力を受け取る
		Scanner scan = new Scanner(System.in);

		System.out.print("1つ目の小数を入力してください：");

		// キーボードからの入力を受け取る
		// nextLineメソッドを使うことで、改行までの文字列を取得できる
		String d1Str = scan.nextLine();


		System.out.print("2つ目の小数を入力してください：");

		// キーボードからの入力を受け取る
		String d2Str = scan.nextLine();

		// 文字列を数値に変換する処理は、例外が発生する可能性があるのでtry-catch文を使う
		try {

			// Double.parseDoubleメソッドを使って、文字列をdouble型の数値に変換
			// 文字列が数値に変換できない場合は、NumberFormatException例外が発生する
			double d1 = Double.parseDouble(d1Str);
			double d2 = Double.parseDouble(d2Str);

			System.out.println("合計は" + (d1 + d2) + "です");

		// 例外が発生した場合は、catchブロックの処理が実行される
		// 例外が発生しなかった場合は、catchブロックの処理は実行されない
		// NumberFormatExceptionは、文字列を数値に変換できない場合に発生する例外
		// eは、例外オブジェクトを表す変数(何でも良い)
		} catch (NumberFormatException e) {

			System.out.println("入力された値は小数ではありません");

		// 例外が発生しても、プログラムが異常終了しないようにfinallyブロックを使う
		// finallyブロックは、tryブロックの処理が正常に終了した場合でも、例外が発生した場合でも必ず実行される
		} finally {

			// scan.close()メソッドを使って、Scannerオブジェクトを閉じる
			scan.close();
		}
	}
}

// 補足：

// Doubleクラスとは、Javaのラッパークラスの一つで、double型の数値を扱うためのクラス
// parseDoubleメソッドは、文字列をdouble型の数値に変換するメソッド
