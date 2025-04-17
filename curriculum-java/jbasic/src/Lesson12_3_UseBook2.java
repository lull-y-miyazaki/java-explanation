public class Lesson12_3_UseBook2 {
	public static void main(String[] args) {

		// Lesson12_2_Book2クラスのインスタンスを生成する
		// []は配列の初期化、[3]は要素数3の配列を生成
		Lesson12_2_Book2[] books = new Lesson12_2_Book2[3];

		// インスタンスを生成し、配列に格納する
		// 引数はコンストラクタの引数
		books[0] = new Lesson12_2_Book2("TCP/IP入門", "吉田茂樹", 2200);
		books[1] = new Lesson12_2_Book2("XMLのすべて", "高橋麻奈", 1800);
		books[2] = new Lesson12_2_Book2("話せる英文法", "有小山博美", 1500);

		// 拡張for文を使って、配列の要素を順番に取り出す
		// for(型 変数名 : 配列名) { }の形で、配列の要素を1件ずつ取り出す
		for (Lesson12_2_Book2 book : books) {

			// showBookメソッドを呼び出す
			// bookは配列の要素を1件ずつ取り出すための変数名
			book.showBook();
		}
	}
}

// 参考：

/*別のやり方①
// ただのfor文を使って、配列の要素を順番に取り出す

for (int i = 0; i < books.length; i++) {
    books[i].showBook();
}

*/

/*別のやり方②
// ArrayListと拡張for文を使って、配列の要素を順番に取り出す

import java.util.ArrayList;

// ArrayListを利用して、可変長の配列を作成
// <>はジェネリクスと呼ばれるもので、ArrayListの要素の型を指定する
ArrayList<Lesson12_2_Book2> bookList = new ArrayList<>();

// addメソッドを利用して、要素を追加する
bookList.add(new Lesson12_2_Book2("TCP/IP入門", "吉田茂樹", 2200));
bookList.add(new Lesson12_2_Book2("XMLのすべて", "高橋麻奈", 1800));
bookList.add(new Lesson12_2_Book2("話せる英文法", "有小山博美", 1500));

for (Lesson12_2_Book2 book : bookList) {
    book.showBook();
}

*/