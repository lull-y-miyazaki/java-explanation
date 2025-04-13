package kadai1;

import java.util.Scanner;

/*Step9：キーボードから国語と数学と英語のテストの点数を入力し、
その平均点を表示する プログラムを作成しなさい。
*/
public class Test1 {

	public static void main(String[] args) {
		// ユーザーの入力を受け取るためのScannerを用意
        Scanner scan = new Scanner(System.in);

        // 国語の点数を入力してもらう
        // print()は改行しないで表示するメソッド
        System.out.print("国語の点数を入力してください：");

        // nextInt()は、整数を入力してもらうためのメソッド
        // ここでは、国語の点数を入力してもらい、その値を変数 jpnScore に保存
        int jpnScore = scan.nextInt();

        // 数学の点数を入力してもらう
        System.out.print("数学の点数を入力してください：");
        int mathScore = scan.nextInt(); // 入力された点数を保存

        // 英語の点数を入力してもらう
        System.out.print("英語の点数を入力してください：");
        int engScore = scan.nextInt(); // 入力された点数を保存

        // 平均点を求める（合計を3.0で割って、小数も出せるようにする）
        double average = (jpnScore + mathScore + engScore) / 3.0;

        // 計算された平均点を表示する
        // System.out.println()は、改行して表示するメソッド
        System.out.println("平均は" + average + "点です");

        // Scannerを閉じる
        scan.close();
	}

}
