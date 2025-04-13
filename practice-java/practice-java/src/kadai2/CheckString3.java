package kadai2;

// Scannerクラスをインポートして、キーボードからの入力を受け付けることができるように
import java.util.Scanner;

// CheckString3という名前のクラスを定義
public class CheckString3 {

	// プログラムの実行開始点となるmainメソッドを定義します
	public static void main(String[] args) {

		// キーボードからの入力を受け付けるためのScannerオブジェクトを作成
		Scanner scan = new Scanner(System.in);

		// ユーザーに繰り返し回数の入力を促すメッセージを表示
		System.out.print("繰り返す回数を入力してください：");

		// 入力された整数値をmaxという変数に格納(maxを決める)
		int max = scan.nextInt();

		// 連結した文字列を格納するための、空の文字列変数resultを初期化しておく
		String result = "";

		// 0からmax-1まで繰り返すforループを開始
		// for(初期化; 条件; ループ後の処理)
		for (int count = 0; count < max; count++) {

			// 現在の繰り返し回数（1から始まる）を表示し、文字列の入力を促す
			// countは0から始まるので、+1して1から始まるようにする
			System.out.print((count + 1) + "つ目の文字列を入力してください：");

			// 入力された文字列をinputという変数に格納
			// next()メソッドは、スペースで区切られた単語を1つだけ読み取る
			String input = scan.next();

			// 既存のresultに新しいinputを連結して、resultを更新
			// +=演算子は、文字列を連結するために使用
			// 例えば、resultが"abc"でinputが"def"の場合、resultは"abcdef"になる
			result += input;

			// 現在の連結結果を画面に表示
			System.out.println(result);
		}

		scan.close();
	}
}
