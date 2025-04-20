/**
 * Step3：キーボードから取得した商品を３回リストに追加し、拡張for文を利用して出力しなさい
 * キーボードからの商品を３回リストに追加するときにもfor文を利用します
 */

package kadai7;

// ArrayListクラスとListインターフェースをインポート
// Listインターフェースは、ArrayListクラスの親インターフェースであるため、両方をインポートする必要がある
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringCart2 {
	public static void main(String[] args) {

		// キーボードからの入力を受け付けるために、Scannerクラスを利用
		Scanner scan = new Scanner(System.in);

		// ArrayListクラスのインスタンスを生成し、Listインターフェース型の変数に代入
		// ArrayListクラスは、可変長の配列を実装したクラスで、要素の追加や削除が容易にできる
		// <String>は、String型の要素を持つことを示す
		List<String> list = new ArrayList<>();

		// キーボードからリストに追加するを3回繰り返す
		// for(初期値; 条件式; 後処理)の形でfor文を記述する
		for (int i = 0; i < 3; i++) {

			System.out.print("商品を追加してください：");

			// list.add()メソッドを使って、要素を追加する
			// next()メソッドを利用して、キーボードからの入力を受け付ける
			// next()メソッドは、スペースまでの文字列を取得する
			list.add(scan.next());
		}

		// 拡張for文を利用して全商品を出力する
		// for(型 変数名 : 配列名)の形でfor文を記述する
		// listの要素を一つずつ取り出して、itemに代入する
		for (String item : list) {

			System.out.println(item);
		}

		// close()メソッドを利用して、Scannerクラスのオブジェクトを閉じる
		scan.close();
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