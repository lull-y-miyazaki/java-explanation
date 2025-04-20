/*
* Step3：BookAction1クラスを作成し、mainメソッドからBookクラスを利用しなさい
*
* Step4：BookクラスのオブジェクトをItemクラスの変数に代入して利用しなさい
*/

package kadai6;

public class BookAction1 {
	public static void main(String[] args) {

		// Bookクラスのオブジェクトを生成し変数b1に代入
		Book b1 = new Book("走れメロス", 450, "太宰治");

		// BookクラスのshowInfo()メソッドを呼び出す
		b1.showInfo();

		System.out.println("---");

		// Bookクラスのオブジェクトを生成しItemクラスの変数i1に代入
		Item i1 = new Book("シャーロックホームズ", 600, "コナン・ドイル");

		// BookクラスのshowInfo()メソッドを呼び出す
		i1.showInfo();

	}
}
