/**
 * Step4：Itemクラスを作成し、ItemActionクラスのmainメソッドから利用しなさい。
 * Itemクラスのオブジェクトを保持できるリストに商品を３つ追加し、拡張for文を利用して出力します。
 */

package kadai7;

// ArrayListクラスとListインターフェースをインポート
// Listインターフェースは、ArrayListクラスの親インターフェースであるため、両方をインポートする必要がある
import java.util.ArrayList;
import java.util.List;

public class ItemAction1 {
	public static void main(String[] args) {

		// ArrayListクラスのインスタンスを生成し、Listインターフェース型の変数に代入
		// ArrayListクラスは、可変長の配列を実装したクラスで、要素の追加や削除が容易にできる
		// <String>は、String型の要素を持つことを示す
		List<Item> itemList = new ArrayList<>();

		// list.add()メソッドを使って、要素を追加する
		itemList.add(new Item("ロボット掃除機", 50000));
		itemList.add(new Item("ドラム式洗濯機", 200000));
		itemList.add(new Item("液晶テレビ", 100000));

		// for(型 変数名 : 配列名)の形でfor文を記述する
		// itemListの要素を一つずつ取り出して、itemに代入する
		for (Item item : itemList) {

			// showInfo()メソッドを呼び出して、商品名と価格を出力する
			item.showInfo();
			System.out.println("---");
		}
	}
}

/* 補足：

「 配列とArrayListの違い 」

・配列は、固定長のデータ構造で、要素数を変更できない
	・ArrayListは、可変長のデータ構造で、要素数を変更できる

	・要素（int[] や String[]）数の取得方法→length
	・要素の取得方法→配列名[インデックス番号]で取得できる

	・配列は、要素数を指定して生成する必要がある
	例）int[] arr = new int[5]; // 要素数5のint型配列を生成

・ArrayListは、要素数を指定せずに生成できる
	例）List<String> list = new ArrayList<String>(); // 要素数を指定せずに生成

	・要素数の取得方法→size()メソッドを使う
	・要素の取得方法→get(インデックス番号)メソッドを使う
	・要素の追加方法→add(要素)メソッドを使う
	・要素の削除方法→remove(インデックス番号)メソッドを使う
	・要素の更新方法→set(インデックス番号, 新しい要素)メソッドを使う
	・要素の検索方法→contains(要素)メソッドを使う
	・要素のクリア方法→clear()メソッドを使う
	(removeとの違いは、removeは指定した要素を削除するが、clearは全ての要素を削除する)
	・要素のソート方法→Collections.sort(list)メソッドを使う
	・要素の逆順ソート方法→Collections.reverse(list)メソッドを使う

 */