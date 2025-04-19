public class Lesson13_1_UseBookProduct {
	public static void main(String[] args) {

		// BookProductクラスのインスタンスを生成
		Lesson13_1_BookProduct b = new Lesson13_1_BookProduct();

		// BookProductクラスのフィールドに値を代入
		// ProductクラスだとshowBookメソッドが使えない
		b.price = 1400;
		b.title = "刑事コロンボ";
		b.publisher = "ABC出版";

		// BookProductクラスのshowBookメソッドを呼び出す
		b.showBook();
	}

}
