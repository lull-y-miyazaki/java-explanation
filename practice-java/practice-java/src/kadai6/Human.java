/*
* Step6：ゲームで利用するベースとなるキャラクタークラス（Humanクラス）を定義しなさい。
*
* Step7：Humanクラス（Step6で作成済み）を継承したWarriorクラス）を定義しなさい。
*
* Step8：Humanクラス（Step6で作成済み）とWarriorクラス（Step7で作成済み）を利用し、以下の出力結果になるようにPlayGameクラス（mainメソッドを定義しているクラス）を作成しなさい。
*/

package kadai6;

public class Human {

	// private修飾子をつけてカプセル化する
	private String name;

	// デフォルトコンストラクタ
	public Human() {
	}

	// 引数ありコンストラクタ
	public Human(String name) {

		// thisキーワードを使ってフィールドに値を代入
		this.name = name;
	}

	// ゲッター・セッター
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 情報を表示するメソッド
	public void info() {
		System.out.println("名前：" + name);
	}

	// 攻撃するメソッド
	public void attack() {
		System.out.println("攻撃した");
	}
}
