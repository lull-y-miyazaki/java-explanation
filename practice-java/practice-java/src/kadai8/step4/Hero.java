/**
 * Step4：Actorクラスを継承したHero（勇者）クラスとZoｍbie（ゾンビ）クラスを作成し、
 * attack()メソッドが呼ばれたときの処理を上書き（オーバーライド）して利用しなさい。
 *
 * ファイル名：Hero.java
 * Actorクラスを継承する
 * コンストラクタ
	生命力と攻撃力のみを引数として取得し初期化します
	名前は「□勇者」とします
	スーパークラスのコンストラクタを再利用します
 * 攻撃メソッド
	スーパークラスのattack()メソッドをオーバーライドします
	攻撃処理の前に「□勇者（名前）は剣で切りつけた」と出力します
 */

package kadai8.step4;

// 勇者のサブクラス
// Actorクラスを継承することで、Actorクラスのフィールドやメソッドを利用できる
public class Hero extends Actor {

	// 引数からすべてのフィールドを初期化するコンストラクタ
	public Hero(int hp, int attack) {

		// スーパークラスのコンストラクタを呼び出す
		// 引数に名前、HP、攻撃力を渡す
		// 名前は「🦸勇者」とする
		super("🦸勇者", hp, attack);
	}

	// 攻撃する（オーバーライド）
	// Actorクラスのattackメソッドをオーバーライドする
	// 引数に攻撃対象のActorクラスのオブジェクトを渡す
	public void attack(Actor target) {

		System.out.println(getName() + "は剣で切りつけた");
		// スーパークラスのattackメソッドを呼び出す
		super.attack(target);
	}
}