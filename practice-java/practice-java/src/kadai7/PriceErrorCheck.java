/**
 * Step1：価格チェックプログラムを作りなさい
 *
 * 「価格エラーチェック仕様」
 * 整数チェック（try〜catchを利用する）
 * int（整数）として取得できなかった場合、エラーメッセージ「整数で入力してください」を出力して終了
 * 範囲チェック（try〜catchは不要です）
 * 0未満の値であった場合、エラーメッセージ「マイナスの値です」を出力して終了
 */

package kadai7;

import java.util.Scanner;

public class PriceErrorCheck {
	public static void main(String[] args) {

		// キーボードからの入力を受け付けるために、Scannerクラスを利用
		Scanner scan = new Scanner(System.in);

		int price = 0;
		System.out.print("価格：");

		// 例外処理を行うために、try〜catchを利用する
		// 整数として取得できなかった場合、エラーメッセージを出力して終了
		try {

			// nextInt()メソッドを利用して、整数を取得する
			price = scan.nextInt();

		// Exceptionクラスを利用して、すべての例外をキャッチする
		// 例外が発生した場合、catch文の処理が実行される
		// eは例外オブジェクトを表す変数(何でも良い)
		} catch (Exception e) {

			// 例外が発生した場合、エラーメッセージを出力して終了
			System.out.println("整数で入力してください");
			scan.close();
			return;
		}

		// 価格が0未満の場合、エラーメッセージを出力して終了
		if (price < 0) {
			System.out.println("マイナスの値です");
			scan.close();
			return;
		}

		// 価格が0以上の場合、登録完了メッセージを出力
		System.out.println(price + "円を登録しました");
		scan.close();
	}
}
