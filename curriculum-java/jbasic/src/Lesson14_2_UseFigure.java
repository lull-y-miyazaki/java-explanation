/*
問題２:
*Figure抽象クラス型の配列を生成して、3つの図形を管理してください。
*for文を使って、各図形の面積を画面に表示してください。
*/

class UseFigure {
	public static void main(String[] args) {

		// 親クラスのFigure型の配列を生成
		// 3つの図形を管理するため、要素数3の配列を生成
		// []の部分は配列を生成するための記号
		Figure[] figures = {new Triangle(3, 5), new Circle3(4), new Square5(9, 10)};


		// for文を使って、各図形の面積を画面に表示
		// figures.lengthで配列の要素数を取得
		// for(初期化; 条件式; 後処理)の形でfor文を記述
		for (int i = 0; i < figures.length; i++) {

			// figures[i]で各サブクラスのインスタンスを取得
			// figures[i].getArea()は各サブクラスのgetAreaメソッドを呼び出す
			System.out.println("図形" + (i + 1) + "の面積：" + figures[i].getArea());
		}
	}
}

// 補足：

// ポリモーフィズムとは
	// 「同じメソッド名でも、呼び出される内容がクラスによって違う」仕組み

// 抽象クラスとは
	// インスタンス化できないクラスのこと
	// 他のクラスに継承されることを目的としており、抽象メソッドを持つことができる

	// 抽象メソッドは、実装を持たないメソッドのこと
	// 抽象メソッドは、サブクラスで実装する必要がある