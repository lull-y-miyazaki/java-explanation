// このプログラムは文字列の長さを計算するプログラム
package kadai2;

// キーボードからの入力を受け取るために必要なScannerクラスをインポート
import java.util.Scanner;

// CheckString1という名前のクラスを定義
public class CheckString1 {

	// プログラムの実行開始点となるmainメソッド
	public static void main(String[] args) {

		// キーボードからの入力を受け取るためのScannerオブジェクトを作成
        // System → Javaの標準的なクラス
        // .in → 「入力（input）」の略
		Scanner scan = new Scanner(System.in);

		// ユーザーに文字列の入力を促すメッセージを表示
		System.out.print("文字列を入力してください：");

		// ユーザーが入力した文字列をinputという変数に保存
		// next()メソッドは、スペースで区切られた単語を1つだけ読み取る
		// もしスペースを含む文字列を読み取りたい場合はnextLine()メソッドを使用
		String input = scan.next();

		// 入力された文字列の長さを計算して表示
		// length()メソッドは文字列の文字数を返す
		System.out.println("文字列の長さは" + input.length() + "です");

		// Scannerを閉じて受付終了
		scan.close();
	}
}
