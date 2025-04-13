package kadai1;

import java.util.Scanner;

/*Step11：キーボードから国語と数学と英語のテストの点数を入力し、
最も点数の高い科目名と点数を表示するプログラムを作成しなさい。*/

public class Test3 {

	public static void main(String[] args) {
		// ユーザーからの入力を受け取るためのScannerの準備
        Scanner scan = new Scanner(System.in);

        // 国語の点数を入力してもらう
        System.out.print("国語の点数を入力してください：");
        // 最初は国語の点数を最高点として記録
        int maxScore = scan.nextInt();

        // 現時点での最高点の科目を「国語」として記録
        String maxSubject = "国語";

        // 数学の点数を入力してもらう
        System.out.print("数学の点数を入力してください：");

        // 入力された数学の点数を取得
        int input = scan.nextInt();

        // 数学の点数が国語の点数より高ければ、最高点と科目を更新
        if (input > maxScore) {
            // 数学の点数が国語より高ければ、最高点と科目を更新
            // ここでは、国語の点数を上書きしているので、注意が必要
            maxScore = input;
            maxSubject = "数学";
        }

        // 英語の点数を入力してもらう
        System.out.print("英語の点数を入力してください：");

        // 入力された英語の点数を取得
        // ここでは、国語と数学の点数を比較するために、inputを再利用
        // ただし、inputは数学の点数を上書きしているので、注意が必要
        input = scan.nextInt();

        // 英語の点数が現在の最高点より高ければ、最高点と科目を更新
        if (input > maxScore) {
            // 英語の点数が現在の最高点より高ければ、最高点と科目を更新
            maxScore = input;
            maxSubject = "英語";
        }

        // 最終的に、最高点の科目と点数を表示
        System.out.println("最高点は" + maxSubject + "で" + maxScore + "点です");

        // Scannerを閉じる
        scan.close();
	}

}

// このプログラムは、何をしているかというと
// まず国語の点数を取得して、それを最高点として記録します。
// その後、数学の点数を取得して、もしそれが国語の点数より高ければ、
// 最高点を数学の点数に更新します。
// 最後に、英語の点数を取得して、もしそれが現在の最高点より高ければ、
// 最高点を英語の点数に更新します。
// そして、最終的に最高点の科目と点数を表示します。
