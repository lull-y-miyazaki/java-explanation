// Step:7
// このプログラムは顧客情報を管理するためのクラス
package kadai4;

// キーボードからの入力を受け付けるためのScannerクラスをインポート
import java.util.Scanner;

public class UseCustomer {
	public static void main(String[] args) {

		// 3人の顧客情報を格納するための配列を作成
		Customer[] customerList = new Customer[3];

		// キーボード入力を受け付けるためのScannerオブジェクトを作成
		Scanner scan = new Scanner(System.in);

		// 3人の顧客情報を順番に入力するためのループ
		// for(初期化; 条件; 更新)の形式でループを作成
		for (int i = 0; i < customerList.length; i++) {

			// 何人目の顧客情報を入力するか表示
			// 1から始まる番号を表示するためにi+1を使用
			System.out.println((i + 1) + "人目の顧客情報を入力してください。");

			// IDの入力を促すメッセージを表示
			System.out.print("ID（指定しない場合は-1と入力）：");

			// キーボードからIDを入力して受け取る
			int id = scan.nextInt();

			// 名前の入力を促すメッセージを表示
			System.out.print("名前：");

			// キーボードから名前を入力して受け取る
			String name = scan.next();

			// 新しい顧客オブジェクトを作成
			Customer customer = new Customer();

			// IDが-1の場合（IDを指定しない場合）の処理
			if (id == -1) {

				// 名前のみを登録（IDは0として自動設定）
				customer.setData(name);

			} else {

				// IDと名前の両方を登録
				customer.setData(id, name);
			}

			// 作成した顧客オブジェクトを配列に格納
			customerList[i] = customer;
		}

		// 入力された顧客情報を表示するための区切り線
		System.out.println();
		System.out.println("=== 顧客データ一覧 ===");

		// 配列に格納された全ての顧客情報を表示するためのループ
		// 拡張for文を使用して、配列の要素を順番に取り出す
		// customerList配列の各要素をcustomerという変数に代入してループ
		for (Customer customer : customerList) {

			// 各顧客の情報を表示
			customer.showData();
		}

		// Scannerオブジェクトを閉じて、リソースを解放
		scan.close();
	}
}