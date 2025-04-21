/**
 * Step1：Actor（キャラクター）クラスを作成し、ゲームを実行するGameクラスのmainメソッドから利用しなさい。
 * Actor（キャラクター）クラスの仕様

フィールド
	名前（name）、文字列、外部からのアクセス禁止
	生命力（hp）、整数、外部からのアクセス禁止
	攻撃力（attack）、整数、外部からのアクセス禁止

コンストラクタ
	引数からすべてのフィールドを初期化するコンストラクタ

	メソッド
	全てのフィールドに対するゲッター、セッター
	toString() メソッド
	引数なし
	戻り値：文字列
	フィールドに保持されている名前と生命力の状態を文字列にして返却する
	例「［名前］（HP:［生命力］）」
	勇者リスキル（HP:100）
 */

package kadai8.step1;

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

}

// 参考：
// toStringメソッドについて

// toStringメソッドは、Objectクラスに定義されているメソッドで、オブジェクトを文字列に変換するためのメソッド
// すべてのクラスはObjectクラスを継承しているため、toStringメソッドをオーバーライドすることで、
// 自分のクラスのオブジェクトを文字列として表示することができる。

// 例えば、System.out.println()メソッドでオブジェクトを表示すると、
// 自動的にtoStringメソッドが呼び出されて、オブジェクトの文字列が表示されます。
// ただし、デフォルトのtoStringメソッドは、オブジェクトのクラス名とハッシュコードを表示するだけなので、
// toStringメソッドをオーバーライドすることで、自分のクラスのオブジェクトを表示する際に、
// どのような文字列を表示するかを指定することができる。