/**
 * Step6：Actorクラスを継承したGhost（ゴースト）クラスを作成します。
 * Gameクラスのmainメソッドにて生成した敵と3回戦います。
 * 戦う敵は、ゾンビ（HP:10,攻撃力:5）、ゾンビ（HP:20,攻撃力:10）ゴースト（HP:30,攻撃力:15）から毎回ランダムに生成しなさい。
 */

package kadai8.step6;

// ゾンビクラス
public class Zombie extends Actor {

	// コンストラクタ
	public Zombie(int hp, int attack) {
		super("🧟‍ゾンビ", hp, attack); //親クラスのコンストラクタを呼ぶ
	}

	// 攻撃する（オーバーライド）
	// 引数に攻撃対象を指定することで、攻撃対象のHPを減らす
	public void attack(Actor target) {
		System.out.println(getName() + "の体当たり！");

		// 攻撃対象のHPを減らす処理は親クラスのattackメソッドを呼び出す
		super.attack(target);
	}
}