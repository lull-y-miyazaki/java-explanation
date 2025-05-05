/**
 * 【問題９】
 * キーボードより入力した16進数を10進数に変換するプログラムを作成してください。
 */

import java.util.Scanner;

public class TransHexaToDecimal {

	public static void main(String[] args) {

		//scannerクラスのインスタンスを新規作成し、変数scanに格納
		Scanner scan = new Scanner(System.in);

		//ユーザーに入力を促すよう画面に表示
		System.out.println("16進数を入力してください");

		//入力をされた値を変数hexadecimalに格納。（16進数を文字列として読み込む）
		String hexadecimal = scan.nextLine();

		//整数(10進数)に変換するメソッドInteger.parseInt()で入力値を10進数に変換し、変数decimalに格納。
		//引数（16進数を格納した変数,基数）
		int decimal = Integer.parseInt(hexadecimal, 16);

		//変数decimalを表示
		System.out.println("入力された値の10進数は" + decimal + "です");

		//scannerを終了
		scan.close();
	}

}
