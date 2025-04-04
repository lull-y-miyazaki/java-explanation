package quiz;

public class quiz1 {

	public static void main(String[] args) {
		int score = 95;
		// socreに応じてメッセージを変える
		if (score >= 90) {
			System.out.println("優");
		} else if (score >= 80) {
			System.out.println("良");
		} else if (score >= 60) {
			System.out.println("可");
		} else {
			System.out.println("不可");
		}

	}

}

//以下、文法説明
//
//if(条件式1) {
//	処理1
//} else if(条件式2) {
//	処理2
//} else if(条件式3) {
//	処理3
//} else {
//	処理4
//}

//以下、キーワード解説
//if():条件分岐の開始宣言
//else if():別パターンの場合の処理（条件式を記入する場合はこれ！）
//else:その他の場合の処理（条件式は記入しない！）
