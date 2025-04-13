package kadai1;

import java.util.Scanner;

//Step3：キーボードから年齢を取得し、
//数値の範囲が正しいかを判定しなさい

public class CheckInteger3 {

	public static void main(String[] args) {
		// ユーザーからの入力を受け取るための準備
        Scanner scan = new Scanner(System.in);

        // 年齢の入力を促すメッセージを表示
        // System.out.print() なので改行なし
        System.out.print("年齢を入力して下さい：");

        // 入力された数値（年齢）を取得し、変数 age に保存
        // scan.nextInt() は、Javaでユーザーから整数（int）を入力してもらうときに使うメソッド
        int age = scan.nextInt();

        // 入力された年齢が「0以上130以下」なら正しい年齢と判断
        // &&は「かつ」を意味する論理演算子
        // つまり、ageが0以上かつageが130以下のときにtrueになる
        if (0 <= age && age <= 130) {
            System.out.println("正しい年齢です");
        } else {
            // それ以外の値（マイナスや131以上など）は不正と判断
            System.out.println("0～130で入力してください");
        }

        // Scannerを閉じる（メモリの無駄を防ぐ）
        scan.close();
	}

}
