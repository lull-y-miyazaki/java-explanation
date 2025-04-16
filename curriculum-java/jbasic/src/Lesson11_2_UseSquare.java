// 2問目：
// 1問目のLesson11_1_Squareクラスを使って、インスタンス（オブジェクト）s1/s2を生成し、
// s1の高さ・幅を15・7、s2の高さ・幅を6・6に設定し、面積を求めるプログラムを作成

public class Lesson11_2_UseSquare {
	public static void main(String[] args) {

		//Squareクラスでインスタンス（オブジェクト）s1/s2の生成
		Lesson11_1_Square s1 = new Lesson11_1_Square();
		Lesson11_1_Square s2 = new Lesson11_1_Square();

		//Squareクラスで上記インスタンス（オブジェクト）の高さと幅を設定

		//s1の高さ・幅を設定
		s1.height = 15;
		s1.width = 7;

		//s2の高さ・幅を設定
		s2.height = 6;
		s2.width = 6;

		//下記出力でSquareクラスのareaメソッドの呼び出し
		System.out.println("s1    高さ：" + s1.height + " 幅：" + s1.width + " 面積：" + s1.area());
		System.out.println("s2    高さ：" + s2.height + " 幅：" + s2.width + " 面積：" + s2.area());
	}
}
