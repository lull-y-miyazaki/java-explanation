/**
 * Step6：Actorクラスを継承したGhost（ゴースト）クラスを作成します。
 * Gameクラスのmainメソッドにて生成した敵と3回戦います。
 * 戦う敵は、ゾンビ（HP:10,攻撃力:5）、ゾンビ（HP:20,攻撃力:10）ゴースト（HP:30,攻撃力:15）から毎回ランダムに生成しなさい。
 */

package kadai8.step6;

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