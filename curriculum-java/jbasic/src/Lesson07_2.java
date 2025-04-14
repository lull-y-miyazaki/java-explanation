// キーボードから１から３の整数を入力し、
// それに応じた文字列を表示するプログラム

// Scannerクラスをインポート
import java.util.Scanner;

public class Lesson07_2 {
	public static void main(String[] args) {

		// キーボード入力の受付
		// Scannerクラスのインスタンスを生成
		Scanner scan = new Scanner(System.in);

		System.out.print("数値を入力してください：");

		// int型の変数numを定義
		// ScannerクラスのnextInt()メソッドを使用して、整数値をキーボードから取得
		int num = scan.nextInt();

		// switch(変数)の中身がcaseの値と一致するかを調べる
		switch (num) {

		// 1が入力された場合
		case 1:
			System.out.println("優です");
			//switch文全体から抜ける
			break;

		// 2が入力された場合
		case 2:
			System.out.println("良です");
			break;

		// 3が入力された場合
		case 3:
			System.out.println("可です");
			break;

		//デフォルトの表示（＝上記の値以外）
		default:
			System.out.println("１から３を入力してください");
			break;
		}

		// Scannerクラスを閉じる
		// キーボード入力の受付を終了する
		scan.close();
	}
}

// 実行結果例
// 数値を入力してください：2
// 良です