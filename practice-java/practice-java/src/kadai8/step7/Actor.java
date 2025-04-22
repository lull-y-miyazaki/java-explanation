/**
 * Step7：ゲーム中、プレイヤーが「攻撃」か「回復」を選択ができるようにします。
 */

package kadai8.step7;

// ランダムな敵を生成するために必要なインポート
import java.util.Random;

// アクター（キャラクター）クラス
public class Actor {

	// フィールド
	// private修飾子をつけることで、他のクラスから直接アクセスできないようにする
	private String name; // 名前
	private int hp; // HP
	private int attack; // 攻撃力

	// コンストラクタ
	public Actor(String name, int hp, int attack) {

		// this.でフィールドを指定することで、引数と区別する
		this.name = name;
		this.maxHp = hp;
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

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
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
	// オブジェクトクラスのtoStringメソッドをオーバーライドすることで、オブジェクトの情報を文字列として取得できるようにする
	public String toString() {
		return this.name + "(HP:" + this.hp + "/" + this.maxHp + ")";
	}

	// 攻撃する
	// 引数に攻撃対象を指定することで、攻撃対象のHPを減らす
	public void attack(Actor target) {

		System.out.println(" " + target.getName() + "に" + this.attack + "のダメージを与えた！");

		// 相手のHPを自分の攻撃力分減らす
		target.setHp(target.getHp() - this.attack);

		// 0以下になった場合は0にすることで、HPがマイナスになることを防ぐ
		if (target.getHp() <= 0) {
			target.setHp(0);
		}
	}

	// 回復する（最大HPの半分）
	public void heal() {
		System.out.println(this.name + "はHPを回復した！");

		// 最大HPの半分を回復する
		// +=は加算代入演算子で、this.hp = this.hp + this.maxHp / 2;と同じ意味
		this.hp += this.maxHp / 2;

		// HPが最大HPを超えないようにする
		if (this.hp > this.maxHp) {

			// 最大HPを超えた場合は最大HPにする
			this.hp = this.maxHp;
		}
	}

	// 敵をランダムに生成するメソッド（ファクトリーメソッド）
	public static Actor randomEnemy() {

		// ランダムな敵を生成するためのRandomクラスのインスタンスを生成
		Random rand = new Random();

		// 0, 1, 2の中からランダムな数字を生成
		int num = rand.nextInt(3);

		// numの値によって生成する敵を変える
		// 0:ゾンビ（HP:10,攻撃力:5）
		if (num == 0) {
			// ゾンビ
			return new Zombie(10, 5);

		// 1:ゾンビ（HP:20,攻撃力:10）
		} else if (num == 1) {
			// ゾンビ
			return new Zombie(20, 10);

		// 2:ゴースト（HP:30,攻撃力:15）
		} else {
			// ゴースト
			return new Ghost(30, 15);
		}
	}
}