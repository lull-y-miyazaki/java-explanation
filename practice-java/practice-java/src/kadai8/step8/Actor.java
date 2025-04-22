/**
 * Step8：行動の選択肢に「逃げる」を追加します。
 * 「逃げる」を選択した場合は、次の敵となり戦いが発生します。
 * 「逃げる」が選択された場合であっても、敵を3体倒さなければゲーム終了とはなりません。
 */

package kadai8.step8;

import java.util.Random;

// アクター（キャラクター）クラス
public class Actor {

	// フィールド
	private String name;
	private int maxHp; // 最大HP
	private int hp;
	private int attack;

	// コンストラクタ
	public Actor(String name, int hp, int attack) {
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
	public String toString() {
		return this.name + "(HP:" + this.hp + "/" + this.maxHp + ")";
	}

	// 攻撃する
	public void attack(Actor target) {
		System.out.println(" " + target.getName() + "に" + this.attack + "のダメージを与えた！");

		// 相手のHPを自分の攻撃力分減らす
		target.setHp(target.getHp() - this.attack);

		// 相手のHPが0以下になった場合
		if (target.getHp() <= 0) {
			target.setHp(0);
		}
	}

	// 回復する（最大HPの半分）
	public void heal() {
		System.out.println(this.name + "はHPを回復した！");
		// 最大HPの半分を回復する
		this.hp += this.maxHp / 2;

		// HPが最大HPを超えた場合は最大HPにする
		if (this.hp > this.maxHp) {
			this.hp = this.maxHp;
		}
	}

	// 敵をランダムに生成するメソッド（ファクトリーメソッド）
	public static Actor randomEnemy() {

		// 乱数を生成するためのRandomクラスのインスタンスを生成
		Random rand = new Random();
		int num = rand.nextInt(3); // 0, 1, 2の中からランダムな数字を生成

		// 0, 1, 2のいずれかの数字を生成し、敵を生成する
		// 0:ゾンビ（HP:10,攻撃力:5）
		if (num == 0) {
			// ゾンビ
			return new Zombie(10, 5);

		// 1:スケルトン（HP:20,攻撃力:10）
		} else if (num == 1) {
			// スケルトン
			return new Skeleton(20, 10);

		// 2:ゴースト（HP:30,攻撃力:15）
		} else if (num == 1) {
			// ゾンビ
			return new Zombie(20, 10);

		// 3:ゴースト（HP:30,攻撃力:15）
		} else {
			// ゴースト
			return new Ghost(30, 15);
		}
	}
}