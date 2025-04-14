//Step3：
//「1,7,2,7,3」の要素をもつ整数の配列 numbers を生成し、拡張 for 文を利用してすべての値を出力しなさい
// このプログラムは kadai2 というパッケージに属しています

package kadai2;


// IntegerArray1 という名前のクラスを定義
public class IntegerArray1 {

	// プログラムの実行開始点となる main メソッド
	public static void main(String[] args) {

		// 整数型（int）の配列 numbers を宣言し、初期値として 1, 7, 2, 7, 3 を格納
		// int[] は整数型の配列を表し、{} 内に初期値を指定
		int[] numbers = { 1, 7, 2, 7, 3 };

		// 配列の要素を全て出力するためのループ
		// 拡張for文を使用して、配列 numbers の各要素を順番に取り出す
		// num は一時的な変数で、配列の各要素の値が順番に格納
		for (int num : numbers) {

			// System.out.print() で数値を出力し、\n で改行
			// \n は改行を意味する正規表現
			// これにより、各数値が1行ずつ表示されます
			System.out.print(num + "\n");
			// Syestem.out.println(num); でもOK
		}
	}
}

// 参考：拡張for文の文法

// 左の部分は、右の配列やリストの要素を順番に取り出すための構文
// だからnumの様な単数系の変数名で、右のたくさん入ったデータの集まりから一つずつ取り出している
// for (データの型 変数名 : 配列やリスト) {
//    繰り返したい処理
// }
