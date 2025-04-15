//Step4：
//無料会員とプレミア会員のポイント計算メソッドを作成しなさい

// このファイルはポイント計算を行うプログラム

package kadai3;

public class CalcPoints1 {

	// プログラムの実行開始点となるmainメソッドを定義
	public static void main(String[] args) {

		// 変数priceにint型の値1000を代入
		int price = 1000;

		// プレミア会員の場合のポイント計算
		// getPointsメソッドを呼び出し、priceとtrue（プレミア会員）を渡す
		int p1 = getPoints(price, true);


		// 計算結果を画面に表示
		System.out.println("プレミア会員には" + p1 + "ポイント付与されます");

		// 無料会員の場合のポイント計算
		// getPointsメソッドを呼び出し、priceとfalse（無料会員）を渡す
		int p2 = getPoints(price, false);


		// 計算結果を画面に表示
		System.out.println("無料会員には" + p2 + "ポイント付与されます");

	}

	// ポイントを計算するメソッドを定義
	// price: 商品の価格
	// isPremium: プレミア会員かどうか（true: プレミア会員、false: 無料会員）
	static int getPoints(int price, boolean isPremium) {

		// プレミア会員の場合
		if (isPremium) {

			// 価格の20%のポイントを付与（小数点以下は切り捨て）
			return (int) (price * 0.2);

		// 無料会員の場合
		} else {

			// 価格の10%のポイントを付与（小数点以下は切り捨て）
			// (int)はキャスト演算子で、double型をint型に変換するために使用
			return (int) (price * 0.1);
		}
	}
}
