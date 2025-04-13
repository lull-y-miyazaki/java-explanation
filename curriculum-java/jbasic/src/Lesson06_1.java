
// クラス名はファイル名と同じにする
// 始まりは大文字
public class Lesson06_1 {

	// プログラムの実行は main メソッドから始まる
	public static void main(String[] args) {

		// int型配列のscoresを定義。配列の中身は整数値
		int[] scores;

		// 配列の要素数を指定して、配列を生成
		// 配列の要素数は、配列を生成する時に指定する
		// [3]なので、0,1,2の3つの要素を持つ配列が生成される
		scores = new int[3];

		// それぞれの配列の要素に値を代入
		// scores[0]は1人目、scores[1]は2人目、scores[2]は3人目のスコアを表す
		scores[0] = 89;
		scores[1] = 74;
		scores[2] = 92;

		//配列内で割り振られた番号で呼び出す
		// scores[0]は1人目、scores[1]は2人目、scores[2]は3人目のスコアを表す
		System.out.println("一人目：" + scores[0]);
		System.out.println("二人目：" + scores[1]);
		System.out.println("三人目：" + scores[2]);
	}
}
