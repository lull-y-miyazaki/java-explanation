// Step1：
// 足し算メソッドと引き算メソッドを作りなさい

// このプログラムは、計算機の機能を持つクラスを定義しています

package kadai3;

public class Calculator {

	public static void main(String[] args) {

		// 足し算メソッドを呼び出し、結果を変数aに格納
		int a = add(3, 7);

		// 足し算の結果を画面に表示
		System.out.println(a);

		// 引き算メソッドを呼び出し、結果を変数bに格納
		int b = sub(3, 7);

		// 引き算の結果を画面に表示
		System.out.println(b);

		// 平均値メソッドを呼び出し、結果を変数cに格納
		double c = avg(3, 7);

		// 平均値の結果を画面に表示
		System.out.println(c);
	}

	// 2つの整数を足し算するメソッド
	// x: 1つ目の数
	// y: 2つ目の数
	// 戻り値: 足し算の結果
	static int add(int x, int y) {
		return x + y;
	}

	// 2つの整数を引き算するメソッド
	// x: 1つ目の数
	// y: 2つ目の数
	// 戻り値: 引き算の結果
	static int sub(int x, int y) {
		return x - y;
	}

	// 2つの整数の平均値を計算するメソッド
	// x: 1つ目の数
	// y: 2つ目の数
	// 戻り値: 平均値（小数点以下も計算）
	static double avg(int x, int y) {
		return (x + y) / 2.0;
	}
}
