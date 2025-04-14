// int型の配列を定義し、要素の合計を求めるプログラム

public class Lesson09_5 {
	public static void main(String[] args) {

		// 整数の配列を定義
		// int[]は整数型の配列を表し、{}内に初期値を指定
		// 配列の要素数は5になる
		int[] a = {23, 56, 82, 35, 91};

		// calcTotalメソッドを呼び出し、sumに格納
		// calcTotalメソッドの引数にaを渡す
		int sum = calcTotal(a);
		System.out.println("合計は" + sum);
	}

	// 配列内の要素の合計を求めるcalcTotalメソッド
	// 引数はint型の配列aryを受け取る
	// aryは配列の名前で、メソッド内で使うための変数なので何でもいい
	static int calcTotal(int[] ary) {

		// 合計を格納する変数sumを定義
		// 初期値は0とする
		int sum = 0;

		// for文の書き方は、for(初期化; 条件式; 更新後の処理)
		// ary.lengthは配列の要素数を取得するメソッド
		// eは配列の要素を1つずつ取り出すための変数なので何でもいい
		for (int e : ary) {

			// +=演算子は、左辺の変数に右辺の値を加算して代入する演算子
			// つまり、sum = sum + e と同じ意味
			sum += e;
		}

		// 合計を返す
		// calcTotalメソッドの戻り値としてsumを返す
		return sum;
	}
}
