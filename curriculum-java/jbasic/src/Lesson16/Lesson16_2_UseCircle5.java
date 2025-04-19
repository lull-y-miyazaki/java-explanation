/*
Lesson16 問題２:
*以下のクラスを安全に使用するために、例外クラスを作成してください。円の半径は 0 より大きいとします。
*0 以下の値が入力された場合は、例外を投げるように修正してください。

	public class Circle4 {
	public static final double PI = 3.14;
	private double radius;

	public Circle4(double radius) {
	this.radius = radius;
	}

	public double area() {
	return radius * radius * PI;
	}
	}

*また、修正したクラスを main メソッドから動作確認してください。

*実行結果
	*InvalidSizeException: 半径が0以下です
	*at Circle5.<init>(Circle5.java:7)
	*at UseCircle5.main(UseCircle5.java:5)
*/

// アクセス修飾子が付いていない（デフォルトアクセス修飾）
// このクラス同一パッケージ内からのみアクセス可能
class UseCircle5 {
	public static void main(String[] args) {

		// try-catch文を使って、例外処理を行う
		// tryブロック内で例外が発生する可能性のある処理を記述
		try {

			// Circle5クラスのインスタンスを生成する
			// Circle5クラスのコンストラクタは、InvalidSizeExceptionを投げる可能性があるので、try-catch文で囲む
			Circle5 c1 = new Circle5(7);

			// 例外を発生させるために、半径が0以下の値を指定してインスタンスを生成する
			Circle5 c2 = new Circle5(-3);

			// Circle5クラスのareaメソッドを呼び出して、面積を計算する
			System.out.println("c1の面積：" + c1.area());
			System.out.println("c1の面積：" + c2.area());


		// 半径が0以下のインスタンスがある場合の例外処理
		} catch (InvalidSizeException e) {

			// InvalidSizeExceptionは、例外クラスを作成して、throw文で投げる
			e.printStackTrace();
		}

	}
}

// 補足：

// InvalidSizeExceptionとは、半径が0以下の値が指定された場合に発生する例外クラス
// サイズがマイナス／ゼロなど、許容できないサイズだったときに使う
// InvalidSizeExceptionは、Exceptionクラスを継承している

// printStackTraceとは、Throwableクラスにある例外内容の詳細を表示するメソッド
// 例外が発生した場所や、例外の種類、メッセージなどを表示することができる
// 例外が発生した場所を特定するのに役立つ