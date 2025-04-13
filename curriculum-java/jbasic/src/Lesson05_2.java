// Description: 商品の値段を入力し、消費税(10%)込みの値段を計算して表示するプログラム

// Scannerクラスの取り込み
import java.util.Scanner;

// クラス名はファイル名と同じにすること
// クラス名は大文字始まり
public class Lesson05_2 {

	// プログラムの実行は main メソッドから始まる
	public static void main(String[] args) {

		// キーボード入力の受付
		// Scannerクラスのインスタンスを生成
		Scanner scan = new Scanner(System.in);

		System.out.print("商品の値段を入力してください：");

		// int型の変数priceを定義
		// ScannerクラスのnextInt()メソッドを使用して、整数値をキーボードから取得
		int price = scan.nextInt();

		// 消費税(10%)込みの値段を計算する式
		// price * 1.1 の結果は double 型なので、int 型にキャストして整数にする
		int priceWithTax = (int)(price * 1.1);

		System.out.println("消費税(10%)込みの値段： " + priceWithTax);

		// Scannerクラスを閉じる
		scan.close();
	}
}