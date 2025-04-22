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

// ドラゴンクラス（ボス）
public class Dragon extends Actor {

    // コンストラクタ
    public Dragon(int hp, int attack) {
        super("🐉ドラゴン", hp, attack); // 親クラスのコンストラクタを呼ぶ
    }

    // 攻撃する（オーバーライド）
    @Override
    public void attack(Actor target) {
        System.out.println(getName() + "の火炎ブレス！");

        // ボスは通常の1.5倍のダメージを与える
        int damage = (int)(getAttack() * 1.5);
        System.out.println("　" + target.getName() + "に" + damage + "のダメージを与えた！");

        // 相手のHPを自分の攻撃力分減らす
        target.setHp(target.getHp() - damage);
        // 相手のHPが0以下になった場合
        if (target.getHp() <= 0) {
            target.setHp(0);
        }
    }
}