//Step7：
//「1,7,2,7,3」の要素をもつ整数の配列 numbers を生成し、拡張 for 文を利用して「7」がいくつ存在したかを出力しなさい

package kadai2;

public class IntegerArray3 {

	// プログラムの実行が開始されるメインメソッド
	public static void main(String[] args) {

		// 整数の配列を初期化して値を設定
		// 配列には1, 7, 2, 7, 3の5つの数値が格納
		// int[]は整数型の配列を表し、{}内に初期値を指定
		int[] numbers = { 1, 7, 2, 7, 3 };

		// 7の出現回数を数えるための変数を初期化
		// countは0からスタート
		int count = 0;

		// 拡張for文を使用して配列の各要素を順番に処理
		// numには配列の各要素が順番に代入
		for (int num : numbers) {

			// 現在の要素が7と等しいかチェック
			// ==演算子は、2つの値が等しいかどうかを比較するために使用
			// eqlsメソッドは、文字列が同じかどうかを比較するために使う
			if (num == 7) {

				// 7が見つかった場合、カウントを1増やす
				// ++演算子は、count = count + 1と同じ意味
				count++;
			}
		}

		// 最終的な7の個数を画面に表示
		System.out.println(count + "個ありました");
	}
}
