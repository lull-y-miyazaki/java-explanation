/**
 * Step8：行動の選択肢に「逃げる」を追加します。
 * 「逃げる」を選択した場合は、次の敵となり戦いが発生します。
 * 「逃げる」が選択された場合であっても、敵を3体倒さなければゲーム終了とはなりません。
 */

package kadai8.step8;

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