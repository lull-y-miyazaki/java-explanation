/**
 * Step8：行動の選択肢に「逃げる」を追加します。
 * 「逃げる」を選択した場合は、次の敵となり戦いが発生します。
 * 「逃げる」が選択された場合であっても、敵を3体倒さなければゲーム終了とはなりません。
 */

package kadai8.step8;

import java.util.InputMismatchException;
import java.util.Scanner;

//ゲームを行うプログラム
public class Game {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("★★★ゲーム開始★★★");

		// 🦸勇者（生命力：50、攻撃力：10）
		Actor hero = new Hero(50, 10);

		// 勇者の情報の表示
		System.out.println(hero);

		partition();

		// 連続して3体の敵と戦う
		for (int i = 0; i < 3; i++) {

			// ランダムな敵オブジェクトの生成
			Actor enemy = Actor.randomEnemy();

			// 敵の情報の表示
			System.out.println(enemy + "があらわれた💡");
			partition();

			while (true) {

				// 勇者が戦うか逃げるかを選択する
				System.out.println("🎮どうしますか？");
				System.out.print(" [1]攻撃 [2]回復 [3]逃げる：");

				int input = 0; // 初期値:0

				try {
					input = scan.nextInt();

				} catch (InputMismatchException e) {
					// intの値として取得できなかった場合
					scan.next(); // 取得できなかった文字列を除去
					System.out.println("1,2,3のどちらかを選択してください");
					continue; // もう一度入力から
				}

				partition();

				if (input == 1) {
					// 攻撃
					// 勇者から敵への攻撃
					hero.attack(enemy);

					// 敵の情報を表示
					System.out.println(" " + enemy);

					partition();

					// 敵のHPが0になったときwhileから抜ける
					if (enemy.getHp() == 0) {
						System.out.println(enemy.getName() + "を倒した！😄");
						partition();
						partition();
						break;
					}

					// 敵から勇者への攻撃
					enemy.attack(hero);

					// 勇者の情報を表示
					System.out.println(" " + hero);

					partition();

					if (hero.getHp() == 0) {
						System.out.println(hero.getName() + "はやられてしまった...😂");
						partition();
						partition();
						System.out.println("★★★ゲームオーバー★★★");
						scan.close();
						return;
					}
				} else if (input == 2) {
					// 回復
					hero.heal();

					// 勇者の情報を表示
					System.out.println(" " + hero);
					partition();

					// 敵から勇者への攻撃
					enemy.attack(hero);

					// 勇者の情報を表示
					System.out.println(" " + hero);

					partition();

					if (hero.getHp() == 0) {
						System.out.println(hero.getName() + "はやられてしまった...😂");
						partition();
						partition();
						System.out.println("★★★ゲームオーバー★★★");
						scan.close();
						return;
					}
				} else if (input == 3) {

					System.out.println(hero.getName() + "は逃げ出した！");
					partition();
					// 逃げ出したときは敵を倒したカウントをすすめない
					i--;
					break; // 次の敵へ

				} else {
					// その他
					System.out.println("1,2,3のどちらかを選択してください");
					continue; // もう一度入力から
				}
			}
		}

		System.out.println("全ての敵を倒した！");
		partition();
		System.out.println("★★★ゲーム終了★★★");

		scan.close();
	}

	// 仕切り表示（1秒ストップする）
	private static void partition() {
		// try-catch文で例外処理を行う
		// 例外処理を行うことで、プログラムが強制終了するのを防ぐ
		try {

			// thread.sleepメソッドを使って1秒ストップする
			// 引数にミリ秒を指定する
			// 1000ミリ秒 = 1秒
			Thread.sleep(1000);

		// InterruptedExceptionはスレッドが割り込まれたときに発生する例外
		} catch (InterruptedException e) {

			System.out.println("処理中にエラーが発生しました");

			// e.printStackTrace()メソッドを使うことで、エラーの詳細を表示する
			e.printStackTrace();
		}
		System.out.println("---------");
	}
}