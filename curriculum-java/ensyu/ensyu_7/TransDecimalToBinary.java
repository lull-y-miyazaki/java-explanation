/**
 * 【問題７】
 * キーボードより入力した10進数を2進数に変換するプログラムを作成してください。
 */

import java.util.Scanner;

public class Exercise7 {

	public static void main(String[] args) {

        // scannerクラスを使うことで、キーボードからの入力を受け取ることができる
		Scanner scan = new Scanner(System.in);

        // ユーザーに入力を促す
        System.out.println("10進数を入力してください");

        // nextInt()メソッドを使用して、整数を入力
        int decimal = scan.nextInt();

        // 2進数に変換（IntegerクラスのtoBinaryStringを使用）
        String binary = Integer.toBinaryString(decimal);

        // 結果を表示
        System.out.println("入力された値の2進数は" + binary+"です");

        // close()メソッドを使用して、scannerを終了
        scan.close();
	}

}
