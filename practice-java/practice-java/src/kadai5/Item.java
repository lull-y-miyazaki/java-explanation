/**
Step1：（商品）クラスを作成しなさい
・フィールド
	商品名（name）、文字列、外部からのアクセス禁止
	価格（price）、整数、外部からのアクセス禁止
・コンストラクタ
	デフォルトコンストラクタ
	引数からすべてのフィールドを初期化するコンストラクタ
・メソッド
	全てのフィールドに対するゲッター、セッター
 */

package kadai5;

public class Item {

	// フィールド
	// private修飾子をつけることで、同じクラスとパッケージ内からのみアクセス可能
	// ただし、getter/setterを使用することで、外部からアクセス可能にする
	private String name;
	private int price;

	// ①引数なしのデフォルトコンストラクタ
	public Item() {
	}

	// ②引数からすべてのフィールドを初期化するコンストラクタ
	public Item(String name, int price) {

		// 引数で受け取った値をフィールドに設定
		// this.フィールド名で、フィールドを参照
		this.name = name;
		this.price = price;
	}

	// ゲッターセッター
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

/*Step3：Itemクラスに商品情報を出力するshowInfo()メソッドを追加しなさい */
	// 情報出力メソッド
	// voidなので、戻り値はない
	public void showInfo() {
		System.out.println("商品名：" + name);
		System.out.println("価格：" + price + "円");
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