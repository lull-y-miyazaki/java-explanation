// Step:6
// Convertクラスは、数値や文字列を反転させる機能を持つクラス
// 反転とは、文字列や数字を逆から並べ替えること
// 例：123 → 321、Hello → olleH

package kadai4;

public class Convert {

	// 整数を反転するメソッド
	// 引数として整数を受け取る
	static void reverse(int value) {

		// 整数値を文字列に変換
		// Integer.valueOf(value)で整数をIntegerオブジェクトに変換し、toString()メソッドで文字列に変換
		// Integer は、int型（整数）をオブジェクトとして扱うためのクラス(p240にあるよ)
		// toString()メソッドは、整数を文字列に変換するためのメソッド
		// valueOf()はプリミティブ（基本型）→ ラッパークラスに変換するメソッド
		String str = Integer.valueOf(value).toString();

		// 文字列に変換した値を文字列反転メソッドに渡します
		reverse(str);
	}


	// 浮動小数点数を反転するメソッド
	// 引数として小数点数を受け取る
	static void reverse(double value) {

		// 小数点数を文字列に変換
		// Double.valueOf(value)で小数点数をDoubleオブジェクトに変換し、toString()メソッドで文字列に変換
		// Double は、double型（小数点数）をオブジェクトとして扱うためのクラス(p240にあるよ)
		// toString()メソッドは、浮動小数点数を文字列に変換するためのメソッド
		// 例：12.34 → "12.34"
		String str = Double.valueOf(value).toString();

		// 文字列に変換した値を文字列反転メソッドに渡します
		reverse(str);
	}


	// 文字列を反転するメソッド
	// 文字列を逆から並べ替えます
	// 例：「Hello」→「olleH」、「123」→「321」
	// 引数として文字列を受け取ります
	static void reverse(String value) {

		// StringBuilderは文字列を簡単に操作するための便利なツール
		// 通常のStringは一度作ると変更できませんが、StringBuilderは変更可能
		// カリキュラムのp238にあるよ
		StringBuilder sb = new StringBuilder(value);

		// reverse()メソッドで文字列を反転
		// 例：「Hello」→「olleH」
		// toString()で反転した文字列を通常のString型に変換
		value = sb.reverse().toString();

		// 反転した文字列を画面に表示
		System.out.println(value);
	}
}

// 補足：
// 1. staticメソッドは、クラスに属しているため、インスタンスを作成せずに呼び出すことができる
// 2. reverseメソッドは、整数、浮動小数点数、文字列の3つのオーバーロードされたバージョンを持つ
// 3. reverseメソッドは、引数として渡された値を反転し、画面に表示する
// 4. StringBuilderは、文字列を操作するための便利なクラスで、reverse()メソッドを使用して文字列を反転できる
// 5. StringBuilderは、文字列を効率よく連結・変更するためのクラス

// ただし、StringBuilder自体はString型とは違うため、画面に表示したり、他のメソッドに渡したりするには
//「String型」に変換する必要がある。そのためtoString()メソッドを使って、StringBuilderの内容を普通のStringに変換している
// valueOf()は、基本型の数値を、対応するラッパークラスのオブジェクトに変換するメソッド
