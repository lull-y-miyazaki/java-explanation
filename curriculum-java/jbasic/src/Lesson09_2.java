// 3つのint型、年月日を引数に受け取り、
// その日付を表示するメソッドを定義し、呼び出すプログラム

public class Lesson09_2 {
	public static void main(String[] args) {

		// 日付を出力するshowDateメソッドの呼び出し
		showDate(2014, 4, 2);
		showDate(1994, 12, 9);
	}

	// 日付を出力するメソッドの定義
	// 引数はint型のyear,month,dayを受け取る
	static void showDate(int year, int month, int day) {
		System.out.println(year + "年" + month + "月" + day + "日");
		//戻り値がない（＝ここで出力する）のでresultは不要
	}
}

// 参考：
// 引数はメソッドを呼び出すときに渡す値
// 戻り値がない（＝戻り値のデータ型がない）場合はvoid
// staticを付けることでインスタンス（オブジェクト）が不要になる

// 実行結果：
// 2014年4月2日
// 1994年12月9日