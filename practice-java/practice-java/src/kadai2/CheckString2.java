package kadai2;

// Scannerクラスを使用するためにインポート
import java.util.Scanner;

// 文字列を比較するためのクラスを定義
public class CheckString2 {

	// プログラムの実行開始点となるmainメソッド
	public static void main(String[] args) {

		// キーボードからの入力を受け取るためのScannerオブジェクトを作成
		Scanner scan = new Scanner(System.in);

		// ユーザーに1つ目の文字列の入力を促すメッセージを表示
		System.out.print("1つ目の文字列を入力してください：");

		// 入力された1つ目の文字列をinput1という変数に保存
		// next()メソッドは、スペースで区切られた単語を1つだけ読み取る
		// もしスペースを含む文字列を読み取りたい場合はnextLine()メソッドを使用
		String input1 = scan.next();

		// ユーザーに2つ目の文字列の入力を促すメッセージを表示
		System.out.print("2つ目の文字列を入力してください：");

		// 入力された2つ目の文字列をinput2という変数に保存
		String input2 = scan.next();

		// 2つの文字列が等しいかどうかを比較
		// equals()メソッドを使用して文字列を比較
		// equals()メソッドは、2つの文字列が同じ内容であればtrueを返す
		if (input1.equals(input2)) {

			// 文字列が等しい場合の処理
			System.out.println("2つの文字列は同じです");
		} else {

			// 文字列が異なる場合の処理
			System.out.println("2つの文字列は異なります");
		}

		// Scannerを閉じて受付終了
		scan.close();
	}
}
