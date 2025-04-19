// Phone4クラスを継承したHandyPhone4クラス
// extendsキーワードを使って親クラスを指定する
public class HandyPhone4 extends Phone4 {

	// メールアドレスを保持するフィールド
	// private修飾子を使って、クラスの外からアクセスできないようにする
	private String mailAddress;

	// ゲッターメソッドとセッターメソッドを定義
	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	// メールを送信するメソッド
	// 引数toを受け取り、相手のメールアドレスを指定する
	public void mail(String to) {

		System.out.println(mailAddress + "から" + to + "へメールしました。");
	}

	// メールアドレスと電話番号を表示するメソッド
	public void info() {
		System.out.println("電話番号=" + getNo() + ", メールアドレス=" + mailAddress);
	}

	// コンストラクタ
	public HandyPhone4(String no, String mailAddress) {

		// superキーワードを使って親クラスのコンストラクタを呼び出す
		// 引数noを受け取り親クラスの電話番号を設定する
		super(no);

		// thisキーワードを使って、フィールドに値を設定する
		this.mailAddress = mailAddress;
	}
}

/*
*親クラスのPhone4クラス
*Phone4クラスは、電話番号を保持するフィールドと、電話をかけるメソッドを持つクラス

public class Phone4 {

	*電話番号を保持するフィールド
	*private修飾子を使って、クラスの外からアクセスできないようにする
	private String no;

	*ゲッターメソッドとセッターメソッドを定義
	public String getNo() {
		return no;
	}

	public void setNo(String no) {

		*thisキーワードを使って、フィールドに値を設定する
		this.no = no;
	}

	*電話をかけるメソッド
	*引数toを受け取り、相手の電話番号を指定する
	public void tel(String to) {
		System.out.println(no + "から" + to + "へ電話しました。");
	}

	*コンストラクタ
	public Phone4(String no) {

		*thisキーワードを使って、フィールドに値を設定する
		this.no = no;
	}
}
 */