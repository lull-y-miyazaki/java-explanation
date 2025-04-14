// 二重ループの練習問題

public class Lesson08_3 {
	public static void main(String[] args) {

		//二重ループ
		// 1から5までの数字を表示する
		// for文の書き方は、for(初期化; 条件式; 更新後の処理)
		for (int i = 1; i <= 5; i++) {

			// 表示する文字数はi回まで
			// 1回目は1文字、2回目は2文字、3回目は3文字、4回目は4文字、5回目は5文字表示する
			for (int j = 1; j <= i; j++) {

				// 1回の表示で*を表示する
				System.out.print("*");
			}

			// 1回の表示が終わったら改行
			System.out.println();
		}
	}
}

// 出力結果は以下の通り
// *
// **
// ***
// ****
// *****