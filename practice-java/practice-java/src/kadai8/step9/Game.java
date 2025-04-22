/**
 * Step9：行動選択前に「ステータス」を表示します。
 * ステータスの表示では「生命力/最大生命力」の割合を視覚的に出力します。
 */

package kadai8.step9;

import java.util.InputMismatchException;
import java.util.Scanner;

// ゲームを行うプログラム
public class Game {

	// 選択コマンド定数
	private final static int ATTACK = 1; // 戦う
	private final static int HEAL = 2; // 回復
	private final static int RUN_AWAY = 3; // 逃げる

	// メイン
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("★★★ゲームスタート★★★");

		partition();

		// 勇者オブジェクトの生成
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

			// 勇者または敵の生命力が0になるまで戦い続ける
			while (true) {

				// 勇者と敵の情報を表示
				System.out.println("📖ステータス");
				hero.status();
				enemy.status();
				partition();

				// 勇者が戦うか逃げるかを選択する
				System.out.println("🎮どうしますか？");
				System.out.print("　[1]攻撃 [2]回復 [3]逃げる：");

				int input = 0; // 初期値:0
				try {
					input = scan.nextInt();

				} catch (InputMismatchException e) {

					// intの値として取得できなかった場合
					scan.next(); // 取得できなかった文字列を除去
					System.out.println("1,2のどちらかを選択してください");
					continue; // もう一度入力から
				}
				partition();

				// 攻撃
				if (input == ATTACK) {

					// 勇者の攻撃で敵を倒した場合はループを抜ける（次の敵へ）
					if (winBattle(hero, enemy)) {
						break;
					}

					// 敵の攻撃で勇者が倒れた場合は処理を終える
					if (loseBattle(hero, enemy)) {
						scan.close();
						return;
					}
				}
				// 回復
				else if (input == HEAL) {

					// 勇者の回復
					hero.heal();

					// 勇者の情報を出力する
					hero.status();
					partition();

					// 敵の攻撃で勇者が倒れた場合は処理を終える
					if (loseBattle(hero, enemy)) {
						scan.close();
						return;
					}
				}
				// 逃げる
				else if (input == RUN_AWAY) {

					System.out.println(hero.getName() + "は逃げ出した！");
					partition();
					// 逃げ出したときは敵を倒したカウントをすすめない
					i--;
					break; // 次の敵へ
				}
				// どちらでもない場合
				else {
					System.out.println("1,2のどちらかを選択してください");
					partition();
					continue; // もう一度入力から
				}
			}
		}

		System.out.println("全ての敵を倒した！");
		partition();
		System.out.println("★★★ゲームクリア★★★");

		scan.close();

	}

	// 「戦う」によって敵を倒したか否か
	private static boolean winBattle(Actor hero, Actor enemy) {

		// 勇者の攻撃
		hero.attack(enemy);

		// 敵の情報を出力する
		enemy.status();
		partition();

		if (enemy.getHp() == 0) {
			System.out.println(enemy.getName() + "を倒した！😄");
			partition();
			partition();
			return true;
		}

		return false;
	}

	// 敵の攻撃によって敗北したか否か
	private static boolean loseBattle(Actor hero, Actor enemy) {

		// 敵の攻撃
		enemy.attack(hero);

		// 勇者の情報を出力する
		hero.status();
		partition();

		if (hero.getHp() == 0) {
			System.out.println(hero.getName() + "はやられてしまった...😂");
			partition();
			partition();
			System.out.println("★★★ゲームオーバー★★★");
			return true;
		}
		return false;
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