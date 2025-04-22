/**
 * Step8：行動の選択肢に「逃げる」を追加します。
 * 「逃げる」を選択した場合は、次の敵となり戦いが発生します。
 * 「逃げる」が選択された場合であっても、敵を3体倒さなければゲーム終了とはなりません。
 */

package kadai8.step8;

// 勇者のサブクラス
public class Hero extends Actor {

	// 引数の値をフィールドに代入するコンストラクタ
	public Hero(int hp, int attack) {
		super("🦸勇者", hp, attack); //親クラスのコンストラクタを呼ぶ
	}

	// 攻撃する（オーバーライド）
	// 引数に攻撃対象を指定することで、攻撃対象のHPを減らす
	// 攻撃対象のHPを減らす処理は親クラスのattackメソッドを呼び出す
	public void attack(Actor target) {
		System.out.println(getName() + "は剣で切りつけた");

		// 親クラスのattackメソッドを呼び出す
		super.attack(target);
	}
}