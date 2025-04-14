// ループを使用して、1から10までの合計を求めるプログラム

public class Lesson08_1 {
	public static void main(String[] args) {

		// あらかじめsumを定義し、0を格納
		int sum = 0;

		// 1から始まり、10まで繰り返す、1ずつ増やす（＝インクリメント演算子による加算）
		// for文の書き方は、for(初期化; 条件式; 更新後の処理) {
		// i++は、i = i + 1と同じ意味
		for (int i = 1; i <= 10; i++) {

			// sum = sum + i;と同じ意味
			sum += i;
		}

		// 合計を出力
		System.out.println("1から10までの合計は" + sum + "です");
	}
}

// 出力結果は以下の通り
// 1から10までの合計は55です