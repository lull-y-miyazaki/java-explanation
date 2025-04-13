package kadai1;

import java.util.Scanner;

/*Step10：キーボードから国語と数学と英語のテストの点数を入力し、
国語が 80 点以上かつ数学が 75 点以上かつ英語が 70 点以上なら「合格です」と表示し、
それ以外は「不合格です」と表示するプログラムを作成しなさい。
*/

public class Test2 {

	public static void main(String[] args) {
        // ユーザーの入力を受け取る準備（Scannerの作成）
        // System → Javaの標準的なクラス
        // .in → 「入力（input）」の略
        Scanner scan = new Scanner(System.in);

        // 国語の点数を入力してもらう
        System.out.print("国語の点数を入力してください：");
        // nextInt()メソッドは、Javaでユーザーから整数（int）を入力してもらうときに使うメソッド
        // ここでは、国語の点数を入力してもらい、その値をjpnScoreに保存
        int jpnScore = scan.nextInt();

        // 数学の点数を入力してもらう
        System.out.print("数学の点数を入力してください：");
        int mathScore = scan.nextInt(); // 入力された点数をmathScoreに保存

        // 英語の点数を入力してもらう
        System.out.print("英語の点数を入力してください：");
        int engScore = scan.nextInt(); // 入力された点数をengScoreに保存

        // 合否判定の条件：
        // 国語が80点以上 AND 数学が75点以上 AND 英語が70点以上 なら「合格」
        if (jpnScore >= 80 && mathScore >= 75 && engScore >= 70) {
            System.out.println("合格です"); // 条件をすべて満たしたら合格
        } else {
            System.out.println("不合格です"); // どれか一つでも足りなければ不合格
        }

        // Scannerを閉じて終了
        scan.close();
	}

}

// 参考：
// >=は「以上」を意味する演算子
// &&は「かつ」を意味する論理演算子
// 実行順は>=→&&→ifの順

// つまり、
// 1. jpnScore >= 80 が true なら次に mathScore >= 75 をチェック
// 2. mathScore >= 75 が true なら次に engScore >= 70 をチェック
// 3. engScore >= 70 が true なら if の中の処理を実行
// 4. どれか一つでも false なら if の中の処理は実行されず、else の処理が実行される
