package kadai1;

import java.util.Scanner;

//Step1：キーボードから数字を取得し、
//「7」の場合は「大当たり！」
//と出力しなさい

public class CheckInteger1 {

	public static void main(String[] args) {
		// ユーザーの入力を受け取る準備（Scannerの作成）
        // System → Javaの標準的なクラス
        // .in → 「入力（input）」の略
        Scanner scan = new Scanner(System.in);

        // 入力を促すメッセージを表示
        System.out.print("数字を入力して下さい：");

        // 入力された整数を取得して、変数 input に保存
        // scan.nextInt() は、Javaでユーザーから整数（int）を入力してもらうときに使うメソッド
        int input = scan.nextInt();

        // 入力された数字が7と「ぴったり一致」しているかをチェック
        if (input == 7) {
            System.out.println("大当たり！"); // もし7なら「大当たり！」と表示
        } else {
            System.out.println("ハズレ"); // それ以外の数字なら「ハズレ」と表示
        }

        // Scannerを閉じる（メモリの無駄を防ぐ）
        scan.close();
	}

    // 参考：
    // Scannerクラスのよく使う入力メソッド一覧
    // 単語だけ欲しい → next()
    // 文や文章（スペース含む）を取りたい → nextLine()
    // 数字（整数）を取りたい → nextInt()
    // 小数（3.14など）を取りたい → nextDouble()
    // yes/no的な判断 → nextBoolean()

}
