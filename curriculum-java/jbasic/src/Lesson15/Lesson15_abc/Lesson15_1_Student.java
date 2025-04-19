/*
Lesson15 問題１:
*パッケージ abc に、Student クラスを定義してください。
*クラスとメソッド、コンストラクタはどのパッケージからでも使用可能にします。
*フィールド
	*no　学生番号
	*name　名前

*コンストラクタ
	*学生番号と名前を引数にとる

*メソッド
	*void showInfo() 画面に学生番号と名前を出力する
*/

//パッケージabc
package Lesson15_abc;

public class Lesson15_1_Student {

	// フィールド
	// privateはこのクラス内でのみアクセス可能
	private int no;
	private String name;

	// 番号を取得するゲッター
	public int getNo() {
		return no;
	}

	// 番号を設定するセッター
	public void setNo(int no) {

		// this.キーワードはフィールドと引数の名前が同じ場合に、フィールドを参照するために使用
		this.no = no;
	}

	// 名前を取得するゲッター
	public String getName() {
		return name;
	}

	// 名前を設定するセッター
	public void setName(String name) {
		this.name = name;
	}

	// 生徒情報を初期化するコンストラクタ
	public Lesson15_1_Student(int no, String name) {
		this.no = no;
		this.name = name;
	}

	// 番号と名前を出力するメソッド
	public void showInfo() {
		System.out.println("no:" + no);
		System.out.println("name:" + name);
	}
}

/*
*toStringメソッドのオーバーライドでのやり方

public String toString() {
		return "no:" + no + " name:" + name;
	}
}

*/