package quiz;

/**
 * FizzBuzz問題
 * 1～100までの数値をfor文を使って生成し
 * 3の倍数のとき「Fizz」
 * 5の倍数のとき「Buzz」
 * 3および5の倍数のとき「FizzBuzz」と出力しなさい
 */

public class quiz10 {

	public static void main(String[] args) {

		// 1から100までの数字を、1ずつ増やしながら繰り返す
		for (int i = 1; i <= 100; i++) {

			// もし、3でも5でも割り切れる（15で割り切れる）なら → FizzBuzzと表示
			if (i % 15 == 0) {
				System.out.println("FizzBuzz");

				// そうでなくて、3で割り切れるなら → Fizzと表示
			} else if (i % 3 == 0) {
				System.out.println("Fizz");

				// そうでなくて、5で割り切れるなら → Buzzと表示
			} else if (i % 5 == 0) {
				System.out.println("Buzz");

				// どれでもない場合は、そのまま数字を表示
			} else {
				System.out.println(i);
			}
		}
	}

}
