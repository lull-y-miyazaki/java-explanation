// 4問目：
// square3クラスを使って、引数の数が異なるsetDataメソッドを定義し、
// 引数の数が異なるsetDataメソッドを呼び出すプログラムを作成

public class Lesson11_4UseSquare3 {
	public static void main(String[] args) {

		// Square3クラスのnumOfSide変数（＝4）を呼び出す
		// static変数はクラスに属する変数で、インスタンス（オブジェクト）を生成しなくても使用できる
		System.out.println("四角形の辺の数は" + Lesson11_4_Square3.numOfSide + "です");

		// Square3クラスでインスタンス（オブジェクト）s1/s2の生成
		Lesson11_4_Square3 s1 = new Lesson11_4_Square3();
		Lesson11_4_Square3 s2 = new Lesson11_4_Square3();

		// 引数が2つ（＝長方形）の場合のsetDataメソッドへ
		s1.setData(4, 9);

		// 引数が1つ（＝正方形）の場合のsetDataメソッドへ
		s2.setData(7);

		// 下記出力でSquare3クラスのareaメソッドの呼び出し
		System.out.println("s1    高さ：" + s1.height + " 幅：" + s1.width + " 面積："
				+ s1.area());
		System.out.println("s2    高さ：" + s2.height + " 幅：" + s2.width + " 面積："
				+ s2.area());
	}
}
