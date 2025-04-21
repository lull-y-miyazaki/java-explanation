/**
 * Step3：Gameクラスに、処理の仕切り「---------」を表示させるpartition()メソッドを作成し利用しなさい。
 * partition()は、仕切りを表示する直前で1秒だけ処理を待ちます。
 * partition()メソッド
	処理を1秒間一時停止する
	一時停止中にエラーが発生した場合は「待機処理でエラーが発生しました」とメッセージを出力し、処理を続行します
	仕切り文字「---------」を表示する

	出力結果（Step2と同じだが、仕切りが表示される際に1秒の待ちが発生する）

	ヒント
	「Java 一時停止」で検索してみましょう
 */

package kadai8.step3;

//ゲームを行うプログラム
public class Game {
	public static void main(String[] args) {

		System.out.println("★★★ゲーム開始★★★");

		// 🦸勇者（生命力：50、攻撃力：10）
		Actor hero = new Actor("🦸勇者", 50, 10);

		// 勇者の情報の表示
		System.out.println(hero);

		// 仕切り表示
		partition();

		// 🧟ゾンビ（生命力：15、攻撃力：5）
		Actor enemy = new Actor("🧟‍ゾンビ", 15, 5);

		// ゾンビの情報の表示
		System.out.println(enemy + "があらわれた！");

		// 仕切り表示
		partition();

		// 勇者から敵への攻撃
		// Actorクラスのattackメソッドを呼び出し、引数に相手のActorクラスのオブジェクトを渡す
		hero.attack(enemy);

		// 敵の情報を表示
		System.out.println(" " + enemy);

		// 仕切り表示
		partition();

		// 敵から勇者への攻撃
		// Actorクラスのattackメソッドを呼び出し、引数に相手のActorクラスのオブジェクトを渡す
		enemy.attack(hero);

		// 勇者の情報を表示
		System.out.println(" " + hero);

		partition();

		// 勇者から敵への攻撃
		// Actorクラスのattackメソッドを呼び出し、引数に相手のActorクラスのオブジェクトを渡す
		hero.attack(enemy);
		System.out.println(" " + enemy);

		// 仕切り表示
		partition();

		System.out.println("★★★ゲーム終了★★★");
	}

	// 仕切り表示（1秒ストップする）メソッド
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