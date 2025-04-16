// 1問目：
// 四角形を表すクラスを定義
// フィールドにはint型のheightとwidthを定義

public class Lesson11_1_Square {

	//インスタンス変数（フィールド）
	int height;
	int width;

	//設定されたインスタンス（オブジェクト）の値を取得し面積を求めるメソッド
	int area() {
		return height * width; //計算結果をUseSquareクラスの14・15行目に戻す
	}
}

//補足：
//height 高さ
//width 幅
//area 面積
//インスタンス変数（フィールド）とは、クラスの中で定義された変数で、
//インスタンス（オブジェクト）ごとに異なる値を持つことができる変数のこと