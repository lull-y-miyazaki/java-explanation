/**
 * Step9：行動選択前に「ステータス」を表示します。ステータスの表示では「生命力/最大生命力」の割合を視覚的に出力します。
 */

package kadai8.step9;

import java.util.Random;

// アクター（キャラクター）クラス
public class Actor {
	// フィールド
	private String name; // 名前
	private int maxHp; // 最大HP
	private int hp; // HP
	private int attack; // 攻撃力

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

	// ステータス表示
	public void status() {

		// thisは、現在のインスタンス自体を指す
		System.out.println("　" + this);
		System.out.println("　" + getHpBar());
	}

	// 攻撃する
	public void attack(Actor target) {
		System.out.println("　" + target.getName() + "に" + this.attack + "のダメージを与えた！");
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
		if (this.hp > this.maxHp) {
			this.hp = this.maxHp;
		}
	}

	// 生命力（HP）をバーで表示する
	public String getHpBar() {
		// 現在のHPが最大HPのうちどれくらいかを10段階に換算
		int hpBlock = 10 * hp / maxHp;

		// 0～10の間でHPを表示するためのバーを作成
		// 例）[██████████]（10段階でHPが満タン）
		String bar = "[";

		// 10マス分のバーを作るために、0〜9のループを実行
		for (int i = 0; i < 10; i++) {

			// ループの中で、HPがある分だけ「█」を表示し、残りは「 」を表示する
			if (i < hpBlock) {

				// +=演算子を使って、文字列を連結する
				// 例）bar += "█";　→　bar = bar + "█";
				bar += "█";

			// それ以外は「 」を表示する
			} else {
				bar += " ";
			}
		}

		// バーの最後に「]」をつけて完成
		bar += "]";
		return bar;
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