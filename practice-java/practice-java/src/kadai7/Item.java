/**
 * Step4：Itemクラスを作成し、ItemActionクラスのmainメソッドから利用しなさい。
 * Itemクラスのオブジェクトを保持できるリストに商品を３つ追加し、拡張for文を利用して出力します。
 * Item（商品）クラスの仕様
	フィールド
		商品名（name）、文字列、外部からのアクセス禁止
		価格（price）、整数、外部からのアクセス禁止

	コンストラクタ
		デフォルトコンストラクタ
		引数からすべてのフィールドを初期化するコンストラクタ

	メソッド
		全てのフィールドに対するゲッター、セッター
		showInfo()メソッド
		引数なし
		戻り値なし
		フィールドに保持されている商品名を出力する
		フィールドに保持されている価格を出力する
 */

package kadai7;

public class Item {
	// 商品名と価格を保持するフィールドを定義
	// private修飾子をつけることで、クラスの外から直接アクセスできなくなる
	private String name;
	private int price;

	// デフォルトコンストラクタ
	public Item() {
	}

	// 商品名と価格を引数として受け取り、フィールドに代入するコンストラクタ
	public Item(String name, int price) {

		// super()は、親クラスのコンストラクタを呼び出すためのメソッド
		// 親クラスのコンストラクタを呼び出すことで、親クラスのフィールドやメソッドを利用できる
		super();

		// tihs.はクラスのフィールドを指す
		this.name = name;
		this.price = price;
	}

	// ゲッターセッター
	public String getName() {
		return name;
	}

	// voidは戻り値がないことを示す
	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	// 情報出力メソッド
	public void showInfo() {
		System.out.println("商品名：" + name);
		System.out.println("価格：" + price + "円");
	}

	// 商品情報
	public String getInfo() {
		return name + " / " + price + "円";
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