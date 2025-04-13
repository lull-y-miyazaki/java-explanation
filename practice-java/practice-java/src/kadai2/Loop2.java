//Step2：for 文を使って 1 から 10 までの整数を生成し、偶数のみを出力 しなさい

package kadai2;


public class Loop2 {

	public static void main(String[] args) {

		// for文で1〜10までの数字を1つずつ順番に処理する
		// for(初期化; 条件; 処理後の処理) {
		// iは1からスタートして、10まで1ずつ増えていく
		for (int i = 1; i <= 10; i++) {

			// iを2で割ったとき、余りが0なら偶数と判断
			// i % 2は、iを2で割った余りを計算する
			// 余りが0なら偶数、1なら奇数
			if (i % 2 == 0) {

				// 偶数ならその値を表示する
				System.out.println(i);
			}
		}
	}

}
