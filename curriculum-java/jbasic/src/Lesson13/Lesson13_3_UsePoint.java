public class Lesson13_3_UsePoint {
	public static void main(String[] args) {

		// Lesson13_2_Pointクラスの配列を生成し、要素数を4に設定
		// []は配列を表す記号
		Lesson13_2_Point[] points = {

			// newキーワードを使って、各クラスのインスタンスを生成
			new Lesson13_2_Point(3, 9),
			new Lesson13_2_ColorPoint(12, -3, "RED"),
			new Lesson13_2_Point(56, 2),
			new Lesson13_2_ColorPoint(7, -28, "BLUE")
		};

		// 拡張for文を使って、points配列の要素を1件ずつ取り出す
		// pointsは配列の名前、pointは配列の要素を1件ずつ取り出すための変数名
		// for (Lesson13_2_Point型 変数 : 配列名) { }の形で、配列の要素を1件ずつ取り出す
		for (Lesson13_2_Point point : points) {

			// 各クラスのshowPointメソッドを呼び出す
			point.showPoint();

			// 改行
			System.out.println();
		}
	}
}
