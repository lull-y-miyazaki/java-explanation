/**
 * 【問題４】
 * 下記、解法に従って、2つの正の整数に共通な約数（公約数）のうち最大のもの（最大公約数）を求めるプログラムを作成してください。
 * 例）147 と 105 の最大公約数は 21
 * ■ 解法
 * 最大公約数を効率的に求めることができるユークリッドの互除法を利用する。
 */

import java.util.Scanner;

public class Exercise4 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 1行で2つの整数を入力させる
		System.out.println("スペースを空けて2つの数値を入力してください");

		int a = scan.nextInt();
		int b = scan.nextInt();
		int result = gcd(a, b);

		// ¥nは改行を意味するエスケープシーケンス
		System.out.println("\n"+a+"と"+b+"の最大公約数は" + result+"です");

		scan.close();
	}

	// ユークリッドの互除法による最大公約数の計算
    public static int gcd(int a, int b) {

		// while ループは、bがゼロでない限り繰り返し処理(bが0になったときに最大公約数が出る)
        while (b != 0) {

			// 次の行でbに新しい値を代入するためにtempという変数に格納する。元のbの値を一時的に保存しておくことで、後でaにbを代入できるようにしています。
            int temp = b;

			// aをbで割った余りを計算して、それを新しいbとする。ユークリッドの互除法では、「aをbで割った余り」を新しいbとして次のステップに進みます。
            b = a % b;

			// 一時保存していたbの値をaに代入します。
            a = temp;
        }

		// ループが終了した時、bは0になっており、aが最大公約数となっています。
        return a;
    }

}
