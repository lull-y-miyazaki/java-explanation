/*
Lesson15 問題２:
*別パッケージ xyz から、1.で作成した abc パッケージの Student クラスのインスタンスを1つ作って、
*メソッドを呼び出し情報を画面に出力してください。

*実行結果（例）
	*no:3
	*name:本田俊輔
*/

// パッケージxyz
package Lesson15_xyz;

// パッケージabcのStudentクラスを取り込む
// 理由はパッケージが異なるクラスを使用するため
import Lesson15_abc.Lesson15_1_Student;

public class Lesson15_2_UseStudent {
	public static void main(String[] args) {

		// Studentクラスのインスタンスを生成
		Lesson15_1_Student s = new Lesson15_1_Student(3, "本田俊輔");

		// StudentクラスのshowInfoメソッドを呼び出す
		s.showInfo();
	}

}
