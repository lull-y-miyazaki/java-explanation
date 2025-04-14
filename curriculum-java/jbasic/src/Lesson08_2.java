// 7, 12, 37, 24, 2, 92, 51の整数値を持つ配列を定義し、
// 拡張for文を使用して、配列の要素を順番に表示するプログラムを作成してください。

public class Lesson08_2 {
	public static void main(String[] args) {

		// int型配列のaryを定義。配列の中身は整数値
		// int[]はint型の配列を型定義するための書き方
		int[] ary = {7, 12, 37, 24, 2, 92, 51};

		// 拡張for文 ary内の各要素を順番に格納する変数elm
		// for(変数 : 配列名) {
		// elmは何でも良いが、配列の要素の型と同じ型にする必要がある
		for (int elm : ary) {

			// 変数elmの値を出力する
			System.out.println(elm);
		}
	}
}

// 出力結果は以下の通り
// 7
// 12
// 37
// 24
// 2
// 92
// 51
