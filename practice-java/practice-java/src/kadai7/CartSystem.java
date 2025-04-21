/**
 * Step6：Itemクラス（Step4で作成済み）とBookクラス（Step5で作成済み）にメソッドを追加し、
 * CartSystemクラスのmainメソッドから利用しなさい
 */

package kadai7;

// ArrayListクラスとListインターフェースをインポート
// Listインターフェースは、ArrayListクラスの親インターフェースであるため、両方をインポートする必要がある
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CartSystem {

	// ArrayListクラスのインスタンスを生成し、Listインターフェース型の変数に代入
	// ArrayListクラスは、可変長の配列を実装したクラスで、要素の追加や削除が容易にできる
	// <Item>は、Itemクラス型の要素を持つことを示す
	// ダイヤモンド演算子を使うことで、型を省略できる
	private static List<Item> cart = new ArrayList<Item>();

	// private修飾子をつけてカプセル化する
	// static修飾子をつけて、クラス変数にする
	// Scannerクラスのインスタンスを生成し、System.inを引数に渡す
	private static Scanner scan = new Scanner(System.in);


	// メインメソッド
	public static void main(String[] args) {

		// メニュー番号
		int menuNo = 0;

		// メニュー番号が9（終了）でない限り、繰り返す
		// while文は、条件式がtrueの間、繰り返し処理を行う
		while (menuNo != 9) {

			// メニューの表示とメニュー番号の取得
			menuNo = getMenuNo();

			// switch文は、指定した値に応じて処理を分岐する
			// 1:商品追加 2:書籍追加 3:情報更新 4:カートから削除 5:カートを検索 6:購入 9:終了
			switch (menuNo) {

			case 1:
				// 商品をカートに追加するメソッドを呼び出す
				addItem();

				// カートを表示するメソッドを呼び出す
				outputCart();

				// switch文を終了する
				break;

			case 2:
				// 書籍をカートに追加するメソッドを呼び出す
				addBook();

				// カートを表示するメソッドを呼び出す
				outputCart();

				// switch文を終了する
				break;

			case 3:
				// 情報更新するメソッドを呼び出す
				updateInfo();

				// カートを表示するメソッドを呼び出す
				outputCart();

				break;

			case 4:
				// カートから削除するメソッドを呼び出す
				removeCart();

				// カートを表示するメソッドを呼び出す
				outputCart();

				break;

			case 5:
				// カートを検索するメソッドを呼び出す
				searchCart();

				break;

			case 6:
				// 購入するメソッドを呼び出す
				purchase();

				// カートを表示するメソッドを呼び出す
				outputCart();

				break;

			case 9:
				System.out.println("またご来店ください");

				// 処理終了
				return;

			default:
				System.out.println("メニューは1,2,9のいずれかを選択してください");
				break;
			}
		}
	}

	// メニューの表示と番号の取得を行うメソッド
	// 戻り値はint型のメニュー番号を返す
	static int getMenuNo() {

		// メニューの表示
		System.out.println("1.商品追加");
		System.out.println("2.書籍追加");
		System.out.println("3.情報更新");
		System.out.println("4.カートから削除");
		System.out.println("5:カートを検索");
		System.out.println("6.購入");
		System.out.println("9.終了");

		// メニューの選択
		System.out.print("メニューを選択してください：");

		// nextInt()メソッドを利用して、整数を取得する
		int menuNo = scan.nextInt();

		return menuNo;
	}

	// 商品をカートに追加するメソッド
	// 戻り値はvoidなので、戻り値はない
	static void addItem() {

		System.out.println("商品をカートに追加します");

		System.out.print(" 商品名を入力してください：");

		// Scannerクラスのnext()メソッドを利用して、文字列を受け取る
		String name = scan.next();

		System.out.print(" 価格を入力してください：");

		// ScannerクラスのnextInt()メソッドを利用して、整数値を受け取る
		int price = scan.nextInt();

		// 商品オブジェクトの生成
		Item newItem = new Item(name, price);

		// add()メソッドを利用して、商品をカートに追加する
		cart.add(newItem);

		// 改行
		System.out.println();
	}

	// 書籍をカートに追加するメソッド
	// 戻り値はvoidなので、戻り値はない
	static void addBook() {

		System.out.println("書籍をカートに追加します");

		System.out.print(" 書籍名を入力してください：");

		// Scannerクラスのnext()メソッドを利用して、文字列を受け取る
		String name = scan.next();

		System.out.print(" 著者を入力してください：");

		// Scannerクラスのnext()メソッドを利用して、文字列を受け取る
		String author = scan.next();

		System.out.print(" 価格を入力してください：");

		// ScannerクラスのnextInt()メソッドを利用して、整数値を受け取る
		int price = scan.nextInt();

		// 商品オブジェクトの生成
		Book newBook = new Book(name, price, author);

		// add()メソッドを利用して、書籍をカートに追加する
		cart.add(newBook);

		// 改行
		System.out.println();
	}

	// カートの情報を表示するメソッド
	// 戻り値はvoidなので、戻り値はない
	static void outputCart() {

		System.out.println("No.\t商品情報");
		System.out.println("-------------------------");

		// 拡張for文ですべてのカート情報を取り出して表示する
		// 初期化
		int no = 0;
		for (Item item : cart) {

			// インクリメント
			// no ++は、noを1増やす
			no++;

			// 商品情報を出力
			System.out.print(no + "\t");
			System.out.println(item.getInfo());
		}

		System.out.println("-------------------------");
		System.out.println();
	}

	// 情報更新するメソッド
	// 戻り値はvoidなので、戻り値はない
	static void updateInfo() {

		System.out.println("情報を更新します");

		System.out.print(" No.を入力してください：");

		// ScannerクラスのnextInt()メソッドを利用して、整数値を受け取る
		int no = scan.nextInt();

		// try-catch文を利用して、例外処理を行う
		try {

			// 指定したNo.のものを取得
			// cart.get(no - 1)は、ArrayListのインデックスは0から始まるため、-1する
			Item item = cart.get(no - 1);

			// instanceof演算子を利用して、オブジェクトの型を判定する
			// itemがBookクラスのインスタンスであるかどうかを判定する
			if (item instanceof Book) {

				// 書籍の場合
				Book book = (Book) item;

				// 書籍名を更新
				System.out.print(" 書籍名を入力してください（現在：" + book.getName() + "）：");
				// Scannerクラスのnext()メソッドを利用して、文字列を受け取る
				book.setName(scan.next());

				// 著者を更新
				System.out.print(" 著者を入力してください（現在：" + book.getAuthor() + "）：");
				// Scannerクラスのnext()メソッドを利用して、文字列を受け取る
				book.setAuthor(scan.next());

				// 価格を更新
				System.out.print(" 価格を入力してください（現在：" + book.getPrice() + "）：");
				// ScannerクラスのnextInt()メソッドを利用して、整数値を受け取る
				book.setPrice(scan.nextInt());

			// itemがBookクラスのインスタンスでない場合
			// 商品の場合
			} else {

				// 商品名を更新
				System.out.print(" 商品名を入力してください（現在：" + item.getName() + "）：");
				// Scannerクラスのnext()メソッドを利用して、文字列を受け取る
				item.setName(scan.next());

				// 価格を更新
				System.out.print(" 価格を入力してください（現在：" + item.getPrice() + "）：");
				// ScannerクラスのnextInt()メソッドを利用して、整数値を受け取る
				item.setPrice(scan.nextInt());
			}

		// IndexOutOfBoundsExceptionは、配列の範囲外にアクセスした場合に発生する例外
		} catch (IndexOutOfBoundsException e) {

			// 選択されたNo.がない場合はエラー
			System.out.println(" 選択されたNo.はありません");
		}

		// 改行
		System.out.println();
	}

	// カートから削除するメソッド
	static void removeCart() {

		System.out.println("カートから削除します");

		System.out.print(" No.を入力してください：");

		// ScannerクラスのnextInt()メソッドを利用して、整数値を受け取る
		int no = scan.nextInt();

		// try-catch文を利用して、例外処理を行う
		// 指定したNo.のものを取得
		try {

			// カートから削除
			// (no - 1)は、ArrayListのインデックスは0から始まるため、-1する
			cart.remove(no - 1);

		// IndexOutOfBoundsExceptionは、配列の範囲外にアクセスした場合に発生する例外
		} catch (IndexOutOfBoundsException e) {

			// 選択されたNo.がない場合はエラー
			System.out.println(" 選択されたNo.はありません");
		}

		// 改行
		System.out.println();
	}


	// カートを検索するメソッド
	// 戻り値はvoidなので、戻り値はない
	static void searchCart() {

		System.out.println("カートを検索します");

		// 検索キーワードの入力
		System.out.print(" 検索キーワードを入力してください：");
		// Scannerクラスのnext()メソッドを利用して、文字列を受け取る
		String keyword = scan.next();

		// 検索結果表示
		System.out.println();
		System.out.println("商品情報");
		System.out.println("-------------------------");

		// 拡張for文ですべてのカート情報を取り出して表示する
		// cartの要素を一つずつ取り出して、itemに代入する
		// for(型 変数名 : 配列名)の形でfor文を記述する
		for (Item item : cart) {

			// instanceof演算子を利用して、オブジェクトの型を判定する
			// itemがBookクラスのインスタンスであるかどうかを判定する
			if (item instanceof Book) {

				// itemがBookクラスのインスタンスである場合
				// Bookクラスにキャストして、itemをBook型に変換する
				Book book = (Book) item;

				// if文を利用して、書籍名または著者名にキーワードが含まれているかどうかを判定する
				// item.getName()は、ItemクラスのgetName()メソッドを呼び出して、商品名を取得する
				// item.getAuthor()は、BookクラスのgetAuthor()メソッドを呼び出して、著者名を取得する
				if (book.getName().contains(keyword) || book.getAuthor().contains(keyword)) {

					// 入力したキーワードが名前あるいは著者に含まれていれば出力
					System.out.println(book.getInfo());
				}
			// itemがBookクラスのインスタンスでない場合
			// 商品の場合
			} else {

				// if文を利用して、商品名にキーワードが含まれているかどうかを判定する
				// item.getName()は、ItemクラスのgetName()メソッドを呼び出して、商品名を取得する
				if (item.getName().contains(keyword)) {

					// 入力したキーワードが名前に含まれていれば出力
					System.out.println(item.getInfo());
				}
			}
		}
		System.out.println("-------------------------");

		// 改行
		System.out.println();
	}

	// 購入するメソッド
	// 戻り値はvoidなので、戻り値はない
	static void purchase() {

		System.out.println("購入します");

		// 初期化
		int total = 0;

		// for文を利用して、カートの中身をすべて取り出して、合計金額を計算する
		// cartの要素を一つずつ取り出して、itemに代入する
		// for(型 変数名 : 配列名)の形でfor文を記述する
		for (Item item : cart) {

			// item.getPrice()は、ItemクラスのgetPrice()メソッドを呼び出して、価格を取得する
			// total += item.getPrice();は、total = total + item.getPrice();と同じ意味
			total += item.getPrice();
		}

		// 合計金額の表示
		System.out.println(" ＊＊＊合計金額は" + total + "円です＊＊＊");

		// clear()メソッドを利用して、カートを空にする
		cart.clear();

		// 改行
		System.out.println();
	}
}

/* 補足：

「 配列とArrayListの違い 」

・配列は、固定長のデータ構造で、要素数を変更できない
	・ArrayListは、可変長のデータ構造で、要素数を変更できる

	・要素（int[] や String[]）数の取得方法→length
	・要素の取得方法→配列名[インデックス番号]で取得できる

	・配列は、要素数を指定して生成する必要がある
	例）int[] arr = new int[5]; // 要素数5のint型配列を生成

・ArrayListは、要素数を指定せずに生成できる
	例）List<String> list = new ArrayList<String>(); // 要素数を指定せずに生成

	・要素数の取得方法→size()メソッドを使う
	・要素の取得方法→get(インデックス番号)メソッドを使う
	・要素の追加方法→add(要素)メソッドを使う
	・要素の削除方法→remove(インデックス番号)メソッドを使う
	・要素の更新方法→set(インデックス番号, 新しい要素)メソッドを使う
	・要素の検索方法→contains(要素)メソッドを使う
	・要素のクリア方法→clear()メソッドを使う
	(removeとの違いは、removeは指定した要素を削除するが、clearは全ての要素を削除する)
	・要素のソート方法→Collections.sort(list)メソッドを使う
	・要素の逆順ソート方法→Collections.reverse(list)メソッドを使う

 */