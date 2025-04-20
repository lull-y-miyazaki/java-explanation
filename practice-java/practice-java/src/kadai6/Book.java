/*
* Step2：Itemクラスを継承し、Book（書籍）クラスを作成しなさい
*/

package kadai6;

// Itemクラスを継承したBookクラス
public class Book extends Item {

	// private修飾子をつけてカプセル化する
	private String author;

	// デフォルトコンストラクタ
	public Book() {
	}

	// 引数ありコンストラクタ
	public Book(String name, int price, String author) {

		// 親クラスのコンストラクタを呼び出す
		super(name, price);

		// thisキーワードを使ってフィールドに値を代入する
		this.author = author;
	}

	// ゲッター・セッター
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	// 親クラスのshowInfo()メソッドをオーバーライドする
	public void showInfo() {

		// 親クラスのshowInfo()メソッドを呼び出す
		super.showInfo();
		System.out.println("著者：" + author);
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