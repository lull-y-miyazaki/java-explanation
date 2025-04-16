// Step:5
// キーボードから取得した名前と年齢を使って会員情報を登録するプログラム

package kadai4;

// キーボードからの入力を受け取るために必要なScannerクラスをインポート
import java.util.Scanner;

public class UserAction2 {
	public static void main(String[] args) {

		// キーボードからの入力を受け取るためのScannerオブジェクトを作成
		Scanner scan = new Scanner(System.in);

		// Userクラスの新しいインスタンス（オブジェクト）を作成し、変数userに格納
		User user = new User();

		// ユーザーに会員登録の開始を通知
		System.out.println("会員を登録します");

		// 名前の入力を促すメッセージを表示
		System.out.print("名前：");

		// キーボードから入力された名前を読み取り、userオブジェクトのnameフィールドに設定
		user.name = scan.next();

		// 年齢の入力を促すメッセージを表示
		System.out.print("年齢：");

		// キーボードから入力された年齢を読み取り、userオブジェクトのageフィールドに設定
		user.age = scan.nextInt();

		// 区切り線を表示
		System.out.println("---");

		// 登録完了のメッセージを表示
		System.out.println("会員を登録しました");

		// userオブジェクトのshowInfoメソッドを呼び出して、登録された情報を表示
		user.showInfo();

		// Scannerクラスの終了
		scan.close();
	}
}