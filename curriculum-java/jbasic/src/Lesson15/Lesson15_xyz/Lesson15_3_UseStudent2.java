/*
問題３:
*（オプション）Student オブジェクトを println メソッドに直接引数で渡すと、
*画面に学生番号と名前が出力されるように、toString メソッドをオーバーライドしてください。
*main メソッドから動作確認をしてください。

*実行結果（例）
	*no:3 name:本田俊輔
*/

// パッケージxyz
package Lesson15_xyz;

// パッケージabcのStudentクラスを取り込む
// 理由はパッケージが異なるクラスを使用するため
import Lesson15_abc.Lesson15_3_Student2;

public class Lesson15_3_UseStudent2 {
	public static void main(String[] args) {


		// Student2クラスのインスタンスを生成
		Lesson15_3_Student2 s = new Lesson15_3_Student2(3, "本田俊輔");

		// オーバーライドしたtoStringメソッドを呼び出す
		System.out.println(s);
	}

}

// 補足：

// System.out.println(インスタンス);
	// インスタンス.toString()を自動的に呼び出している
	// そのため、toStringメソッドをオーバーライドすることで、出力内容を変更できる
	// ただし、toStringメソッドをオーバーライドしない場合は、クラス名@ハッシュコードが出力される