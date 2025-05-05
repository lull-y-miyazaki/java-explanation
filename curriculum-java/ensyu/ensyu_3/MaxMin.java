/**
 * 【問題３】
 * 要素数10の数値配列numbers = [173.0, 168.2, 167.4, 155.3, 177.0, 170.2, 172.0, 167.3, 178.8]
 * の中の最大値と最小値を求めて表示するプログラムを作成してください。
 */

public class MaxMin {

	public static void main(String[] args) {

		// 配列をdouble型の変数numbersに格納
		double[] numbers = { 173.0, 168.2, 167.4, 155.3, 177.0, 170.2, 172.0, 167.3, 178.8 };

		// 最大値を入れるdouble型の変数Max。173.0で初期化。
		double Max = numbers[0];

		// 最小値を入れるdouble型の変数Min。173.0で初期化。
		double Min = numbers[0];

		// int型でiを１に初期化し、numbersの要素数がiより小さい間繰り返す、iを1増やしていく
		for (int i = 1; i < numbers.length; i++) {

			//最大値を求める
			if (Max < numbers[i]) {

				//Maxの数値よりnumbersが大きかった時、大きい数字がMaxに格納される。
				Max = numbers[i];

				//最小値を求める
			} else if (Min > numbers[i]) {

				//Minの数値よりnumbersが小さかった時、大きい数字がMinに格納される。
				Min = numbers[i];
			}
		}

		//最大値と最小値を表示
		System.out.println("最大値は、" + Max);
		System.out.println("最小値は、" + Min);

	}

}

// 【補足】
// 最大値・最小値の初期値はnumbers[1]でも可能だが,比較の時最初のnumbers[0]は含まれなくなる。
