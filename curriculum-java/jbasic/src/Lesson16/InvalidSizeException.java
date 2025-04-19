/*
Lesson16 練習問題②で使用
*/

// カスタム例外クラスを作成して、エラーメッセージを表示させる
// 半径が0以下の値が指定された場合に発生する例外クラス
// Exceptionクラスを継承している
public class InvalidSizeException extends Exception {

	// コンストラクタ
	// 引数にエラーメッセージを受け取る
	InvalidSizeException(String message) {

		// superキーワードを使って、親クラスのコンストラクタを呼び出す
		super(message);
	}
}

/* 補足：

何をしているかと言うと、
例外クラスを作成して、エラーメッセージを表示させることができるようにしている

Exception クラスがエラーメッセージを受け取れるようになっているので、
そこからこのカスタム例外クラスに持ってきて、エラーメッセージを表示できるようにしている

throw new InvalidSizeException("半径が0以下です");
↓
→ Exception が内部に「半径が0以下です」というメッセージを持つ
↓
→ e.getMessage() や e.printStackTrace() でメッセージが表示される


*解説：
Java の Exception クラスには、もともと「文字列のエラーメッセージを受け取れるコンストラクタ」が用意されている。

たとえば「Exception(String message)」という形のコンストラクタです。
今回のカスタム例外クラス（InvalidSizeException）では、その機能を使って、
コンストラクタ内で「super(message)」と書くことで、親である Exception クラスにメッセージを渡しています。

その結果、throw で例外を投げたときに、getMessage() や printStackTrace() を使って、
そのエラーメッセージを表示できるようになります。
*

*/