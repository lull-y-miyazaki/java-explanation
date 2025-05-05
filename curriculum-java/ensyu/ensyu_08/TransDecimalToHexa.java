/**
 * 【問題８】
 * キーボードより入力した10進数を16進数に変換するプログラムを作成してください。
 */

import java.util.Scanner;

public class TransDecimalToHexa {
	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("10進数を入力してください");
		int input_num = scanner.nextInt();

		// ----------------------------------ここに処理を追加----------------------------------

		// 10進数を16進数に変換する処理
		// Integer.toHexString(int i)メソッドを使用して、10進数を16進数に変換
		// 変換後の値は小文字で表示されるので、toUpperCase()メソッドを使用して大文字に変換
		String hex = Integer.toHexString(input_num).toUpperCase();

		System.out.println("入力された値の16進数は " + hex + " です");
	}
}
