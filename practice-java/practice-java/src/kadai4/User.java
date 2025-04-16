// Step:4
// このファイルは会員情報を管理するためのクラス
package kadai4;

/**
 * 会員クラス
 */
public class User {

	// フィールド（名前と年齢）
	// 名前を保存するための変数（文字列型）
	String name;

	// 年齢を保存するための変数（整数型）
	int age;

	// 情報を出力するメソッド
	void showInfo() {
		// フィールドに保存されている名前を画面に表示
		System.out.println("名前：" + name);

		// フィールドに保存されている年齢を画面に表示
		System.out.println("年齢：" + age);
	}
}