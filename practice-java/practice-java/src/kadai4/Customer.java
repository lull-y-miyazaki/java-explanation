// Step:7
// 顧客情報を管理するためのクラスを定義

package kadai4;

public class Customer {

	// 顧客のID番号を格納する変数（整数型）
	int id;

	// 顧客の名前を格納する変数（文字列型）
	String name;

	// 顧客の名前のみを設定するメソッド
	// 引数 n: 設定する顧客の名前
	void setData(String n) {

		// 引数で受け取った名前を顧客の名前フィールドに設定
		name = n;
	}

	// 顧客のIDと名前の両方を設定するメソッド
	// 引数 i: 設定する顧客のID番号
	// 引数 n: 設定する顧客の名前
	void setData(int i, String n) {

		// 引数で受け取ったID番号を顧客のIDフィールドに設定
		id = i;

		// 引数で受け取った名前を顧客の名前フィールドに設定
		name = n;
	}

	// 顧客の情報（IDと名前）を画面に表示するメソッド
	void showData() {

		// IDと名前を「ID：名前」の形式で画面に出力
		System.out.println(id + "：" + name);
	}
}
