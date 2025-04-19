/*
問題３:
*（オプション）Student オブジェクトを println メソッドに直接引数で渡すと、
*画面に学生番号と名前が出力されるように、toString メソッドをオーバーライドしてください。
*main メソッドから動作確認をしてください。

*実行結果（例）
	*no:3 name:本田俊輔
*/

//パッケージabc
package Lesson15_abc;

public class Lesson15_3_Student2 {

	// フィールド
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
	public Lesson15_3_Student2(int no, String name) {
		this.no = no;
		this.name = name;
	}

	// 番号と名前を出力するメソッド
	public void showInfo() {
		System.out.println("no:" + no);
		System.out.println("name:" + name);
	}

	// toStringメソッドのオーバーライド
	public String toString() {
		return "no:" + no + " name:" + name;
	}
}


// 補足：

// toStringメソッドは元々存在するObjectクラスに定義されているメソッドで、オブジェクトの文字列表現を返すために使用される
// toStringメソッドをオーバーライドすることで、オブジェクトの文字列表現をカスタマイズできる

// Javaにおいて、全てのクラスはObjectクラスを継承している