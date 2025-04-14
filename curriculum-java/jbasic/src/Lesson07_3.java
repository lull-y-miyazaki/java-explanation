// キーボードから降水確率（0から100）を入力し、傘を持っていくかどうかを判断するプログラム

// Scannerクラスをインポート
import java.util.Scanner;

public class Lesson07_3 {
	public static void main(String[] args) {

		// キーボード入力の受付
		// Scannerクラスのインスタンスを生成
		Scanner scan = new Scanner(System.in);
		System.out.print("降水確率を入力してください：");

		// int型の変数rainを定義
		// ScannerクラスのnextInt()メソッドを使用して、整数値をキーボードから取得
		int rain = scan.nextInt();

		// if(降水確率(rain)が70以上)の場合
		if (rain >= 70) {
			System.out.println("傘を必ずもって行きましょう。");

		// 70%より下かつ20%以上の場合
		} else if (70 > rain && rain >= 20) {
			System.out.println("傘はあったほうがいいかも。");

		// 上記のどれにも当てはまらない（＝20%より下）の場合
		} else {
			System.out.println("傘はいらないでしょう。");
		}

		// Scannerクラスを閉じる
		// キーボード入力の受付を終了する
		scan.close();
	}
}

// 実行結果例
// 降水確率を入力してください：65
// 傘はあったほうがいいかも。