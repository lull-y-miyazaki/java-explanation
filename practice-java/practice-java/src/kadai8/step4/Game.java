/**
 * Step4：Actorクラスを継承したHero（勇者）クラスとZoｍbie（ゾンビ）クラスを作成し、
 * attack()メソッドが呼ばれたときの処理を上書き（オーバーライド）して利用しなさい。
 *
 * ファイル名：Game.java
 * Heroオブジェクトを生成し、Actorクラスの変数に代入して利用します
 * Zombieオブジェクトを生成し、Actorクラスの変数に代入して利用します
 */

package kadai8.step4;

//ゲームを行うプログラム
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

		// 勇者から敵への攻撃
		hero.attack(enemy);

		// 敵の情報を表示
		System.out.println(" " + enemy);

		// 仕切り表示
		partition();

		// 敵から勇者への攻撃
		enemy.attack(hero);

		// 勇者の情報を表示
		System.out.println(" " + hero);

		// 仕切り表示
		partition();

		// 勇者から敵への攻撃
		hero.attack(enemy);
		System.out.println(" " + enemy);

		// 仕切り表示
		partition();

		System.out.println("★★★ゲーム終了★★★");
	}

	// 仕切り表示（1秒ストップ）するメソッド
	private static void partition() {

		//try-catch文を使って、例外処理を行う
		// 例外処理を行うことで、エラーが発生してもプログラムが終了しないようにする
		try {

			// 1秒間処理を一時停止する
			// 引数に指定した時間（ミリ秒）だけスレッドを一時停止する
			Thread.sleep(1000);

		// InterruptedExceptionは、スレッドが割り込まれた場合に発生する例外
		// 例外が発生した場合は、エラーメッセージを表示する
		} catch (InterruptedException e) {

			System.out.println("処理中にエラーが発生しました");

			// e.printStackTrace()は、エラーの詳細情報を表示するメソッド
			// スタックトレースを表示することで、エラーの原因を特定しやすくする
			e.printStackTrace();
		}
		System.out.println("---------");
	}
}