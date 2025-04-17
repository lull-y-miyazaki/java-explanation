/*
Step5：ItemAction2クラスを作成し、mainメソッドでItemクラスの配列itemsを作成しなさい。
itemsには3つの商品オブジェクトを格納します。
拡張for文を利用してすべての情報を出力しなさい。
*/

package kadai5;

public class ItemAction2 {
	public static void main(String[] args) {

		// 3つの要素をもつ商品クラスの配列を生成
		// Item[] はItemクラスの配列を表す

		Item[] items = {

			// items[0]にはロボット掃除機、items[1]には空気清浄機、items[2]には扇風機が格納される
				new Item("ロボット掃除機", 50000),
				new Item("空気清浄機", 20000),
				new Item("扇風機", 4000)
			};

		// 拡張for文とshowInfoメソッドを利用
		// itemは配列の要素を1件ずつ取り出すための変数名
		// for (Item型 変数 : 配列名) { }の形で、配列の要素を1件ずつ取り出す
		for (Item item : items) {

			// showInfoメソッドを利用して、商品情報を出力する
			item.showInfo();
			System.out.println("---");
		}
	}
}

// 参考：

/*別のやり方①
// 分けて代入

// まず配列を作成
Item[] items = new Item[3];

// それぞれの要素に商品オブジェクトを格納
items[0] = new Item("ロボット掃除機", 50000);
items[1] = new Item("空気清浄機", 20000);
items[2] = new Item("扇風機", 4000);
*/

/*別のやり方②
// ArrayListを使う方法

import java.util.ArrayList;

// ArrayListを利用して、可変長の配列を作成
// ArrayListは、java.utilパッケージに含まれるクラスで、可変長の配列を作成するためのクラス
ArrayList<Item> items = new ArrayList<>();

// それぞれの要素に商品オブジェクトを格納
// addメソッドを利用して、要素を追加する
items.add(new Item("ロボット掃除機", 50000));
items.add(new Item("空気清浄機", 20000));
items.add(new Item("扇風機", 4000));
 */