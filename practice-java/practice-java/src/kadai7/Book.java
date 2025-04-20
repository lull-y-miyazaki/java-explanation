/**
 * Step5：Itemクラスを継承してBookクラスを作成し、ItemAction2クラスのmainメソッドから利用しなさい。
 * Itemクラスのオブジェクトを保持できるリストに商品または書籍を３つ追加し、拡張for文を利用して出力します。
 * Book（書籍）クラスの仕様
	Itemクラスを継承する

	フィールド
	著者（author）、文字列、外部からのアクセス禁止

	コンストラクタ
	デフォルトコンストラクタ
	引数からすべてのフィールド（商品名、価格、著者）を初期化するコンストラクタ

	メソッド
	著者フィールドに対するゲッター、セッター
	showInfo()メソッド
	ItemクラスのshowInfo()をオーバーロードする（同じ名前のメソッドで作る）
	引数なし
	戻り値なし
	フィールドに保持されている商品名を出力する
	フィールドに保持されている価格を出力する
	フィールドに保持されている著者を出力する
 */

package kadai7;

// Itemクラスを継承してBookクラスを作成
public class Book extends Item {

	// private修飾子をつけることで、クラスの外から直接アクセスできなくなる
	private String author;

	// デフォルトコンストラクタ
	public Book() {
	}

	// 商品名、価格、著者を引数として受け取り、フィールドに代入するコンストラクタ
	public Book(String name, int price, String author) {

		// super()は、親クラスのコンストラクタを呼び出すためのメソッド
		super(name, price);

		// tihs.はクラスのフィールドを指す
		this.author = author;
	}

	// ゲッター・セッター
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	// 書籍情報出力
	public void showInfo() {

		// superは親クラスのメソッドを呼び出すためのキーワード
		super.showInfo();
		System.out.println("著者：" + author);
	}

	// 商品情報
	public String getInfo() {
		return getName() + "(著:" + getAuthor() + ") / " + getPrice() + "円";
	}
}

// 参考：
// super.：親クラスのフィールドやメソッドの呼び出し
	// オーバーライドされた子クラスのメソッドから親クラスのメソッドを呼び出す場合によく使う。

// super()：親クラスのコンストラクタの呼び出し
	// 親クラスのコンストラクタを明示的に呼び出す場合に使う。