/**
 * Step3：Gameクラスに、処理の仕切り「---------」を表示させるpartition()メソッドを作成し利用しなさい。
 * partition()は、仕切りを表示する直前で1秒だけ処理を待ちます。
 */
package kadai8.step3;

// アクター（キャラクター）クラス
public class Actor {

	// フィールドは、クラスの外からアクセスできないようにするため、private修飾子をつける
	// 名前
	private String name;
	// HP
	private int hp;
	// 攻撃力
	private int attack;

	// 引数からすべてのフィールドを初期化するコンストラクタ
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
	// toStringメソッドは、オブジェクトを文字列に変換するためのメソッド
	// オブジェクトを文字列として表示するために、toStringメソッドをオーバーライドする
	public String toString() {
		return this.name + "(HP:" + this.hp + ")";
	}

	// 攻撃するメソッド
	// 引数：Actorのオブジェクトtarget（攻撃するターゲット）
	public void attack(Actor target) {

		// 攻撃するキャラクターの名前を出力する
		System.out.println(this.name + "の攻撃");

		// 攻撃したキャラクターの名前と、ターゲットに与えたダメージを出力する
		System.out.println(" " + target.getName() + "に" + this.attack + "のダメージを与えた！");

		// 相手のHPを自分の攻撃力分減らす
		target.setHp(target.getHp() - this.attack);

		// 相手のHPが0以下になった場合
		if (target.getHp() <= 0) {

			// HPを0に上書きする
			target.setHp(0);
		}
	}
}