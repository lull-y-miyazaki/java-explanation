/**
 * Step1：Actor（キャラクター）クラスを作成し、ゲームを実行するGameクラスのmainメソッドから利用しなさい。
 * ヒント
	toString()メソッドは以下のようにして省略し変数名のみでの呼び出しができます

	// オブジェクトの生成
	Actor a1 = new Actor(...);

	// 情報の出力
	System.out.println(a1.toString());

	// toString()の記述は省略することができる
	System.out.println(a1);
 */

package kadai8.step1;

// ゲームを行うプログラム
public class Game {
	public static void main(String[] args) {

		// 🦸勇者（生命力：50、攻撃力：10）
		Actor hero = new Actor("🦸勇者", 50, 10);

		// 勇者の情報の表示
		System.out.println(hero);

		// 🧟ゾンビ（生命力：15、攻撃力：5）
		Actor enemy = new Actor("🧟‍ゾンビ", 15, 5);

		// ゾンビの情報の表示
		System.out.println(enemy);
	}
}