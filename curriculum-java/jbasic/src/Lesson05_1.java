//Scannerクラスの取り込み
import java.util.Scanner;

//クラス名はファイル名と同じにすること
//クラス名は大文字始まり
public class Lesson05_1 {

	//プログラムの実行は main メソッドから始まる
	public static void main(String[] args) {

		//キーボード入力の受付
		Scanner scan = new Scanner(System.in);

		System.out.print("三角形の底辺を入力してください：");

		//int型の変数baseを定義
		//ScannerクラスのnextInt()メソッドを使用して、整数値をキーボードから取得
		int base = scan.nextInt();

		System.out.print("三角形の高さを入力してください：");

		//int型の変数heightを定義
		//ScannerクラスのnextInt()メソッドを使用して、整数値をキーボードから取得
		int height = scan.nextInt();

		// 三角形の面積を計算する式
		double area = base * height / 2.0;
		System.out.println("三角形の面積： " + area);

		// Scannerクラスを閉じる
		scan.close();
	}
}
