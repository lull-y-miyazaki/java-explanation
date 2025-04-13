package kadai1;

import java.util.Scanner;

//Step5：取得したパスワードが一致していたか否かを判定しなさい

public class CheckString1 {

	public static void main(String[] args) {

		// ユーザーからの入力を受け取るための準備
        Scanner scan = new Scanner(System.in);

        // パスワードの入力を促す
        System.out.print("パスワード：");

        // 入力された文字列を読み取り、変数passwordに保存する
        // scan.next() は、Javaでユーザーから文字列を入力してもらうときに使うメソッド
        // ただし、スペースで区切られた単語の最初の部分だけを取得する
        // 例えば、「hello world」と入力した場合、passwordには「hello」だけが入る
        String password = scan.next();

        // 入力されたパスワードが "himitu" と完全に一致するかどうかをチェック
        // equals() メソッドは、文字列が同じかどうかを比較するために使う
        if (password.equals("himitu")) {
            System.out.println("一致しました"); // 一致していればOKメッセージを表示
        } else {
            System.out.println("一致しませんでした"); // 違っていればNGメッセージを表示
        }

        // Scannerを閉じて、入力を終了する（メモリの無駄を防ぐ）
        scan.close();
	}

}

// 参考：
// equals()メソッドは、文字列が同じかどうかを比較するために使う
// ==演算子は、オブジェクトの参照（メモリ上の位置）を比較するため、文字列の内容を比較する場合はequals()を使う