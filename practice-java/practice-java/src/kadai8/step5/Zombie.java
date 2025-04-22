/**
 * Step5：Gameクラスのmainメソッドにて、勇者または敵（ゾンビ）の生命力（HP）が0になるまで、
 * while文を利用して戦い続けるようにプログラムを修正しなさい。
 * 勇者が負けた場合は「ゲームオーバー」となり、処理を終了します。
 */

package kadai8.step5;

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