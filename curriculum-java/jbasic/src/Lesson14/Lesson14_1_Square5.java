/*
問題１:Square5クラス
*図形を表現するFigure抽象クラスを定義してください。このクラスは、全ての図形クラスの抽象クラスとなります。
*Figure抽象クラスは、面積を求めるメソッドを持っていますが、具体的な公式にはサブクラスによって異なります。
*Figure抽象クラスを継承して、Circleクラス、Triangleクラス、Squareクラスを作成してください。
*面積を求めるためのサイズ（縦や半径など）を、各クラスがフィールドとして保持するようにしてください。
*また、その値をコンストラクタで初期化できるようにします。上記以外のメソッドを追加することは任意です（例えば図形の情報を表示するなど）。
*/

// extends修飾子をつけて、Figureクラスを継承
class Square5 extends Figure {

	// 縦と横を定義するフィールド
	// private修飾子をつけて、他のクラスからアクセスできないように
	// ただし、同じクラス内からはアクセスできる
	private int height;
	private int width;

	// 縦と横を初期化するコンストラクタ
	public Square5(int height, int width) {

		// thisキーワードを使って、フィールドと引数の名前が同じ場合にフィールドを参照
		this.height = height;
		this.width = width;
	}

	// 四角形の面積を求めるメソッド
	// FigureクラスのgetAreaメソッドをオーバーライドしている
	// public修飾子をつけて、他のクラスからアクセスできるように
	public double getArea() {

		// heightとwidthを掛け算して面積を求めて、呼び出し元に返す
		return height * width;
	}
}

/*
継承元のfigure(フィギュア)クラス

*abstract修飾子をつけることで抽象クラスとなる
*abstract class Figure {

	*面積を求める抽象メソッド。ただし公式自体は継承先に記述
	*具体的な実装はサブクラスで行い、サブクラスで必ずオーバーライドしなければならない
	*そのため、abstract修飾子をつけている
	*public修飾子をつけて、他のクラスからアクセスできるように

	public abstract double getArea();
}
*/