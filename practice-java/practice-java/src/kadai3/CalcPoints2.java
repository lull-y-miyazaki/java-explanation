// Step5：キーボードから価格と会員ランク（1:プレミア、2:無料）を取得し、
// ポイント計算メソッドを利用してポイント数を出力しなさい

// このプログラムは購入金額に応じてポイントを計算するプログラム

package kadai3;

// キーボードからの入力を受け取るために必要なクラスをインポート
import java.util.Scanner;

public class CalcPoints2 {

	public static void main(String[] args) {

		// キーボードからの入力を受け取るためのScannerオブジェクトを作成
		Scanner scan = new Scanner(System.in);

		// ユーザーに購入金額の入力を促すメッセージを表示
		System.out.print("購入金額：");

		// 入力された購入金額を整数として読み取り、変数priceに格納
		// ScannerクラスのnextIntメソッドを使用して、整数を読み取る
		int price = scan.nextInt();

		// 会員ランクの選択肢を表示
		System.out.println("1:プレミア会員, 2:無料会員");

		// ユーザーに会員ランクの入力を促すメッセージを表示
		System.out.print("会員ランク：");

		// 入力された会員ランクを整数として読み取り、変数rankに格納
		// ScannerクラスのnextIntメソッドを使用して、整数を読み取る
		int rank = scan.nextInt();

		// 入力された会員ランクに応じて処理を分岐
		// swich文は、指定された値に基づいて異なる処理を実行するための制御構文
		// rankの値に応じて処理を分岐
		switch (rank) {

		// プレミア会員の場合
		case 1:

			// プレミア会員用のポイント計算メソッドを呼び出し、結果を表示
			System.out.println("プレミア会員には" + getPoints(price, true) + "ポイント付与されます");

			// break文は、switch文の処理を終了するために使用
			// これにより、次のcase文やdefault文の処理が実行されないようにする
			break;

		// 無料会員の場合
		case 2:

			// 無料会員用のポイント計算メソッドを呼び出し、結果を表示
			System.out.println("無料会員には" + getPoints(price, false) + "ポイント付与されます");

			break;

		// 1,2以外の値が入力された場合
		default:

			// エラーメッセージを表示
			System.out.println("1,2以外が選択されました");

			break;
		}

		// Scannerクラスを閉じる
		scan.close();
	}

	// ポイントを計算するgetPointsメソッド
	// price: 購入金額
	// isPremium: プレミア会員かどうかを示す真偽値
	static int getPoints(int price, boolean isPremium) {

		//isPremiumがtrueの場合、プレミア会員としてのポイント計算を行う
		if (isPremium) {

			// プレミア会員の場合、購入金額の20%をポイントとして付与
			// (int)はキャスト演算子で、double型をint型に変換するために使用
			// 価格の20%を計算し、整数にキャストして返す
			return (int) (price * 0.2);

		// isPremiumがfalseの場合、無料会員としてのポイント計算を行う
		} else {

			// 無料会員の場合、購入金額の10%をポイントとして付与
			// (int)はキャスト演算子で、double型をint型に変換するために使用
			// 価格の10%を計算し、整数にキャストして返す
			return (int) (price * 0.1);
		}
	}
}
