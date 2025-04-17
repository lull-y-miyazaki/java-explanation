public class Lesson12_1_Book {

	// フィールド（インスタンス変数）
	String title;
	String author;
	int price;

	// 書籍情報を出力するメソッド
	// voidなので戻り値はない
	void showBook() {
		System.out.println("タイトル：" + title + " 著者：" + author + " 価格：" + price + "円");
	}

	//コンストラクタ（Bookオブジェクトの初期化）
	Lesson12_1_Book(String title, String author, int price) {

		// this.フィールド名で、フィールドを参照
		this.title = title;
		this.author = author;
		this.price = price;
	}
}

// 参考：
// this.：自分のクラスのフィールドやメソッドの呼び出し
	// ローカル変数とフィールド名が同じ場合によく使われる

// this()：自分のクラスのコンストラクタの呼び出し
	// オーバーロードされた別のコンストラクタを呼び出す場合によく使う
	// this() は コンストラクタの一行目でしか使えない
	// this() を使うことで、コンストラクタの重複を避けることができる
	// this() を使うことで、コンストラクタの初期化処理を一箇所にまとめることが可能