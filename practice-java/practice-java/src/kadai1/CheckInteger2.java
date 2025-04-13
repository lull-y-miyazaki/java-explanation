package kadai1;

import java.util.Scanner;

//Step2：キーボードから2つの数字を取得し
//比較した結果を出力しなさい

public class CheckInteger2 {

	public static void main(String[] args) {
		// ユーザーからの入力を受け取るための準備
        // System → Javaの標準的なクラス
        // .in → 「入力（input）」の略
        Scanner scan = new Scanner(System.in);

        System.out.print("xの値を入力してください："); // xの入力を促す

        // scan.nextInt() は、Javaでユーザーから整数（int）を入力してもらうときに使うメソッド
        int x = scan.nextInt(); // 入力されたxの値を取得

        System.out.print("yの値を入力してください："); // yの入力を促す
        int y = scan.nextInt(); // 入力されたyの値を取得

        // xがyより大きい場合
        if (x > y) {
            System.out.println("xはyより大きいです");

        // xがyより小さい場合
        } else if (x < y) {
            System.out.println("xはyより小さいです");

        // どちらでもない場合（つまり等しいとき）
        } else {
            System.out.println("xとyは等しいです");
        }

        // 入力用のScannerを閉じる（メモリの無駄を防ぐ）
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
