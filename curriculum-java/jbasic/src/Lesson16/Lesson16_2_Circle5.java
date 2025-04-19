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
class Circle5 {

	// 円周率を格納するPIは定数なので、static finalで定義する
	// staticは、クラスに紐づく定数でなので、インスタンス化しなくても使用できる
	// finalは、定数であることを示す
	public static final double PI = 3.14;

	// private修飾子は、クラス内でのみアクセスできることを示す
	private double radius;

	// InvalidSizeExceptionを投げるコンストラクタ
	// thowsキーワードを使って、InvalidSizeExceptionを投げることを示す
	public Circle5(double radius) throws InvalidSizeException {

		// 半径が0以下の場合は、InvalidSizeExceptionを投げる
		// 例外を投げることで、エラーメッセージを表示させることができる
		// {}は、1行のみの記述なら省略OK
		if (radius <= 0)

			// InvalidSizeExceptionは、例外クラスを作成して、throw文で投げる
			throw new InvalidSizeException("半径が0以下です");

		// 1以上なら半径として値をフィールドに代入する
		this.radius = radius;
	}

	// 円の面積を計算するメソッド
	public double area() {
		return radius * radius * PI;
	}
}