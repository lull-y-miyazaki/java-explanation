/*Step9：パスワードの入力を受け付けます。while文を利用して「himitu
」が入力された場合は「ログインできました」と出力します。間違
えた場合は「再入力してください」と出力し、再入力をさせて下さい。*/

package kadai2;

// Scannerクラスをインポートして、ユーザーからの入力を受け取れるようにします
import java.util.Scanner;

// パスワードチェックを行うクラスを定義します
public class CheckPassword2 {

	// プログラムの実行開始点となるメインメソッド
	public static void main(String[] args) {

		// キーボードからの入力を受け取るためのScannerオブジェクトを作成
        // System → Javaの標準的なクラス
        // .in → 「入力（input）」の略
		Scanner scan = new Scanner(System.in);

		// ユーザーにパスワードの入力を促すメッセージを表示します
		System.out.print("パスワードを入力して下さい：");
		// ユーザーが入力した文字列を変数passwordに格納します
		String password = scan.next();

		// 入力されたパスワードが"himitu"と一致しない限りループを続ける
		// while文は、条件がtrueの間、繰り返し処理を行います
		while (!password.equals("himitu")) {

			// パスワードが間違っている場合、再入力を促すメッセージを表示
			System.out.print("再入力して下さい：");

			// 新しい入力を変数passwordに格納します
			password = scan.next();
		}

		// 正しいパスワードが入力された場合、ログイン成功のメッセージを表示
		System.out.println("ログインできました");

		// Scannerを閉じて終了
		scan.close();
	}

	//	別の実装方法（コメントアウトされています）
	//	public static void main(String[] args) {
	//

	//		Scanner scan = new Scanner(System.in);
	//		System.out.print("パスワードを入力して下さい：");

	//		ユーザーが入力した文字列を変数passwordに格納します
	//		String password = scan.next();
	//
	//		無限ループを利用した場合
	//		while(true)で無限にループを続け、条件に合致したらbreakで抜けます
	//		while (true) {

	//			入力されたパスワードが"himitu"と一致するかチェックします
	//			if (password.equals("himitu")) {

	//				パスワードが正しい場合、メッセージを表示してループを抜けます
	//				System.out.println("正解です");
	//				break;

	//			} else {
	//				パスワードが間違っている場合、再入力を促すメッセージを表示します
	//				System.out.print("再入力して下さい：");

	//				新しい入力を変数passwordに格納します
	//				password = scan.next();
	//			}
	//		}

	//		scan.close();
	//	}
}
