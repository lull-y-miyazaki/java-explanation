// Step3：
// 名前と10年後の年齢を出力するメソッドを作成しなさい

// このファイルはJavaのパッケージ「kadai3」に属しています
package kadai3;

// IntroduceMethodという名前のクラスを定義します
public class IntroduceMethod {

	// プログラムの実行が始まる場所（メインメソッド）を定義します
	public static void main(String[] args) {

		// introduceメソッドを呼び出して、名前「田中太郎」と年齢「25」を渡します
		introduce("田中太郎", 25);

		// 区切り線を表示します
		System.out.println("---");

		// introduceメソッドを呼び出して、名前「鈴木一郎」と年齢「30」を渡します
		introduce("鈴木一郎", 30);
	}

	// 自己紹介と10年後の年齢を出力するメソッドを定義します
	// String name: 名前を受け取るパラメータ
	// int age: 年齢を受け取るパラメータ
	static void introduce(String name, int age) {

		// 名前と年齢を組み合わせて自己紹介文を表示します
		System.out.println(name + age + "歳です");

		// 現在の年齢に10を足して、10年後の年齢を表示します
		System.out.println("10年後は" + (age + 10) + "歳です");
	}
}
