// int型の配列を使って、うるう年を判定するプログラム
// うるう年の場合はtrue、うるう年でない場合はfalseを返す
// うるう年は、4で割り切れる年、ただし100で割り切れる年はうるう年ではない

// Scannerクラスをインポート
import java.util.Scanner;

public class Lesson09_4 {
	public static void main(String[] args) {

		// キーボード入力の受付
		// Scannerクラスのインスタンスを生成
		Scanner scan = new Scanner(System.in);
		System.out.print("年を入力してください：");

		// キーボードから年を取得
		// scan.nextInt()は、キーボードから整数値を取得するメソッド
		int year = scan.nextInt();

		// もしisLeapメソッドの戻り値がtrueなら、うるう年であると判定する
		// isLeapメソッドの呼び出し
		// yearを引数に渡す
		if(isLeap(year)) {

			// trueの場合
			System.out.println(year + "年はうるう年です");

		// もしisLeapメソッドの戻り値がfalseなら、うるう年ではないと判定する
		} else {

			// falseの場合
			System.out.println(year + "年はうるう年ではありません");
		}

		// Scannerクラスを閉じる
		scan.close();
	}

	// うるう年か判定するisLeapメソッド
	// 引数はint型のyearを受け取る
	static boolean isLeap(int year) {

		//「400で割り切れる」と「100で割り切れず、4で割り切れる」
		// 上記のどれかが当てはまればtrue、どれも当てはまらなければfalse
		return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
	}
}

//補足
//booleanとは、trueかfalseのどちらかを返すデータ型のこと

// ((year % 4 == 0) はyearを4で割った余りが0であるかどうかを判定する式
// == は等しいかどうかを判定する演算子
// && は論理積（AND）
// (year % 100 != 0)) はyearを100で割った余りが0でないかどうかを判定する式
// /!= は等しくないかどうかを判定する演算子
// || は論理和（OR）
// (year % 400 == 0) はyearを400で割った余りが0であるかどうかを判定する式
// これらの条件を組み合わせて、うるう年かどうかを判定する