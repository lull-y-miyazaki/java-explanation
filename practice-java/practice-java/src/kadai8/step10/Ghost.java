/**
 * Step10：RPGゲームに対して以下の機能を追加してみましょう（解答なし）
 *
 * 3体全ての敵を倒した後にボス（ドラゴン）が登場して戦いになる
 *
 * Gameクラスのmainメソッドを処理のまとまりをみつけてメソッド化する
 *
 * 勇者にはフィールドに武器を装備できるようにし、攻撃力の補正を行う
	* Weapon（武器）クラスを作り、フィールドには「名前、追加攻撃力」をセットできるようにする
	* Hero（勇者）クラスのフィールドにWeaponオブジェクトを保持できるようにする
	* attack()メソッドないで、攻撃する瞬間に攻撃力の補正が行われるようにする
 */

package kadai8.step10;

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