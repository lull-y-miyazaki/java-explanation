package exam;

import java.util.Scanner;

/**
 * キーボードから年齢の入力を受け付けて入力チェックをしなさい
 */
public class Exam4 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("年齢を入力してください：");
		int age = 0; // 初期値

		// 文字列が入力された場合は「整数で入力してください」と出力する（5点）
		try {
			age = scan.nextInt();

		} catch (Exception e) {
			// Exceptionはどんな例外でも受け取り、eは例外オブジェクトの変数名で、例外の詳細情報にアクセスするために使う
			// 今回はユーザーが整数以外の値（例：文字列や小数）を入力したときに例外が発生する
			System.out.println("整数で入力してください");
			scan.close();
			return;
		}
		// 0以上130以下の範囲外である場合は「0以上130以下で入力してください」
		// と出力する（5点）
		if (age < 0 || 130 < age) {
			System.out.println("0以上130以下で入力してください");
			scan.close();
			return;
		}

		// 0以上130以下の整数だった場合は「○歳で登録しました」と出力する（5点）
		System.out.println(age + "歳で登録しました");
		scan.close();
	}
}