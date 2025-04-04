package exam;

import java.util.Scanner;

/**
 * キーボードから名前（文字列）と年齢（整数）の入力を受け取り
 * 10年後の年齢結果をコンソールに出力する処理を作成しなさい。
 */
public class Exam1 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// キーボードから名前と年齢を取得して10年後の年齢を出力する（10点）
		System.out.print("名前：");
		// scan.next()は、キーボードから文字列（String型）のデータを取得するメソッド
		String name = scan.next();
		System.out.print("年齢：");
		// scan.nextInt()は、キーボードから整数（int型）のデータを取得するメソッド
		int age = scan.nextInt();

		// 結果を出力して処理終了
		System.out.println(name + "さんの10年後は" + (age + 10) + "歳です！");
		// Scannerオブジェクトは使用後、必ずclose()メソッドで閉じる
		// これにより、プログラムが正しく終了する（エラーにはならない）
		scan.close();
	}
}