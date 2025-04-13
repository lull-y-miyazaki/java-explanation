// Step8：
// パスワードの入力を受け付けます。
// for 文を利用し、３ 回以内 に「himitu」が入力された場合は「ログインできました」と出力します。
// 間違えた場合は「不正解です」と出力しなさい。

package kadai2;

// キーボードからの入力を受け付けるために必要なScannerクラスをインポート
import java.util.Scanner;


// パスワードチェックを行うクラスの定義
public class CheckPassword1 {

	// プログラムの実行開始点となるメインメソッド
	public static void main(String[] args) {

		// ユーザーの入力を受け取る準備（Scannerの作成）
        // System → Javaの標準的なクラス
        // .in → 「入力（input）」の略
		Scanner scan = new Scanner(System.in);

		// 3回までパスワード入力を試行できるforループ
		// iは0から始まり、3未満（0,1,2の3回）まで繰り返す
		// for(初期化; 条件; ループ後の処理) の形でループを作成
		for (int i = 0; i < 3; i++) {

			// ユーザーにパスワードの入力を促すメッセージを表示
			System.out.print("パスワードを入力して下さい：");

			// ユーザーが入力したパスワードを変数passwordに格納
			String password = scan.next();

			// 入力されたパスワードが"himitu"と一致するかチェック
			// eqalsメソッドは、文字列が同じかどうかを比較するために使う
			// 文字列の比較には==ではなく、equalsメソッドを使うことが重要
			if (password.equals("himitu")) {

				// パスワードが正しい場合、ログイン成功のメッセージを表示
				System.out.println("ログインできました");
				// パスワードが正しいのでループを抜ける
				break;
			} else {
				// パスワードが間違っている場合、エラーメッセージを表示
				System.out.println("不正解です");
			}
		}

		// Scannerオブジェクトを閉じて、リソースを解放
		scan.close();
	}
}
