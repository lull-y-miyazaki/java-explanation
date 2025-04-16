// 3問目：
// 1で定義したSquareクラスを使って、変の数4を持つstaticフィールドを定義し、UseSquareクラスで呼び出すプログラムを作成

public class Lesson11_3_Square2 {

	// インスタンス変数（フィールド）
	int height;
	int width;

	// static変数はクラスに属する変数で、インスタンス（オブジェクト）を生成しなくても使用できる
	static int numOfSide = 4;

	// 設定されたインスタンス（オブジェクト）の値を取得し面積を求めるメソッド
	// インスタンスメソッドはインスタンス（オブジェクト）を生成しないと使用できない
	int area() {
		return height * width;
	}
}