package exam;

/**
 * int型の配列arrayには「1, 5, 4, 3, 2」の5つの整数が格納されています。
 * 拡張for文を利用して配列の中から奇数の値のみを取り出して出力しなさい。
 */
public class Exam2 {
	public static void main(String[] args) {

		// 対象の配列を生成する
		int[] array = { 1, 5, 4, 3, 2 };

		// 拡張for文とif文を利用して奇数の値だけを出力する
		for (int num : array) {
			// 奇数のときだけ出力する
			// % は剰余演算子で、左側の数値を右側の数値で割った余りを計算
			// 数値を2で割った余りが1なら奇数、0なら偶数
			if (num % 2 == 1) {
				System.out.println(num);
			}
		}
	}
}