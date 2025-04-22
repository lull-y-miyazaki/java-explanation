/**
 * Step5：Gameクラスのmainメソッドにて、勇者または敵（ゾンビ）の生命力（HP）が0になるまで、
 * while文を利用して戦い続けるようにプログラムを修正しなさい。
 * 勇者が負けた場合は「ゲームオーバー」となり、処理を終了します。
 */

package kadai8.step5;

// ゲームを行うプログラム
public class Game {
	public static void main(String[] args) {
		System.out.println("★★★ゲーム開始★★★");

		// 🦸勇者（生命力：50、攻撃力：10）
		Actor hero = new Hero(50, 10);

		// 勇者の情報の表示
		System.out.println(hero);

		// 仕切り表示
		partition();

		// 🧟ゾンビ（生命力：15、攻撃力：5）
		Actor enemy = new Zombie(15, 5);

		// ゾンビの情報の表示
		System.out.println(enemy + "があらわれた！");

		// 仕切り表示
		partition();

		// while文で戦闘を行う
		// 勇者と敵のHPが0になるまで戦い続ける
		// ループを抜ける条件はif文で指定する
		while (true) {

			// 勇者から敵への攻撃
			// attackメソッドを呼び出し引数に敵を指定する
			hero.attack(enemy);

			// 敵の情報を表示
			System.out.println(" " + enemy);

			// 仕切り表示
			partition();

			// 敵のHPが0になったときwhileから抜ける
			if (enemy.getHp() == 0) {
				System.out.println(enemy.getName() + "を倒した！😄");
				partition();
				partition();

				break;
			}

			// 敵から勇者への攻撃
			// attackメソッドを呼び出し引数に勇者を指定する
			enemy.attack(hero);

			// 勇者の情報を表示
			System.out.println(" " + hero);

			partition();

			// 勇者のHPが0になったときwhileから抜ける
			// ゾンビの攻撃力を勇者のHPから引く
			if (hero.getHp() == 0) {

				// 勇者のHPが0になったとき
				System.out.println(hero.getName() + "はやられてしまった...😂");
				partition();
				partition();
				System.out.println("★★★ゲームオーバー★★★");
				return;
			}
		}

		System.out.println("★★★ゲーム終了★★★");
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