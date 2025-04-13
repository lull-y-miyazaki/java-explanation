
// クラス名はファイル名と同じにする必要がある
// クラス名は大文字で始めることが推奨されている
public class Lesson06_2 {

	// プログラムの実行は main メソッドから始まる
	public static void main(String[] args) {


		// 文字列配列のlanguagesを定義。配列の中身の数を指定しないで生成
		// 文字列型の配列を定義する場合は、String[]と書く
		String[] languages = {"C", "C++", "Java", "C#"};

		// 配列の要素数を指定して、配列を生成
		// languages[0]はC、languages[1]はC++、languages[2]はJava、languages[3]はC#を表す
		System.out.println("言語1：" + languages[0]);
		System.out.println("言語2：" + languages[1]);
		System.out.println("言語3：" + languages[2]);
		System.out.println("言語4：" + languages[3]);
	}
}
