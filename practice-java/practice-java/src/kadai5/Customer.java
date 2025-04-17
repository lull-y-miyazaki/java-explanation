/*
Step6：顧客情報（IDと名前）を3人分入力し、それを配列に格納し表示するプログラムを作成しなさい。
なお、IDを指定したくない場合、IDに-1と指定します（内部的には0として登録される）。
UseCustomer1クラス（mainメソッドを定義しているクラス）の実行結果が以下になるようにCustomerクラスを定義しなさい。
ただし、IDの重複チェックは不要とします。
 */

package kadai5;

public class Customer {

	// フィールド
	// 顧客ID、整数、外部からのアクセス禁止
	// private修飾子をつけることで、同じクラスとパッケージ内からのみアクセス可能
	// ただし、getter/setterを使用することで、外部からアクセス可能にする
	private int id;
	private String name;

	// ①引数なしのデフォルトコンストラクタ
	public Customer() {
	}

	// ②名前だけを引数に取るコンストラクタ
	public Customer(String name) {

		// IDは0に設定
		// this()を使用して、③のコンストラクタを呼び出す
		this(0, name);
	}

	// ③IDと名前を引数に取るコンストラクタ
	public Customer(int id, String name) {

		// 引数で受け取った値をフィールドに設定
		// this.フィールド名で、フィールドを参照
		// 引数のフィールド名と同じ名前のフィールドがある場合、this.をつけて区別する
		this.id = id;
		this.name = name;
	}

	// 顧客データを表示するメソッド
	// voidなので、戻り値はない
	void showData() {
		System.out.println(id + "：" + name);
	}

	// ゲッターとセッター
	public int getId() {
		return id;
	}

	// 引数のフィールド名と同じ名前のフィールドがある場合、this.をつけて区別する
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	// 引数のフィールド名と同じ名前のフィールドがある場合、this.をつけて区別する
	public void setName(String name) {
		this.name = name;
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