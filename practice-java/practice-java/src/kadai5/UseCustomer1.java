/*
Step6：顧客情報（IDと名前）を3人分入力し、それを配列に格納し表示するプログラムを作成しなさい。
なお、IDを指定したくない場合、IDに-1と指定します（内部的には0として登録される）。
UseCustomer1クラス（mainメソッドを定義しているクラス）の実行結果が以下になるようにCustomerクラスを定義しなさい。
ただし、IDの重複チェックは不要とします。
 */

package kadai5;

import java.util.Scanner;

public class UseCustomer1 {

	public static void main(String[] args) {

		// 顧客オブジェクトを格納する配列を生成
		// Customer[]はCustomerクラスの配列を表す
		// 3つの要素をもつ顧客クラスの配列を生成
		Customer[] customerList = new Customer[3];

		// スキャナオブジェクトを生成
		// System.inは、標準入力を表す
		Scanner scan = new Scanner(System.in);

		// 顧客データの読み込み
		// for文を利用して、3人分の顧客情報を入力する
		// lengthは配列の要素数を取得するメソッド
		// for(初期化; 条件式; 更新処理) { }の形で、初期化、条件式、更新処理を指定する
		for (int i = 0; i < customerList.length; i++) {

			// 顧客情報の入力を促すメッセージを表示
			System.out.println((i + 1)
					+ "人目の顧客情報を入力してください。");
			System.out.print("ID：");

			// nextInt()メソッドは、整数値を入力するためのメソッド
			int id = scan.nextInt();

			System.out.print("名前：");

			// next()メソッドは、文字列を入力するためのメソッド
			// next()メソッドは、空白(スペース)を区切り文字として、文字列を入力するためのメソッド
			// nextLine()メソッドは、改行を含む文字列を入力するためのメソッド
			String name = scan.next();

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

		// 顧客データ表示
		System.out.println();
		System.out.println("=== 顧客データ一覧 ===");

		// 拡張for文で、配列の要素を1件ずつ取り出す
		// customerは配列の要素を1件ずつ取り出すための変数名
		// for (Customer型 変数 : 配列名) { }の形で、配列の要素を1件ずつ取り出す
		for (Customer customer : customerList) {

			// showDataメソッドを利用して、顧客情報を出力する
			customer.showData();
		}

		// スキャナオブジェクトをクローズ
		scan.close();
	}
}
