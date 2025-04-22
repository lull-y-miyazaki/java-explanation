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

import java.util.InputMismatchException;
import java.util.Scanner;

// ゲームを行うプログラム
public class Game {

    // 選択コマンド定数
    private final static int ATTACK = 1; // 戦う
    private final static int HEAL = 2; // 回復
    private final static int RUN_AWAY = 3; // 逃げる
    private final static int EQUIP = 4; // 武器装備（新しいコマンド）

    // メイン
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("★★★ゲームスタート★★★");
        partition();

        // 勇者オブジェクトの生成
        Hero hero = new Hero(50, 10);

        // 勇者の情報の表示
        System.out.println(hero);

        // 最初の武器を装備（長剣：攻撃力+5）
        hero.equipWeapon(new Weapon("長剣", 5));
        partition();

        // 通常の敵と戦う
        boolean clearedNormalEnemies = fightNormalEnemies(scan, hero);

        // 通常の敵をクリアできた場合はボスと戦う
        if (clearedNormalEnemies) {
            // ボス戦前に強力な武器を手に入れる
            System.out.println("強力な武器を見つけた！");
            hero.equipWeapon(new Weapon("伝説の剣", 15));
            partition();

            fightBoss(scan, hero);
        }

        scan.close();
    }

    // 通常の敵（3体）と戦うメソッド
    private static boolean fightNormalEnemies(Scanner scan, Hero hero) {
        // 連続して3体の敵と戦う
        for (int i = 0; i < 3; i++) {
            // ランダムな敵オブジェクトの生成
            Actor enemy = Actor.randomEnemy();

            // 敵の情報の表示
            System.out.println(enemy + "があらわれた💡");
            partition();

            // 敵との戦闘
            boolean result = battle(scan, hero, enemy, false);

            // 勇者が倒れた場合は処理を終える
            if (!result) {
                return false;
            }
        }

        System.out.println("全ての敵を倒した！");
        partition();

        return true;
    }

    // ボスと戦うメソッド
    private static void fightBoss(Scanner scan, Hero hero) {
        System.out.println("ボスがあらわれた！");
        partition();

        // ボスオブジェクトの生成（HP:100, 攻撃力:20）
        Actor boss = new Dragon(100, 20);

        // ボスの情報の表示
        System.out.println(boss + "があらわれた💡");
        partition();

        // ボスとの戦闘（逃げられない）
        boolean result = battle(scan, hero, boss, true);

        if (result) {
            System.out.println("ボスを倒した！");
            partition();
            System.out.println("★★★ゲームクリア★★★");
        }
    }

    // 戦闘を行うメソッド
    private static boolean battle(Scanner scan, Hero hero, Actor enemy, boolean isBossBattle) {
        // 勇者または敵の生命力が0になるまで戦い続ける
        while (true) {
            // 勇者と敵の情報を表示
            displayStatus(hero, enemy);

            // コマンド選択
            int input = selectCommand(scan, isBossBattle);
            partition();

            // 選択したコマンドに応じた処理
            switch (input) {
                case ATTACK:
                    // 勇者の攻撃で敵を倒した場合はループを抜ける
                    if (winBattle(hero, enemy)) {
                        return true;
                    }

                    // 敵の攻撃で勇者が倒れた場合は処理を終える
                    if (loseBattle(hero, enemy)) {
                        return false;
                    }
                    break;

                case HEAL:
                    // 回復処理
                    if (!handleHealing(hero, enemy)) {
                        return false;
                    }
                    break;

                case RUN_AWAY:
                    // ボス戦では逃げられない
                    if (isBossBattle) {
                        System.out.println("ボス戦からは逃げられない！");
                        partition();
                    } else {
                        System.out.println(hero.getName() + "は逃げ出した！");
                        partition();
                        return true;
                    }
                    break;

                case EQUIP:
                    // 武器を変更する（ゲーム途中で武器変更ができる仕様）
                    changeWeapon(scan, hero);
                    break;

                default:
                    System.out.println("有効なコマンドを選択してください");
                    partition();
                    break;
            }
        }
    }

    // ステータス表示メソッド
    private static void displayStatus(Hero hero, Actor enemy) {
        System.out.println("📖ステータス");
        hero.status();
        enemy.status();
        partition();
    }

    // 武器変更メソッド
    private static void changeWeapon(Scanner scan, Hero hero) {
        System.out.println("どの武器を装備しますか？");
        System.out.println("[1] 鉄の剣 (攻撃力+3)");
        System.out.println("[2] 銀の剣 (攻撃力+7)");
        System.out.println("[3] 魔法の剣 (攻撃力+10)");
        System.out.print("選択：");

        try {
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    hero.equipWeapon(new Weapon("鉄の剣", 3));
                    break;
                case 2:
                    hero.equipWeapon(new Weapon("銀の剣", 7));
                    break;
                case 3:
                    hero.equipWeapon(new Weapon("魔法の剣", 10));
                    break;
                default:
                    System.out.println("無効な選択です。武器は変更されませんでした。");
            }
        } catch (InputMismatchException e) {
            scan.next(); // 不正な入力をクリア
            System.out.println("数字を入力してください。武器は変更されませんでした。");
        }
        partition();
    }

    // コマンド選択メソッド
    private static int selectCommand(Scanner scan, boolean isBossBattle) {
        System.out.println("🎮どうしますか？");
        String runOption = isBossBattle ? "[3]？？？" : "[3]逃げる";
        System.out.print("　[1]攻撃 [2]回復 " + runOption + " [4]武器変更：");

        try {
            return scan.nextInt();
        } catch (InputMismatchException e) {
            // intの値として取得できなかった場合
            scan.next(); // 取得できなかった文字列を除去
            System.out.println("有効な数字を選択してください");
            return 0; // 無効な入力
        }
    }

    // 回復処理を行うメソッド
    private static boolean handleHealing(Hero hero, Actor enemy) {
        // 勇者の回復
        hero.heal();

        // 勇者の情報を出力する
        hero.status();
        partition();

        // 敵の攻撃で勇者が倒れた場合は処理を終える
        return !loseBattle(hero, enemy);
    }

    // 「戦う」によって敵を倒したか否か
    private static boolean winBattle(Hero hero, Actor enemy) {
        // 勇者の攻撃
        hero.attack(enemy);

        // 敵の情報を出力する
        enemy.status();
        partition();

        if (enemy.getHp() == 0) {
            System.out.println(enemy.getName() + "を倒した！😄");
            partition();
            partition();
            return true;
        }

        return false;
    }

    // 敵の攻撃によって敗北したか否か
    private static boolean loseBattle(Hero hero, Actor enemy) {
        // 敵の攻撃
        enemy.attack(hero);

        // 勇者の情報を出力する
        hero.status();
        partition();

        if (hero.getHp() == 0) {
            System.out.println(hero.getName() + "はやられてしまった...😂");
            partition();
            partition();
            System.out.println("★★★ゲームオーバー★★★");
            return true;
        }
        return false;
    }

    // 仕切り表示（1秒ストップする）
    private static void partition() {
        try {
            // thread.sleepメソッドを使って1秒ストップする
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("処理中にエラーが発生しました");
            e.printStackTrace();
        }
        System.out.println("---------");
    }
}