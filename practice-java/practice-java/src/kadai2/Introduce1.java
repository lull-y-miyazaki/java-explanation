/*Step4：
「ダンス、映画、バイク」の要素をもつ文字列の配列hobbyListを生成し、
拡張for文を利用してすべて出力しなさい*/

package kadai2;

// Introduce1 という名前のクラスを定義
public class Introduce1 {

	// mainメソッドはプログラムの実行開始地点
	public static void main(String[] args) {

		// 趣味のリストを文字列の配列として定義
		// 配列は複数の値をまとめて管理できるデータ構造
		// String[]は文字列型の配列を表し、{}内に初期値を指定
		String[] hobbyList = { "ダンス", "映画", "バイク" };

		// 趣味のリストの開始を表示します
		System.out.println("私の趣味は、");

		// 拡張for文を使用して配列の各要素を順番に取り出す
		// String hobby : hobbyList は「hobbyListの各要素をhobbyという変数に代入する」という意味
		for (String hobby : hobbyList) {

			// 各趣味の前に「・」を付けて表示
			System.out.println("・" + hobby);
		}

		// 趣味のリストの終了を表示
		System.out.println("です");
	}
}
