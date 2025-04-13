public class Lesson04_1 {
	public static void main(String[] args) {

		// intは整数型
		int salary;

		// longは整数型（intより値の範囲が大きい）
		long population;

		// byteは整数型（intより値の範囲が小さい）
		// 0～255の範囲で使うことができる
		byte dice;

		// charは文字型（1文字を格納するための型）
		// 文字はUnicodeで表現されるので、1文字を2バイトで表現する

		// Stringは文字列型（複数の文字を格納するための型）
		String bloodType;

		// floatは浮動小数点型（小数を格納するための型）
		// 1.0FのようにFを付けることでfloat型として扱うことができる
		float raceTime;

		// salary(給料)はint型で、450000円はint型の範囲内
		salary = 450000;

		// 人口は70億人なので、int型の範囲を超えている
		// int型の範囲は-2147483648～2147483647（約21億）
		// データ型はlongだがデフォルトであるintの範囲を超えているのでLかlを付けている
		population = 7000000000L;

		dice = 3;

		bloodType = "AB";

		// デフォルトであるdouble → float への暗黙的変換は許可されていないので明示的に変換する必要がある
		// 1.0FのようにFを付けることでfloat型として扱うことができる
		raceTime = 9.99F;

		System.out.println("給料：" + salary + "円");
		System.out.println("人口：" + population + "人");
		System.out.println("サイコロ：" + dice);
		System.out.println("血液型：" + bloodType + "型");
		System.out.println("100mタイム：" + raceTime + "秒");
	}
}

// 補足
// "文字列" + 変数 + "文字列" →それぞれを連結して表示させている
// String 文字列を定義するが、これはデータ型ではなく、既存クラスとなる