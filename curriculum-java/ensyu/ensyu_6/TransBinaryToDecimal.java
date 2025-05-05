/**
 * 【問題６】
 * キーボードより入力した2進数を10進数に変換するプログラムを作成してください。
 */

// java標準ライブラリのscannerを使えるようにするための宣言
import java.util.Scanner;

public class TransBinaryToDecimal {
	public static void main(String[] args) {

		// scannerクラスのインスタンスを新規作成し、変数scanに格納
		Scanner scan = new Scanner(System.in);

		// ユーザーに入力を促すよう画面に表示
		System.out.println("２進数を入力してください");

		// 入力をされた値を変数binaryStringに格納。（2進数を文字列として読み込む）
		String binaryString = scan.nextLine();

		// 整数(10進数)に変換するメソッドInteger.parseInt()で入力値を10進数に変換し、変数decimalに格納。
		// 引数（２進数を格納した変数,基数）
		int decimal = Integer.parseInt(binaryString, 2);

		// 変数decimalを表示
		System.out.println("入力された10進数は" + decimal + "です");

		// scannerを終了
		scan.close();
	}
}

// 【補足】
// scanner→キーボードからの入力をプログラムで扱えるようにする
// 2進数を文字列として読み込む→文字列の2進数を10進数に変換。基本的に6進数とかに変換したい場合は、10真数に変換してから行う。
// Integer.parseInt(String s, int radix) sは10進数,radixは基数 = sは指定された基数の数値
