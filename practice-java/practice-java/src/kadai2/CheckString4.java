package kadai2;

// Scannerクラスを使用するためにインポート
import java.util.Scanner;

// 文字列をチェックするためのクラスを定義
public class CheckString4 {

	// プログラムの実行開始点となるメインメソッド
	public static void main(String[] args) {

		// キーボードからの入力を受け付けるScannerオブジェクトを作成
		Scanner scan = new Scanner(System.in);

		// ユーザーに文字列の個数を入力するよう促すメッセージを表示
		System.out.print("文字列の個数を入力してください：");

		// 入力された数値を整数として読み取り、max変数に格納 → つまり、何個の文字列を入力するか決める
		// nextInt()メソッドは整数を読み取るために使用
		int max = scan.nextInt();

		// 入力された文字列を格納するための配列を作成（サイズは入力された数値分）
		// []は配列を作成するための構文
		// new String[max]は、maxのサイズを持つString型の配列を作成
		String[] strings = new String[max];

		// 最長の文字列を格納するための変数を初期化（空文字列で開始）
		String result = "";

		// 入力された個数分だけ繰り返し処理を行う
		// for(初期化; 条件; ループ後の処理)
		// 0からmax-1までの範囲で繰り返す（countは0から始まるので、max回繰り返すことになる）
		// indexは0から始まるので、countは0からスタートしてmax-1までの範囲でループ
		// 例えば、maxが3の場合、countは0,1,2の3回ループする
		for (int count = 0; count < max; count++) {

			// 何番目の文字列を入力するか表示（count+1で1から始まる番号を表示）
			System.out.print((count + 1) + "つ目の文字列を入力してください：");

			// 入力された文字列を配列に格納
			// [count]は配列のインデックスを指定して、strings配列の特定の位置に値を格納
			// 例えば、countが0の場合、strings[0]に最初の文字列が格納される
			strings[count] = scan.next();
		}

		// 配列内の各文字列に対して処理を行う（拡張for文）
		// for(要素の型 変数名 : 配列名) の形でループを作成
		for (String string : strings) {

			// 現在の文字列の長さが、これまでの最長文字列より長い場合
			if (string.length() > result.length()) {

				// 最長文字列を更新
				result = string;
			}
		}

		// 最も長い文字列を結果として表示
		System.out.println("最も長い文字列は「" + result + "」です");

		// Scannerを閉じて受付終了
		scan.close();
	}
}
