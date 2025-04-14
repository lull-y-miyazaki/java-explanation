// 2つのdouble型の数値を割り算するメソッドを定義し、呼び出すプログラム

public class Lesson09_1 {
	public static void main(String[] args) {

		// 割り算するメソッド(引数1,引数2)をaに格納
		double a = div(34.2, 8.23);
		double b = div(6.58, 3.9);

		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}

	// 割り算するdivメソッドを定義
	// staticを付けることでインスタンス（オブジェクト）が不要になる
	// 引数はdouble型のnum1,num2を受け取る
	static double div(double num1, double num2) {

		// 割り算の結果をresultに格納
		double result = num1 / num2;

		// mainメソッド内の割り算メソッドにresultを戻す（＝戻り値）
		return result;
	}
}

// 実行結果：
// a = 4.155
// b = 1.6846153846153846