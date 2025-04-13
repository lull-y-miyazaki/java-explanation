// Scannrクラスをインポート
import java.util.Scanner;

// クラス名はファイル名と同じにすること
// クラス名は大文字始まり
public class Lesson05_3 {

	// プログラムの実行は main メソッドから始まる
	public static void main(String[] args) {

		// キーボード入力の受付
		// Scannerクラスのインスタンスを生成
		Scanner scan = new Scanner(System.in);

		//まとめて変数を定義
		int english, mathmetics, science;

		//英語、数学、理科の点数を入力していく
		System.out.print("英語：");

		//int型の変数englishを定義
		//ScannerクラスのnextInt()メソッドを使用して、整数値をキーボードから取得
		english = scan.nextInt();

		System.out.print("数学：");
		mathmetics = scan.nextInt();

		System.out.print("理科：");
		science = scan.nextInt();

		// 合計と平均を計算する式
		// 合計は3科目の点数を足し算する
		int total = english + mathmetics + science;

		// 平均は合計を3で割る
		// 合計はint型、3はint型、平均はdouble型なので、合計をdouble型にキャストして割り算する
		double average = total / 3.0; // int/double=double int/int=int

		// 計算結果を表示する
		System.out.println("合計： " + total);
		System.out.println("平均： " + average);

		// Scannerクラスを閉じる
		scan.close();
	}
}
