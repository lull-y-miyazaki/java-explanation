package exam;

import java.util.Random;
import java.util.Scanner;

/**
 * じゃんけんプログラムを作成しなさい
 * ・プレイヤーの手はキーボードから入力するものとする
 * ・コンピュータの手はランダムに出力されるものとする
 * ・キーボードから入力する値は数値とする（1がグー、2がチョキ、3がパー）
 */
public class Exam8 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		// Randomクラスは、乱数を生成するためのクラス
		Random random = new Random();

		// プレイヤーとコンピューターの手を決める
		System.out.println("1:グー、2:チョキ、3:パー から選択してください");
		System.out.print("じゃん、けん、、、：");

		// プレイヤーの手をキーボードから入力
		int you = scan.nextInt();
		// random.nextInt(3)は0から2までの乱数を生成
		// +1することで1から3までの乱数になる
		int com = random.nextInt(3) + 1;

		// プレイヤーがグーを出した場合
		if (you == 1) {
			System.out.println("あなたはグー！");
			if (com == 1) {
				System.out.println("コンピュータはグー！");
				System.out.println("引き分けでした");
			} else if (com == 2) {
				System.out.println("コンピュータはチョキ！");
				System.out.println("あなたの勝ち");
			} else if (com == 3) {
				System.out.println("コンピュータはパー！");
				System.out.println("あなたの負け");
			}

			// プレイヤーがチョキを出した場合
		} else if (you == 2) {
			System.out.println("あなたはチョキ！");
			if (com == 1) {
				System.out.println("コンピュータはグー！");
				System.out.println("あなたの負け");
			} else if (com == 2) {
				System.out.println("コンピュータはチョキ！");
				System.out.println("引き分けでした");
			} else if (com == 3) {
				System.out.println("コンピュータはパー！");
				System.out.println("あなたの勝ち");
			}

			// プレイヤーがパーを出した場合
		} else if (you == 3) {
			System.out.println("あなたはパー！");
			if (com == 1) {
				System.out.println("コンピュータはグー！");
				System.out.println("あなたの勝ち");
			} else if (com == 2) {
				System.out.println("コンピュータはチョキ！");
				System.out.println("あなたの負け");
			} else if (com == 3) {
				System.out.println("コンピュータはパー！");
				System.out.println("引き分けでした");
			}

		} else {
			System.out.println("1,2,3のどれかを入力してください");
		}

		scan.close();

	}
}