public class Lesson12_2_Book2 {

	// カプセル化したフィールド
	// private修飾子をつけることで、同じクラスとパッケージ内からのみアクセス可能
	// ただし、getter/setterを使用することで、外部からアクセス可能にする
	private String title;
	private String author;
	private int price;

	//ゲッター（titleの値を取得）
	public String getTitle() {
		return title;
	}

	//セッター（titleの値を設定）
	public void setTitle(String title) {

		// this.フィールド名で、フィールドを参照
		this.title = title;
	}

	//ゲッター（authorの値を取得）
	public String getAuthor() {
		return author;
	}

	//セッター（authorの値を設定）
	public void setAuthor(String author) {

		// this.フィールド名で、フィールドを参照
		this.author = author;
	}

	//ゲッター（priceの値を取得）
	public int getPrice() {
		return price;
	}

	//セッター（priceの値を設定）
	public void setPrice(int price) {

		// this.フィールド名で、フィールドを参照
		this.price = price;
	}

	// カプセル化したフィールドをフォーマットを整えて出力するメソッド
	// voidなので、戻り値はない
	public void showBook() {
		System.out.println("タイトル：" + title + " 著者：" + author + " 価格：" + price
				+ "円");
	}

	// 引数からすべてのフィールドを初期化するコンストラクタ
	// this.フィールド名で、フィールドを参照
	public Lesson12_2_Book2(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
}

//補足
//カプセル化 外部から直接フィールドを設定・取得されるを防ぐ
//フィールドにprivate修飾子をつけることで、同じクラスとパッケージ内からのみアクセス可能

// 参考：
// this.：自分のクラスのフィールドやメソッドの呼び出し
	// ローカル変数とフィールド名が同じ場合によく使われる

// this()：自分のクラスのコンストラクタの呼び出し
	// オーバーロードされた別のコンストラクタを呼び出す場合によく使う
	// this() は コンストラクタの一行目でしか使えない
	// this() を使うことで、コンストラクタの重複を避けることができる
	// this() を使うことで、コンストラクタの初期化処理を一箇所にまとめることが可能