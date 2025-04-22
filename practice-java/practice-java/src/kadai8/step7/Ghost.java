/**
 * Step7：ゲーム中、プレイヤーが「攻撃」か「回復」を選択ができるようにします。
 */

package kadai8.step7;

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