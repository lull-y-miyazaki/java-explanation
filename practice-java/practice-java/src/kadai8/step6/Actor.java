/**
 * Step6：Actorクラスを継承したGhost（ゴースト）クラスを作成します。
 * Gameクラスのmainメソッドにて生成した敵と3回戦います。
 * 戦う敵は、ゾンビ（HP:10,攻撃力:5）、ゾンビ（HP:20,攻撃力:10）ゴースト（HP:30,攻撃力:15）から毎回ランダムに生成しなさい。
 */

package kadai8.step6;

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
	// オブジェクトクラスのtoStringメソッドをオーバーライドすることで、オブジェクトの情報を文字列として取得できるようにする
	public String toString() {
		return this.name + "(HP:" + this.hp + ")";
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