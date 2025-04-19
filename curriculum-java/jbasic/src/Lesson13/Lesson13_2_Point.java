public class Lesson13_2_Point {

	// カプセル化したフィールド
	// private修飾子をつけることで、同じクラスとパッケージ内からのみアクセス可能
	// ただし、getter/setterを使用することで、外部からアクセス可能にする
	private int x;
	private int y;

	// x座標を取得するゲッター
	public int getX() {
		return x;
	}

	// x座標を設定するセッター
	public void setX(int x) {

		// 引数で受け取った値をフィールドに設定
		// this.フィールド名で、フィールドを参照
		this.x = x;
	}

	// y座標を取得するゲッター
	public int getY() {
		return y;
	}

	// y座標を設定するセッター
	public void setY(int y) {
		this.y = y;
	}

	// x座標とy座標を引数にとるコンストラクタ
	public Lesson13_2_Point(int x, int y) {

		// super()は親クラスのコンストラクタを呼び出す
		// ここでは親クラスはObjectクラスなので、特に何もしていない
		super();
		this.x = x;
		this.y = y;
	}

	// 座標の情報を画面に出力するメソッド
	public void showPoint() {
		System.out.println("x:" + x + " y:" + y);
	}
}

// 参考：
// super.：親クラスのフィールドやメソッドの呼び出し
	// オーバーライドされた子クラスのメソッドから親クラスのメソッドを呼び出す場合によく使う。

// super()：親クラスのコンストラクタの呼び出し
	// 親クラスのコンストラクタを明示的に呼び出す場合に使う。

// this.：自分のクラスのフィールドやメソッドの呼び出し
	// ローカル変数とフィールド名が同じ場合によく使われる

// this()：自分のクラスのコンストラクタの呼び出し
	// オーバーロードされた別のコンストラクタを呼び出す場合によく使う
	// this() は コンストラクタの一行目でしか使えない
	// this() を使うことで、コンストラクタの重複を避けることができる
	// this() を使うことで、コンストラクタの初期化処理を一箇所にまとめることが可能