/**
 * Step2：Actorクラスに攻撃用のattack()メソッドを追加し、Gameクラスから利用しなさい。
	出力例：
	勇者の攻撃
	ゾンビに10のダメージを与えた！
 */

package kadai8.step2;

// ゲームを行うプログラム
public class Game {
	public static void main(String[] args) {

		System.out.println("★★★ゲーム開始★★★");

		// 🦸勇者（生命力：50、攻撃力：10）
		Actor hero = new Actor("🦸勇者", 50, 10);

		// 勇者の情報の表示
		System.out.println(hero);

		System.out.println("---------");

		// 🧟ゾンビ（生命力：15、攻撃力：5）
		Actor enemy = new Actor("🧟‍ゾンビ", 15, 5);

		// ゾンビの情報の表示
		System.out.println(enemy + "があらわれた！");

		System.out.println("---------");

		// 勇者から敵への攻撃
		// Actorクラスのattackメソッドを呼び出し、引数に相手のActorクラスのオブジェクトを渡す
		hero.attack(enemy);

		// 敵の情報を表示
		System.out.println(" " + enemy);

		System.out.println("---------");

		// 敵から勇者への攻撃
		// Actorクラスのattackメソッドを呼び出し、引数に相手のActorクラスのオブジェクトを渡す
		enemy.attack(hero);

		// 勇者の情報を表示
		System.out.println(" " + hero);

		System.out.println("---------");

		// 勇者から敵への攻撃
		hero.attack(enemy);

		System.out.println(" " + enemy);

		System.out.println("---------");

		System.out.println("★★★ゲーム終了★★★");
	}
}