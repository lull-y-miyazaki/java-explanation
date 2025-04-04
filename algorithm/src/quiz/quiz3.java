package quiz;

import java.util.Scanner;

/**
 * 120円のジュースを購入するプログラムをつくります
 * 変数monyに代入された整数によって出力するメッセージを変えなさい
 * ・120未満の場合「お金が足りません」と出力
 * ・120円以上の場合「購入できました。おつりは○○円です！」と出力
 */


public class quiz3 {

	public static void main(String[] args) {
		
		// ユーザーからの入力を受け取るためにScannerを使う
		Scanner scan = new Scanner(System.in);

		// ユーザーにお金を入れるように促すメッセージを表示する
		System.out.print("お金を入れてください：");

		// ユーザーが入力した金額を整数型（int）で受け取る
		int money = scan.nextInt();

		// 入力された金額が120円以上かどうかをチェック
		if (money >= 120) {
		    // 金額が120円以上の場合、「購入できました」と表示し、おつりの金額も計算して表示する
		    // 例えば、150円を入れた場合、150 - 120 = 30円のおつり
			System.out.println("購入できました。おつりは" + (money - 120) + "円です！");
		} else {  // もし金額が120円未満の場合
		    // お金が足りないことを伝えるメッセージを表示する
			System.out.println("お金が足りません");
		}

		// 入力を受け取った後、Scannerを閉じる
		//これをしないと、プログラムが終了してもメモリに無駄な容量が残ってしまうことがある
		scan.close();
	}

}
