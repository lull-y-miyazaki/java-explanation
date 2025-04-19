/*
 * Step1：Item（商品）クラスを作成し、ItemActionクラスのmainメソッドから利用しなさい（復習）
 */

package kadai6;

public class Item {

	// フィールド
	// private修飾子をつけて、カプセル化するクラスの外から直接アクセスできないようにする
	private String name;
	private int price;

	// デフォルトコンストラクタ
	public Item() {
	}

	// 引数ありコンストラクタ
	public Item(String name, int price) {

		// super()は親クラスのコンストラクタを呼び出す
		// 何も引数を指定しない場合は、デフォルトコンストラクタが呼び出される
		super();

		// thisキーワードを使って、フィールドと引数の名前が同じ場合にフィールドを参照する
		this.name = name;
		this.price = price;
	}

	// ゲッター&セッター
	public String getName() {
		return name;
	}

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