/*
問題１:
*String型で、いくつかの「くだもの」をArrayListに入れて管理してください。入れた後、拡張for文で出力してください。

*実行結果
	*りんご
	*みかん
	*メロン
	*いちご
*/

// ArrayListクラスとListインターフェースをインポート
// Listインターフェースは、ArrayListクラスの親インターフェースであるため、両方をインポートする必要がある
import java.util.ArrayList;
import java.util.List;

public class Lesson17_1_UseArrayList3 {
	public static void main(String[] args) {

		// ArrayListクラスのインスタンスを生成し、Listインターフェース型の変数に代入
		// ArrayListクラスは、可変長の配列を実装したクラスで、要素の追加や削除が容易にできる
		// <String>は、String型の要素を持つことを示す
		List<String> list = new ArrayList<String>();

		/* 別の書き方：
		*ダイヤモンド演算子を使うことで、右辺の型を省略できる
		*List<String> list2 = new ArrayList<String>();と同じ意味
		List<String> list2 = new ArrayList<>();
		*/

		// list.add()メソッドを使って、要素を追加する
		// 追加する要素は、String型の文字列である必要がある
		list.add("りんご");
		list.add("みかん");
		list.add("メロン");
		list.add("いちご");

		// 拡張for文を使って、list内の各要素を順番に出力する
		// 拡張for文 list内の各要素を順番に格納する変数elm
		// elmはelementの略で、要素を表す変数名(何でも良い)
		for (String elm : list) {
			System.out.println(elm);
		}

		/*
		*for(初期化; 条件式; 後処理)の形でfor文を記述することもできるが、拡張for文の方が簡潔
		*listはオブジェクトなのでlenghtは使えない
		*list.size()メソッドを使って、要素数を取得する
		for (int i = 0; i < list.size(); i++) {

			*list.get(i)メソッドを使って、要素を取得する
			*引数には、取得したい要素のインデックス番号を指定する
			System.out.println(list.get(i));
		}
		*/
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