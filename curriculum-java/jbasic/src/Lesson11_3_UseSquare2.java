// 3問目：
// square2クラスを使って、変の数4を持つstaticフィールドを定義し、UseSquareクラスで呼び出すプログラムを作成

public class Lesson11_3_UseSquare2 {
	public static void main(String[] args) {

		// Square2クラスのnumOfSide変数（＝4）を呼び出す
		System.out.println("四角形の辺の数は" + Lesson11_3_Square2.numOfSide + "です");

		// Square2クラスでインスタンス（オブジェクト）s1/s2の生成
		Lesson11_3_Square2 s1 = new Lesson11_3_Square2();
		Lesson11_3_Square2 s2 = new Lesson11_3_Square2();

		// Square2クラスで上記インスタンス（オブジェクト）の高さと幅を設定
		// s1の高さ・幅を設定
		s1.height = 15;
		s1.width = 7;

		// s2の高さ・幅を設定
		s2.height = 6;
		s2.width = 6;

		// 下記出力でSquare2クラスのareaメソッドの呼び出し
		// s1の面積を求める
		System.out.println("s1    高さ：" + s1.height + " 幅：" + s1.width + " 面積：" + s1.area());
		System.out.println("s2    高さ：" + s2.height + " 幅：" + s2.width + " 面積：" + s2.area());
	}
}
