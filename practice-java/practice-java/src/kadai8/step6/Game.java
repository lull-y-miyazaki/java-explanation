/**
 * Step6：Actorクラスを継承したGhost（ゴースト）クラスを作成します。
 * Gameクラスのmainメソッドにて生成した敵と3回戦います。
 * 戦う敵は、ゾンビ（HP:10,攻撃力:5）、ゾンビ（HP:20,攻撃力:10）ゴースト（HP:30,攻撃力:15）から毎回ランダムに生成しなさい。
 */

package kadai8.step6;

//ゲームを行うプログラム
public class Game {
	public static void main(String[] args) {
		System.out.println("★★★ゲーム開始★★★");

		// 🦸勇者（生命力：50、攻撃力：10）
		Actor hero = new Hero(50, 10);

		// 勇者の情報の表示
		System.out.println(hero);

		partition();

		// 連続して3体の敵と戦う
		// for(初期化; 条件式; 更新処理)
		for (int i = 0; i < 3; i++) {

			// ランダムな敵オブジェクトの生成
			Actor enemy = Actor.randomEnemy();

			// 敵の情報の表示
			System.out.println(enemy + "があらわれた💡");

			// 仕切り表示（1秒ストップする）
			partition();

			// 条件式がtrueの間、繰り返し処理を行う
			while (true) {

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

				// 勇者のHPが0になったときwhileから抜ける
				if (hero.getHp() == 0) {
					System.out.println(hero.getName() + "はやられてしまった...😂");
					partition();
					partition();
					System.out.println("★★★ゲームオーバー★★★");
					return;
				}
			}

		}
		System.out.println("全ての敵を倒した！");
		partition();
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