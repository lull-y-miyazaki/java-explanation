/**
 * Step5：Gameクラスのmainメソッドにて、勇者または敵（ゾンビ）の生命力（HP）が0になるまで、
 * while文を利用して戦い続けるようにプログラムを修正しなさい。
 * 勇者が負けた場合は「ゲームオーバー」となり、処理を終了します。
 */

package kadai8.step5;

// アクター（キャラクター）クラス
public class Actor {

	// フィールド
	// private修飾子をつけることで、他のクラスから直接アクセスできないようにする
	private String name; // 名前
	private int hp; // HP
	private int attack; // 攻撃力

	// 引数の値をフィールドに代入するコンストラクタ
	public Actor(String name, int hp, int attack) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
	}

	// ゲッター・セッター
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	// 情報取得用toStringメソッド
	// オブジェクトクラスのtoStringメソッドをオーバーライドして、オブジェクトの情報を文字列として返す
	public String toString() {
		return this.name + "(HP:" + this.hp + ")";
	}

	// 攻撃する
	// 引数に攻撃対象を指定することで、攻撃対象のHPを減らす
	public void attack(Actor target) {

		System.out.println(" " + target.getName() + "に" + this.attack + "のダメージを与えた！");

		// 相手のHPを自分の攻撃力分減らす
		target.setHp(target.getHp() - this.attack);

		// 相手のHPが0以下になった場合
		if (target.getHp() <= 0) {

			// 0以下になった場合はHPを0にする
			target.setHp(0);
		}
	}
}