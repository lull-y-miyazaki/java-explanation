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

// 勇者のサブクラス
public class Hero extends Actor {
    // 武器フィールドを追加
    private Weapon weapon;

    // 引数の値をフィールドに代入するコンストラクタ
    public Hero(int hp, int attack) {
        super("🦸勇者", hp, attack); //親クラスのコンストラクタを呼ぶ
        this.weapon = null; // 初期状態では武器を持っていない
    }

    // 武器を装備するメソッド
    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
        System.out.println(getName() + "は" + weapon.getName() + "を装備した！");
    }

    // 現在装備している武器を取得するメソッド
    public Weapon getWeapon() {
        return weapon;
    }

    // 攻撃する（オーバーライド）
    // 武器による攻撃力の補正を行う
    @Override
    public void attack(Actor target) {
        System.out.println(getName() + "は剣で切りつけた");

        // 基本攻撃力を取得
        int totalAttack = getAttack();

        // 武器を装備している場合は追加攻撃力を加算
        if (weapon != null) {
            totalAttack += weapon.getAdditionalAtk();
            System.out.println("　" + weapon.getName() + "の力が加わった！");
        }

        // 攻撃対象にダメージを与える
        System.out.println("　" + target.getName() + "に" + totalAttack + "のダメージを与えた！");

        // 相手のHPを攻撃力分減らす
        target.setHp(target.getHp() - totalAttack);
        // 相手のHPが0以下になった場合
        if (target.getHp() <= 0) {
            target.setHp(0);
        }
    }

    // ステータス表示をオーバーライドして武器情報も表示
    @Override
    public void status() {
        super.status();
        if (weapon != null) {
            System.out.println("　装備：" + weapon);
        }
    }
}