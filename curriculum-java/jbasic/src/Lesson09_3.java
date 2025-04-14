// テストの点数を入力し、合格か不合格かを判定するプログラム

import java.util.Scanner;

public class Lesson09_3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("点数を入力してください：");
		int score = scan.nextInt();

		// judgeメソッドの呼び出し
		// scoreを引数に渡す
		System.out.println(score + "は" + judge(score) + "です");
		scan.close();
	}

	// 合格か不合格か判定を出すjudgeメソッド
	// 変数scoreをif文の条件式に当てはめて判定
	static String judge(int score) {

		// scoreが70以上なら合格
		if(score >= 70) {

			//9行目"judge(score)"に戻す
			return "合格";

		// scoreが70未満なら不合格
		} else  {

			//9行目"judge(score)"に戻す
			return "不合格";
		}
	}
}

// 実行結果：
// 点数を入力してください：80
// 80は合格です