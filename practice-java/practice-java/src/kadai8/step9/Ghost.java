/**
 * Step9：行動選択前に「ステータス」を表示します。
 * ステータスの表示では「生命力/最大生命力」の割合を視覚的に出力します。
 */

package kadai8.step9;

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