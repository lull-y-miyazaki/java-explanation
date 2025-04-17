public class Lesson12_1_UseBook {
	public static void main(String[] args) {

		// Bookインスタンス（オブジェクト）を生成
		// 引数にタイトル、著者、価格を指定
		Lesson12_1_Book b1 = new Lesson12_1_Book("TCP/IP入門", "吉田茂樹", 2200);
		Lesson12_1_Book b2 = new Lesson12_1_Book("XMLのすべて", "高橋麻奈", 1800);

		// Bookクラスの出力メソッドを呼び出す
		b1.showBook();
		b2.showBook();
	}

}