// キーボードから整数値を入力し、1から12までの範囲であれば「正しい月」、それ以外は「正しくない月」と表示するプログラム

// Scannerクラスを使用するためのインポート文
import java.util.Scanner;

public class Lesson07_1 {
	public static void main(String[] args) {

		// キーボード入力の受付
		// Scannerクラスのインスタンスを生成
		Scanner scan = new Scanner(System.in);

		// int型の変数monthを定義
		System.out.print("月を入力してください：");

		// ScannerクラスのnextInt()メソッドを使用して、整数値をキーボードから取得
		// 1月から12月までの整数値を入力する
		int month = scan.nextInt();

		// 入力された月が1以上かつ12以下である場合
		if (1 <= month && month <= 12) {
			System.out.println(month + "月は正しい月です");

		// そうでない場合
		} else {
			System.out.println(month + "月は正しくない月です");
		}

		// Scannerクラスを閉じる
		scan.close();
	}
}

// 実行結果例
// 月を入力してください：10
// 10月は正しい月です