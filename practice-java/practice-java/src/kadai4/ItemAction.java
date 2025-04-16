// Step:2
// 作成したItemクラスを使って、商品情報を表示するプログラムを作成
package kadai4;

public class ItemAction {
	public static void main(String[] args) {

		// Itemクラスのオブジェクトを生成し変数item1に代入
		// newキーワードを使って、Itemクラスの新しいインスタンス（オブジェクト）を作成
		Item item1 = new Item();

		// item1のフィールドに商品名「絵本」、価格「1000」を設定
		// オブジェクトのnameフィールドに「絵本」という文字列を設定
		item1.name = "絵本";

		// オブジェクトのpriceフィールドに1000という数値を設定
		item1.price = 1000;

		// item1を利用して商品名と価格の情報を出力
		// System.out.println()を使って、コンソールに文字列を出力
		// +演算子を使って、文字列と変数の値を連結
		System.out.println("名前：" + item1.name);
		System.out.println("価格：" + item1.price + "円");

		// 区切り線を出力
		System.out.println("---");

		// Itemクラスのオブジェクトを生成し変数item2に代入
		// 2つ目のItemオブジェクトを作成
		Item item2 = new Item();

		// item2のフィールドに商品名「シャンプー」、価格「222」を設定
		// 2つ目のオブジェクトのnameフィールドに「シャンプー」を設定
		item2.name = "シャンプー";

		// 2つ目のオブジェクトのpriceフィールドに222を設定
		item2.price = 222;

		// showInfo()メソッドを利用して情報を出力
		// item2オブジェクトのshowInfo()メソッドを呼び出して、商品情報を表示
		item2.showInfo();
	}
}
