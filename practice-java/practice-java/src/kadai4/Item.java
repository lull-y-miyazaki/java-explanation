// Step:1
// このクラスは、商品を表すクラス

// Step:3
// 商品名と価格を持ち、商品の情報を表示するメソッドを持る

package kadai4;

// 商品を表すクラスを定義
public class Item {

	// フィールド（クラスの属性）を定義
	// 商品名を格納する変数
	String name;

	// 商品の価格を格納する変数
	int price;

	// 商品の情報を表示するメソッドを定義
	void showInfo() {

		// 商品名を表示
		System.out.println("名前：" + name);

		// 税抜き価格を表示
		System.out.println("価格(税抜き)：" + price + "円");

		// 税込み価格を計算して表示（税率10%）
		// (int)で小数点以下を切り捨て
		System.out.println("価格(税込み)：" + (int) (price * 1.1) + "円");
		}
	}
