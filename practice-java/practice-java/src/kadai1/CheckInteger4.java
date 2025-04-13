package kadai1;

import java.util.Scanner;

//tep4：キーボードから整数を取得し、
//「正/負」「偶数/奇数」で判定した結果を出力しなさい

public class CheckInteger4 {

	public static void main(String[] args) {
		// ユーザーからの入力を受け取るための準備
        Scanner scan = new Scanner(System.in);

        // 数字の入力を促すメッセージを表示
        System.out.print("数字を入力して下さい：");

        // 入力された整数を取得し、inputに保存
        int input = scan.nextInt();

        // 結果のメッセージを作るための変数（最初に「〇〇は」と入れておく）
        String message = input + "は";

        // 数が0以上なら「正の」、それ以外（負の数）なら「負の」と追加する
        if (input >= 0) {
            // +=は足して代入する演算子
            // つまり、messageに「正の」を追加して代入
１            message += "正の";
        } else {
            message += "負の";
        }

        // 偶数か奇数かを判定し、メッセージに追加
        // %は「割り算の余り」を求める演算子
        // 例えば、5 % 2 は1（余り）で、6 % 2 は0（余り）
        // つまり、2で割った余りが0なら偶数、1なら奇数
        // ここでは、inputを2で割った余りが0なら偶数、そうでなければ奇数
        if (input % 2 == 0) {
            message += "偶数です";
        } else {
            message += "奇数です";
        }

        // 最終的なメッセージを画面に表示
        System.out.println(message);

        // Scannerを閉じる（メモリの無駄を防ぐ）
        scan.close();
	}

}
