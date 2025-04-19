/*
Lesson17 問題３:
*以下の Person3 クラス（作成済み）を、社員番号（String）とペアにして、Map に入れて管理してください。

	public class Person3 {
	 private String name;

	 public String getName() {
	  return name;
	 }

	 public void setName(String name) {
	  this.name = name;
	 }

	 public Person3(String name) {
	  this.name = name;
	 }

	 public void introduce() {
	  System.out.println("私は" + name + "と申します。");
	 }
	}

*/

// HashMapクラスを使用するためにインポート
// Mapクラスは、キーと値のペアを管理するためのインターフェースで、HashMapクラスはその実装クラス
// setクラスは、重複しない要素の集合を管理するためのインターフェースで、HashSetクラスはその実装クラス
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lesson17_3_UsePerson5 {
	public static void main(String[] args) {

		// HashMapクラスを使用して、社員番号（String）とPerson3クラスのインスタンスをペアで管理する
		// Map<String, Person3>は、キーがString型、値がPerson3型のMapを表す
		// HashMapは、キーと値のペアを管理するためのクラスで、キーは重複しない
		Map<String, Person3> employees = new HashMap<String, Person3>();

		// employees.put()メソッドを使って、社員番号（String）とPerson3用の名前をペアで登録
		// putメソッドは、指定したキーと値のペアをMapに追加する
		// すでに同じキーが存在する場合は、値が上書きされる
		employees.put("A12", new Person3("山田"));
		employees.put("A13", new Person3("木村"));
		employees.put("A14", new Person3("田中"));

		// employeesマップ内の全てのキーをSetとして取り出す
		// keySetメソッドは、Map内の全てのキーをSetとして返す
		// Setは、重複しない要素の集合を表すインターフェースで、HashSetクラスはその実装クラス
		Set<String> keys = employees.keySet();

		// 拡張for文を使って、keys内の各要素を順番に出力する
		// 拡張for文 keys内の各要素を順番に格納する変数key
		for (String key : keys) {

			// 社員ごとに登録された社員番号の出力
			System.out.println("社員番号：" + key);

			// getメソッドは、指定したキーに対応する値をMapから取得する
			// 取得した値は、Person3型のインスタンスとして扱う
			Person3 p = employees.get(key);

			//Person3クラスのintroduceメソッド
			p.introduce();
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

「 MapとHashMapの違い 」

	・Mapは、キーと値のペアを管理するためのインターフェースで、HashMapはその実装クラス
	・HashMapは、キーと値のペアを管理するためのクラスで、キーは重複しない
	・HashMapは、キーと値のペアを管理するためのクラスで、キーは重複しない
	・HashMapは、キーと値のペアを管理するためのクラスで、キーは重複しない
	・HashMapは、キーと値のペアを管理するためのクラスで、キーは重複しない

・HashMapの主なメソッド

	・put(key, value)メソッド：指定したキーと値のペアをMapに追加する
	・get(key)メソッド：指定したキーに対応する値をMapから取得する
	・remove(key)メソッド：指定したキーとその値のペアをMapから削除する
	・containsKey(key)メソッド：指定したキーがMapに存在するかどうかを確認する
	・keySet()メソッド：Map内の全てのキーをSetとして返す
	・values()メソッド：Map内の全ての値をCollectionとして返す
	・entrySet()メソッド：Map内の全てのエントリ（キーと値のペア）をSetとして返す
	・size()メソッド：Map内の要素数を取得する
	・clear()メソッド：Map内の全ての要素を削除する
	・isEmpty()メソッド：Mapが空かどうかを確認する

・Setとは
	・Setは、重複しない要素の集合を表すインターフェースで、HashSetクラスはその実装クラス
	・Setは、順序を持たないコレクションで、要素の順序は保証されない
	・Setは、重複する要素を許可しないため、同じ要素を追加しても1つだけ保持される

・Setの主なメソッド
	・add(element)メソッド：指定した要素をSetに追加する
	・remove(element)メソッド：指定した要素をSetから削除する
	・contains(element)メソッド：指定した要素がSetに存在するかどうかを確認する
	・size()メソッド：Set内の要素数を取得する
	・clear()メソッド：Set内の全ての要素を削除する
	・isEmpty()メソッド：Setが空かどうかを確認する

*/