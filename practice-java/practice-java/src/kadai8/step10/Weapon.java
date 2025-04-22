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

// 武器クラス
public class Weapon {
    // フィールド
    private String name;        // 武器の名前
    private int additionalAtk;  // 追加攻撃力

    // コンストラクタ
    public Weapon(String name, int additionalAtk) {
        this.name = name;
        this.additionalAtk = additionalAtk;
    }

    // ゲッター・セッター
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAdditionalAtk() {
        return additionalAtk;
    }

    public void setAdditionalAtk(int additionalAtk) {
        this.additionalAtk = additionalAtk;
    }

    // 情報取得用toStringメソッド
    @Override
    public String toString() {
        return name + "(攻撃力+:" + additionalAtk + ")";
    }
}