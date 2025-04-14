// キーボードから5人分の点数を入力し、その中で最も高い点数を表示するプログラム

// Scannerクラスをインポート
import java.util.Scanner;

public class Lesson08_4 {
	public static void main(String[] args) {

		// キーボード入力の受付
		// Scannerクラスのインスタンスを生成
		Scanner scan = new Scanner(System.in);

		// int型の配列scoresを定義
		// 配列の要素数は5とする
		// scores[0][1][2][3][4]の5つの要素を持つ配列を生成
		int[] scores = new int[5];

		// 1人目から順番に処理
		// for文の書き方は、for(初期化; 条件式; 更新後の処理)
		// scores.lengthは配列の要素数を取得するメソッド
		for (int i = 0; i < scores.length; i++) {

			// (0+1)人目から
			// なぜ(i+1)かというと、配列の要素数は0から始まるから
			System.out.print((i + 1) + "人目の点数：");

			// キーボードからi番目の点数を取得
			// scan.nextInt()は、キーボードから整数値を取得するメソッド
			scores[i] = scan.nextInt();
		}

		// 最も高い点数を暫定的に1人目の点数とする
		// scores[0]は配列の1番目の要素を取得するメソッド
		int max = scores[0];

		// 2人目から順番に処理
		// for文の書き方は、for(初期化; 条件式; 更新後の処理)
		// scores.lengthは配列の要素数を取得するメソッド
		for (int i = 1; i < scores.length; i++) {

			// i番目が暫定トップより大きいなら
			// scores[i]は配列のi番目の要素を取得するメソッド
			// maxは暫定トップの点数を取得するメソッド
			if(max < scores[i]) {

				// i番目が暫定トップになる
				max = scores[i];
			}
		}

		// 最も高い点数を表示
		System.out.println("最高得点は" + max + "です");

		// Scannerクラスを閉じる
		// キーボード入力の受付を終了する
		scan.close();
	}
}
