/*
* Step7：Humanクラス（Step6で作成済み）を継承したWarriorクラス）を定義しなさい。
*/

package kadai6;

public class Warrior extends Human {

	// private修飾子をつけてカプセル化する
	// 戦士の種別（type）
	private String type;

	// デフォルトコンストラクタ
	// 何も引数を指定しない場合は、デフォルトコンストラクタが呼び出される
	public Warrior() {
	}

	// 引数ありコンストラクタ
	public Warrior(String name, String kind) {

		// super()は親クラスのコンストラクタを呼び出す
		super(name);

		// thisキーワードを使ってフィールドに値を代入
		this.type = kind;
	}

	public String getKind() {
		return type;
	}

	public void setKind(String kind) {
		this.type = kind;
	}

	// 親クラスのinfo()メソッドをオーバーライドする
	// 戦士の種別と名前を表示するメソッド
	public void info() {
		System.out.print("種別：" + type + "　");

		// super.info()は親クラスのinfo()メソッドを呼び出す
		super.info();
	}

	// 親クラスのattack()メソッドをオーバーライドする
	// 戦士の攻撃メソッド
	public void attack() {
		System.out.print("「" + type + "」は");

		// super.attack()は親クラスのattack()メソッドを呼び出す
		super.attack();
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