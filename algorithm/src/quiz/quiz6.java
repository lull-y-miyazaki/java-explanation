package quiz;

/**
 * Step1:
 * ・for文を使って1～10までの数字を横に並べなさい
 * ・数字の後ろには半角スペースを入れます
 * Step2:
 * ・for文の中でfor文を使ってStep1の行を10回繰り返しなさい
 * ・改行が必要になります
 */

public class quiz6 {

	public static void main(String[] args) {

		//step1
		//		
		//		for (int i = 1; i <= 10; i++) {
		//			System.out.print(i + " ");
		//		}
		//			～ここの解説はquiz4と同じ～

		//step2
		// 外側のfor文：10回くり返す（1〜10まで）
		for (int j = 1; j <= 10; j++) {

			// 内側のfor文：1〜10までの数字を横に並べて表示する
			for (int i = 1; i <= 10; i++) {
				System.out.print(i + " "); // 改行せずに数字とスペースを表示
			}

			System.out.println(); // 1行分の表示が終わったら改行する
		}

	}

}
