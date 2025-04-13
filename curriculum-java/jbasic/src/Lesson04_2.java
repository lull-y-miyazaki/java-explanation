
public class Lesson04_2 {

	// mainメソッドはプログラムの実行が始まる場所
	public static void main(String[] args) {

		// 0はintとして自動的に解釈される
		byte b = 0;

		// 10はintとして自動的に解釈される
		int i = 10;

		// b = 10;だと、byte型の範囲を超えるためエラーになる
		// なので、int型の変数iをbyte型にキャストして代入する
		b = (byte)i;

		System.out.println("b = " + b);
		System.out.println("i = " + i);

		// 1.0Fはfloatとして自動的に解釈される
		float f = 1.0F;

		// 3.14はdoubleとして自動的に解釈される
		double d = 3.14159;

		// f = 3.14;だと、float型の範囲を超えるためエラーになる
		// なので、double型の変数dをfloat型にキャストして代入する
		f = (float)d;

		System.out.println("f = " + f);
		System.out.println("d = " + d);
	}
}