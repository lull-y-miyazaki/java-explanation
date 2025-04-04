package exam;

/**
 * 長方形と三角形の面積を計算するメソッドを作成し利用しなさい
 */
public class Exam3 {
	public static void main(String[] args) {

		// 長方形の面積を計算する
		int a1 = getSquareArea(3, 3);
		System.out.println(a1);

		// 三角形の面積を計算する
		double a2 = getTriangleArea(3, 3);
		System.out.println(a2);
	}

	// 引数で幅と高さを受け取り長方形の面積を返す
	// getSquareArea()メソッドを作りなさい（5点）
	public static int getSquareArea(int width, int hight) {
		return width * hight;
	}

	// 引数で幅と高さを受け取り三角形の面積を返す
	// getTriangleArea()メソッドを作りなさい（5点）
	public static double getTriangleArea(int width, int hight) {
		return width * hight / 2.0;
	}
}