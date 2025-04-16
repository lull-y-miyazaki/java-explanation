// Step:6
// このファイルは「UseConvert」というクラスを含むJavaプログラム
// このプログラムは、ユーザーから入力を受け取り、その入力を反転させる機能を持っている

package kadai4;

// Scannerクラスをインポート
import java.util.Scanner;

// publicは、このクラスが他のクラスからもアクセスできる
public class UseConvert {
	public static void main(String[] args) {

		// ユーザーからの入力を受け取るためのScannerオブジェクトを作成
		// System.inは、標準入力（キーボード）
		Scanner scan = new Scanner(System.in);

		// ユーザーに整数の入力を促すメッセージを表示
		System.out.print("整数を入力して下さい：");

		// ユーザーが入力した整数を読み取り、input1という変数に格納
		int input1 = scan.nextInt();

		// Convertクラスのreverseメソッドを呼び出して、入力された整数を反転
		Convert.reverse(input1);

		// ユーザーに浮動小数点数の入力を促すメッセージを表示
		System.out.print("浮動小数点数を入力して下さい：");

		// ユーザーが入力した浮動小数点数を読み取り、input2という変数に格納
		double input2 = scan.nextDouble();

		// Convertクラスのreverseメソッドを呼び出して、入力された浮動小数点数を反転
		Convert.reverse(input2);

		// ユーザーに文字列の入力を促すメッセージを表示
		System.out.print("文字列を入力して下さい：");

		// ユーザーが入力した文字列を読み取り、input3という変数に格納
		String input3 = scan.next();


		// Convertクラスのreverseメソッドを呼び出して、入力された文字列を反転
		Convert.reverse(input3);

		// Scannerを終了して、リソースを解放
		scan.close();
	}
}

// 補足：
// public static void main(String[] args)
// プログラムの実行開始点となるmainメソッドを定義
// staticは、このメソッドがクラスに属していることを意味している
// voidは、このメソッドが何も返さないことを意味している
// String[] argsは、コマンドライン引数を受け取るためのパラメータ