/*
Lesson14 問題４で使用
*/

public class Phone4 {

	// 電話番号を保持するフィールド
	// private修飾子を使って、クラスの外からアクセスできないようにする
	private String no;

	// ゲッターメソッドとセッターメソッドを定義
	public String getNo() {
		return no;
	}

	public void setNo(String no) {

		// thisキーワードを使って、フィールドに値を設定する
		this.no = no;
	}

	// 電話をかけるメソッド
	// 引数toを受け取り、相手の電話番号を指定する
	public void tel(String to) {
		System.out.println(no + "から" + to + "へ電話しました。");
	}

	// コンストラクタ
	public Phone4(String no) {

		// thisキーワードを使って、フィールドに値を設定する
		this.no = no;
	}
}