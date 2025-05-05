/**
 * 【問題16】
 * 下記、仕様を満たす JudgeGame を作成してください。
 *
 * ■ JudgeGame 仕様
 * YOU と ENEMY それぞれ 1〜9 までの乱数を発生し、
 * ENEMY より大きい数値がでたら A (Attack) を入力すると勝ち
 * ENEMY より小さい数値がでたら D (Defense) を入力すると勝ち
 * ※なお、You と Enemy が同じ数値がでないようにする
 */

import java.util.Random;
import java.util.Scanner;

public class Exercise16 {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);

		int you, enemy;

		// YOUとENEMYが同じ数にならないようにする( do-while文仕様)
		do {
			you = rand.nextInt(9) + 1; // 1〜9
			enemy = rand.nextInt(9) + 1; // 1〜9

		} while (you == enemy); // 同じならやり直し

		// 画面に表示
		System.out.println("YOU: " + you + "  ENEMY: " + enemy);
		System.out.print("a[Attack]  OR  d[Defense] : ");

		// trim()は文字列の先頭と末尾のスペース（空白文字）を取り除くメソッド
		String input = scanner.nextLine().trim();

		// 最初は「勝ってない（false）」という状態でスタート。
		boolean win = false;

		// 勝利判定
		if (you > enemy && input.equals("a")) {
			win = true;
		} else if (you < enemy && input.equals("d")) {
			win = true;
		}

		// 結果出力
		if (win) {
			System.out.println("You Win!");
		} else {
			System.out.println("You Lose!");
		}

		scanner.close();

	}

}
