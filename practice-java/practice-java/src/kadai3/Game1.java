// Step8：コンピュータがランダムに抽出した数（0から99まで）を当てるゲームを作成しなさい。
// 0から99のランダムな数字を返すメソッドと、ランダムな数字とキーボードから入力した入力した数字を引数として
// 2つの数字の大小判定をするメソッドの2つのメソッドを作成し、利用しなさい。

// このプログラムは数字当てゲームです
package kadai3;

// 必要な機能を外部から取り込む
// ランダムな数字を生成するために使用
import java.util.Random;

// キーボードからの入力を受け取るために使用
import java.util.Scanner;

public class Game1 {

	public static void main(String[] args) {

		// プレイヤーが答えた回数を記録する変数
		int count = 0;

		// キーボード入力を受け取るための準備
		Scanner scan = new Scanner(System.in);

		// 0から99のランダムな数字を答えとして設定
		int answer = makeAnswer();

		// 正解するまで繰り返す
		while (true) {

			// プレイヤーに数字の入力を促す
			System.out.print("数字を入力してください：");

			// プレイヤーが入力した数字を受け取る
			int input = scan.nextInt();

			// 入力回数を1増やす
			count++;

			// 入力された数字が正解かチェック
			if (checkAnswer(input, answer)) {

				// 正解した場合、何回で当てたかを表示
				System.out.println(count + "回で当たりました！");

				break;
			}
		}

		// キーボード入力の準備を終了
		scan.close();
	}

	// プレイヤーの入力が正解かどうかをチェックするメソッド
	private static boolean checkAnswer(int input, int answer) {

		// 入力された数字が正解と一致する場合
		if (input == answer) {

			// 正解メッセージを表示
			System.out.println("** 当たりです **");

			// 正解を返す
			return true;

		// 入力された数字が正解と一致しない場合
		} else {

			// 入力された数字が正解より大きい場合
			if (input > answer) {
				System.out.println("** 大きすぎです **");

			// 入力された数字が正解より小さい場合
			} else {
				System.out.println("** 小さすぎです **");
			}

			// 不正解を返す
			return false;
		}
	}

	// 0から99までのランダムな数字を生成するメソッド
	private static int makeAnswer() {

		// ランダムな数字を生成するための準備
		Random rand = new Random();

		// 0から99までのランダムな数字を返す
		return rand.nextInt(100);
	}
}
