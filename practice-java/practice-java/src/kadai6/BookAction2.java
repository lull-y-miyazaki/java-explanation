/*
* Step5：BookクラスのオブジェクトをItemクラスの配列に格納して利用しなさい
*/

package kadai6;

public class BookAction2 {
	public static void main(String[] args) {

		// Itemクラスの配列を生成しItemとBookのオブジェクトを複数格納する
		// []を使ってItemクラスの配列を生成する
		Item[] items = {

				// Itemクラスのオブジェクトを生成し配列に格納する
				new Item("ロボット掃除機", 50000),
				new Book("鬼滅の包丁", 450, "GO峠こよはる"),
				new Book("１ピース", 500, "尾田A一郎")
		};

		// 繰り返し処理を利用して1件ずつ商品情報を出力する
		// 拡張for文を使って配列の要素を1件ずつ取り出す
		// for(初期化文; 条件式; 更新後)
		for (Item item : items) {

			// 実際にはBookクラスのオブジェクトだが
			// Itemクラスの変数に代入して利用できる
			item.showInfo();

			System.out.println("---");
		}
	}
}
