// 4問目：
// 1で作成したSquareクラスを使って、引数の数が異なるsetDataメソッドを定義し、
// 引数の数が異なるsetDataメソッドを呼び出すプログラムを作成

public class Lesson11_4_Square3 {

	//インスタンス変数（フィールド）
	//インスタンス変数はインスタンス（オブジェクト）を生成しないと使用できない
	int height;
	int width;

	// static変数はクラスに属する変数で、インスタンス（オブジェクト）を生成しなくても使用できる
	static int numOfSide = 4;

	//いずれかのsetDataから高さ・幅を使って面積を計算
	int area() {
		return height * width;
	}

	// ↓↓↓setDataメソッドのオーバーロード（引数の数が違うメソッドを複数定義）

	//2つの引数を持つsetDataメソッド（長方形の設定）
	//第一引数を高さ、第二引数を幅とする
	void setData(int h, int w) {
		height = h;
		width = w;
	}

	//1つの引数を持つsetDataメソッド（正方形の設定）
	//引数の値を高さ・幅の両方に設定する
	void setData(int len) {
		height = len;
		width = len;
	}
}

// 補足
// オーバーロードとは、同じメソッド名で引数の数や型が異なるメソッドを複数定義すること
// 例）setDataメソッドは引数の数が異なるのでオーバーロードされている