/*
* Step1：Item（商品）クラスを作成し、ItemActionクラスのmainメソッドから利用しなさい（復習）

*「Item（商品）クラスの仕様」
* フィールド
* 商品名（name）：文字列、外部からのアクセス禁止
* 価格（price）：整数、外部からのアクセス禁止

* コンストラクタ
* デフォルトコンストラクタ
* 引数からすべてのフィールドを初期化するコンストラクタ

* メソッド
* 全てのフィールドに対するゲッター、セッター
* showInfo() メソッド
* - 引数なし
* - 戻り値なし
* - フィールドに保持されている商品名を出力する
* - フィールドに保持されている価格を出力する
* - 出力例：
* 商品名：絵本
* 価格：1000円
*/

package kadai6;

public class ItemAction {
	public static void main(String[] args) {

		// Itemオブジェクト（ロボット掃除機/50000円）を生成
		Item i1 = new Item("ロボット掃除機", 50000);

		// ItemクラスのshowInfo()メソッドを呼び出す
		i1.showInfo();

		System.out.println("---");

		// Itemオブジェクト（洗濯機/200000円）を生成
		Item i2 = new Item("洗濯機", 200000);

		// ItemクラスのshowInfo()メソッドを呼び出す
		i2.showInfo();
	}
}
