package quiz;

import java.util.Scanner;

/**
 * Step1:
 * 「4, 1, 5, 3, 2」の配列arrayを作り
 * 拡張for文を利用して全て出力しなさい
 * Step2:
 * キーボードから受け取った数字と比較して
 * 配列内の値の方が大きかったら数字の後ろに★をつけなさい
 * Step3:
 * キーボードから受け取った数字と比較して
 * 配列内の値の方が大きかった個数をカウントして出力しなさい
 */

public class quiz9 {

	public static void main(String[] args) {

		// 配列：最初に用意された数字のセット（5つの整数が入っている）
		int[] array = { 4, 1, 5, 3, 2 };

		// ユーザーからの入力を受け取るための準備
		Scanner scan = new Scanner(System.in);
		System.out.print("入力："); // 入力を促すメッセージを表示
		int input = scan.nextInt(); // 入力された数値を取得して、変数inputに保存

		int count = 0; // 入力より大きい数字がいくつあったかを数える変数（最初は0）

		// 拡張for文：配列の中の値を1つずつ取り出して、変数aに入れる
		for (int a : array) {

			// もしaの値が、入力された値より大きければ
			if (input < a) {
				System.out.println(a + "★"); // 数字の後ろに「★」をつけて表示
				count++; // 大きい数が見つかったので、カウントを1つ増やす
			} else {
				// 入力以下の値はそのまま表示
				System.out.println(a);
			}
		}

		System.out.println("---"); // 区切り線を表示
		// 結果を表示：「○より大きい数字が△個見つかりました」
		System.out.println("「" + input + "」より大きい数字が" + count + "個見つかりました");

		scan.close(); // Scannerを閉じる（後片付け）
	}

}


//以下、拡張for文の文法及び説明

//for (データの型 変数名 : 配列やリスト) {
//     繰り返したい処理
//}

//使用用途：配列やリストなどの中身を1つずつ順番に取り出すときに使う
