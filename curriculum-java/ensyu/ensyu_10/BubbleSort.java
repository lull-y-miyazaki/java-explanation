/**
 * 【問題１０】
 * 予め与えられた配列 data をバブルソートで昇順にソートするプログラムを作成してください。
 * 例）配列
 * data = [7, 10, 5, 4, 2]
 */

public class Exercise10 {
	public static void main(String[] args) {

		// 予め与えられた配列
		int[] data = { 7, 10, 5, 4, 2 };

		// バブルソート開始
		// このループは配列全体を何周するかを決めるループ。
		for (int i = 0; i < data.length - 1; i++) {

			// こっちは配列の中で隣同士を見比べて、必要なら入れ替える部分。
			for (int j = 0; j < data.length - 1 - i; j++) {

				// 「左の方が大きい」ってことは、順番が逆なので入れ替える必要あり。
				if (data[j] > data[j + 1]) {

					// 交換処理
					//13-15行目一時的な変数 temp を使って、安全に中身を入れ替えるやり方。
					int temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
				}
			}
		}

		// 結果表示
		System.out.println("配列dataのソート結果 ");

		// 配列のすべての要素を順番に取り出して処理する方法。
		for (int num : data) {
			System.out.print(num + " ");
		}
	}
}

