// Pointクラスから継承したColorPointクラス
public class Lesson13_2_ColorPoint extends Lesson13_2_Point {

	// カプセル化したフィールド
	// private修飾子をつけることで、同じクラスとパッケージ内からのみアクセス可能
	// ただし、getter/setterを使用することで、外部からアクセス可能にする
	private String color;

	// 色を取得するゲッター
	public String getColor() {
		return color;
	}

	// 色を設定するセッター
	public void setColor(String color) {

		// 引数で受け取った値をフィールドに設定
		// this.フィールド名で、フィールドを参照
		this.color = color;
	}

	// x座標とy座標、色を引数にとるコンストラクタ
	public Lesson13_2_ColorPoint(int x, int y, String color) {

		// 親クラスのコンストラクタを呼び出し、xとyを渡す
		super(x, y);

		//引数のcolorをフィールドのcolorに代入する
		this.color = color;
	}

	// 座標の情報を画面に出力するメソッド
	// voidなので、戻り値はない
	// showPointメソッドは、親クラスのshowPointメソッドをオーバーライドしている
	public void showPoint() {

		// 親クラスのshowPointメソッドを呼び出す
		// superは親クラスを指すキーワード
		super.showPoint();

		System.out.println("color:" + color);
	}
}

// 参考：
// super.：親クラスのフィールドやメソッドの呼び出し
	// オーバーライドされた子クラスのメソッドから親クラスのメソッドを呼び出す場合によく使う。

// super()：親クラスのコンストラクタの呼び出し
	// 親クラスのコンストラクタを明示的に呼び出す場合に使う。