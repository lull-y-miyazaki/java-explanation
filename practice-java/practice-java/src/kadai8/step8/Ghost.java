/**
 * Step8：行動の選択肢に「逃げる」を追加します。
 * 「逃げる」を選択した場合は、次の敵となり戦いが発生します。
 * 「逃げる」が選択された場合であっても、敵を3体倒さなければゲーム終了とはなりません。
 */

package kadai8.step8;

// ゴーストクラス
public class Ghost extends Actor {

	// コンストラクタ
	public Ghost(int hp, int attack) {
		super("👻ゴースト", hp, attack); //親クラスのコンストラクタを呼ぶ
	}

	// 攻撃する（オーバーライド）
	// Actorクラスのattackメソッドをオーバーライドして、ゴースト特有の攻撃を実装する
	// 引数にActorクラスのインスタンスを受け取る
	public void attack(Actor target) {

		System.out.println(getName() + "の叫び声！");

		// superキーワードを使うことで、親クラスのメソッドを呼び出すことができる
		super.attack(target);
	}
}