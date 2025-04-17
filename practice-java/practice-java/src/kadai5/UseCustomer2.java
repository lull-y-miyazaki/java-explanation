/*Step7：
Customerクラス（Step1で作成済み）を利用し、以下の出力結果になるように
UseCustomer2クラス（mainメソッドを定義しているクラス）を定義しなさい。
 */

package kadai5;

import java.util.Scanner;

public class UseCustomer2 {
	public static void main(String[] args) {

		// 顧客オブジェクトを格納する配列を生成
		// Customer[]はCustomerクラスの配列を表す
		// 3つの要素をもつ顧客クラスの配列を生成
		Customer[] customerList = new Customer[3];

		// スキャナオブジェクトを生成
		// System.inは、標準入力を表す
		Scanner scan = new Scanner(System.in);

		// for文を利用して、3人分の顧客情報を入力する
		// lengthは配列の要素数を取得するメソッド
		// for(初期化; 条件式; 更新処理) { }の形で、初期化、条件式、更新処理を指定する
		for (int i = 0; i < customerList.length; i++) {

			System.out.println((i + 1) + "人目の顧客情報を入力してください。");
			System.out.print("ID：");

			// nextInt()メソッドは、整数値を入力するためのメソッド
			int id = scan.nextInt();

			System.out.print("名前：");

			// next()メソッドは、空白(スペース)を区切り文字として、文字列を入力するためのメソッド
			String name = scan.next();

			// 顧客オブジェクトを生成
			// まず、Customer型の変数customerを宣言
			Customer customer;

			// 顧客オブジェクトを生成
			// まず、Customer型の変数customerを宣言
			Customer customer;
			if (id == -1) {

				// IDが-1の場合、IDは0として登録するコンストラクタを呼び出す
				customer = new Customer(name);

			} else {

				// IDが-1でなければ、CustomerクラスのIDと名前を引数に取るコンストラクタを呼び出す
				customer = new Customer(id, name);
			}

			// customerList[i] = customer;は、配列のi番目の要素に顧客オブジェクトを格納する
			// 条件分岐で生成した顧客オブジェクトを格納する
			customerList[i] = customer;
		}

		// 顧客データ操作
		// while(条件式) { }の形で、条件式がtrueの間、処理を繰り返す
		while (true) {

			System.out.println();

			// 操作を選択
			// selectOperationメソッドは、操作を選択するためのメソッド
			// Scannerクラスのインスタンスを引数に取る
			int operation = selectOperation(scan);

			// 操作を選択
			// 1:一覧表示、2:変更、9:終了
			if (operation == 1) {

				// 顧客データ表示
				// showCustomerメソッドは、顧客データを表示するためのメソッド
				// Customerクラスの配列を引数に取る
				showCustomer(customerList);

			} else if (operation == 2) {

				// 顧客データ更新
				// updateCustomerメソッドは、顧客データを更新するためのメソッド
				// ScannerクラスのインスタンスとCustomerクラスの配列を引数に取る
				updateCustomer(scan, customerList);
			} else {

				// 終了
				// break文は、ループを終了するための文
				break;
			}
		}

		// スキャナオブジェクトをクローズ
		scan.close();
	}

	// selectOperationメソッドは、操作を選択するためのメソッド
	// Scannerクラスのインスタンスを引数に取る
	// int型の戻り値を持つ
	private static int selectOperation(Scanner scan) {

		// 操作を選択
		// System.out.printは、改行せずに出力するためのメソッド
		System.out.print("操作（1:一覧表示　2:変更　9:終了）を選択してください：");

		// nextInt()メソッドは、整数値を入力するためのメソッド
		int operation = scan.nextInt();

		// 入力された値を返す
		// return文は、メソッドの戻り値を返すための文
		return operation;
	}

	// 顧客データ一覧を表示するメソッド
	// voidなので、戻り値はない
	// Customerクラスの配列を引数に取る
	private static void showCustomer(Customer[] customerList) {

		System.out.println("=== 顧客データ一覧 ===");

		// 拡張for文で、配列の要素を1件ずつ取り出す
		// customerは配列の要素を1件ずつ取り出すための変数名
		// for (Customer型 変数 : 配列名) { }の形で、配列の要素を1件ずつ取り出す
		for (Customer customer : customerList) {

			// showDataメソッドは、顧客データを表示するためのメソッド
			customer.showData();
		}
	}

	// 顧客データを更新するメソッド
	// voidなので、戻り値はない
	// ScannerクラスのインスタンスとCustomerクラスの配列を引数に取る
	private static void updateCustomer(Scanner scan, Customer[] customerList) {

		System.out.print("更新するID：");

		// nextInt()メソッドは、整数値を入力するためのメソッド
		int id = scan.nextInt();

		// 指定したIDの顧客データを取得
		// nullを代入しておくことで、IDが存在しない場合にnullを返す
		Customer targetCustomer = null;

		// for文を利用して、指定したIDの顧客データを取得する
		// lengthは配列の要素数を取得するメソッド
		// for(初期化; 条件式; 更新処理) { }の形で、初期化、条件式、更新処理を指定する
		for (Customer customer : customerList) {

			// customer.getId()は、顧客データのIDを取得するためのメソッド
			// customer.getId() == idは、顧客データのIDと指定したIDが一致するかどうかを判定する
			if (customer.getId() == id) {

				// 一致した場合、targetCustomerに顧客データを代入する
				targetCustomer = customer;

				// ループを終了する
				break;
			}
		}

		// targetCustomerがnullの場合、IDが存在しない
		if (targetCustomer == null) {

			// 顧客データが存在しない
			System.out.println("指定したIDは存在しません。");

		// 顧客データがある場合
		} else {

			// 顧客データの更新
			System.out.print("新しいID：");

			// nextInt()メソッドは、整数値を入力するためのメソッド
			id = scan.nextInt();

			System.out.print("新しい名前：");

			// next()メソッドは、空白(スペース)を区切り文字として、文字列を入力するためのメソッド
			String name = scan.next();

			// targetCustomer.setId(id)は、顧客データのIDを更新するためのメソッド
			targetCustomer.setId(id);

			// targetCustomer.setName(name)は、顧客データの名前を更新するためのメソッド
			targetCustomer.setName(name);
		}
	}
}