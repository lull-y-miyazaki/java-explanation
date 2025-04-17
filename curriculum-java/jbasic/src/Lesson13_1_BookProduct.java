// Productクラスから継承したBookProductクラス
// BookProductクラスはProductクラスのフィールドやメソッドを持つ
public class Lesson13_1_BookProduct extends Lesson13_1_Product {

	// 親クラスのフィールドを継承しているので、priceはこのクラスに定義する必要はない
	// ただし、private修飾子をつけているので、BookProductクラスからは直接アクセスできない
	String title;
	String publisher;

	// sowBookメソッドは、BookProductクラスのフィールドを出力するメソッド
	void showBook() {
		System.out.println("タイトル：" + title);
		System.out.println("出版社：" + publisher);

		// showPriceメソッドは、Productクラスのフィールドを出力するメソッド
		showPrice();
	}
}
