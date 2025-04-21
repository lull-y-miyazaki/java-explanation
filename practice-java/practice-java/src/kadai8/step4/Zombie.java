/**
 * Step4：Actorクラスを継承したHero（勇者）クラスとZoｍbie（ゾンビ）クラスを作成し、
 * attack()メソッドが呼ばれたときの処理を上書き（オーバーライド）して利用しなさい。
 *
 * ファイル名：Zombie.java
 * Actorクラスを継承する
 * コンストラクタ
	生命力と攻撃力のみを引数として取得し初期化します
	名前は「□ゾンビ」とします
	スーパークラスのコンストラクタを再利用します

 * 攻撃メソッド
	スーパークラスのattack()メソッドをオーバーライドします
	攻撃処理の前に「□ゾンビ（名前）の体当たり」と出力します
 */

package kadai8.step4;

// ゾンビクラス
// Actorクラスを継承することで、Actorクラスのフィールドやメソッドを利用できる
public class Zombie extends Actor {

	// 引数からすべてのフィールドを初期化するコンストラクタ
	public Zombie(int hp, int attack) {

		// スーパークラスのコンストラクタを呼び出す
		// 引数に名前、HP、攻撃力を渡す
		// 名前は「🧟‍ゾンビ」とする
		super("🧟‍ゾンビ", hp, attack);
	}

	// 攻撃する（オーバーライド）
	// Actorクラスのattackメソッドをオーバーライドする
	// 引数に攻撃対象のActorクラスのオブジェクトを渡す
	public void attack(Actor target) {

		System.out.println(getName() + "の体当たり！");
		// スーパークラスのattackメソッドを呼び出す
		// 引数に攻撃対象のActorクラスのオブジェクトを渡す
		super.attack(target);
	}
}