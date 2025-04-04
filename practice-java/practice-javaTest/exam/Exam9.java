package exam;

import java.util.HashMap;
import java.util.Scanner;


/**
 * 出力結果を参考に、java.util.HashMapを使って電話帳を作成しなさい
 */
public class Exam9 {

	public static void main(String[] args) {

		// HashMapは、キーと値のペアを保存するためのデータ構造
		// キーを使って値にアクセス
		// <String, String>は、キーと値の両方がString型という意味
		HashMap<String, String> phoneBook = new HashMap<String, String>(); // 電話帳
		Scanner scan = new Scanner(System.in);

		// while(true)は、条件が常に真であるため無限ループになり、break文でループを抜けるまで、繰り返し処理が実行される
		while (true) {
			// selectメソッドを呼び出して、操作番号を取得
			int input = select(scan); // 操作番号の入力

			// 入力された操作番号に応じて、対応する処理を実行
			if (input == 1) {
				// 登録
				register(scan, phoneBook);
			} else if (input == 2) {
				// 削除
				delete(scan, phoneBook);
			} else if (input == 3) {
				// 一覧表示
				list(phoneBook);
			} else if (input == 9) {
				// 終了
				System.out.println("アプリケーションを終了します");
				// break文でループを抜ける
				break;
			} else {
				// 何もしない（再入力させる）
			}
			System.out.println();
		}
	}

	// 操作番号を入力するメソッド
	// staticメソッドはクラスに属するメソッドで、オブジェクトを作成しなくても呼び出せる
	// privateメソッドは、同じクラス内からのみ呼び出せるメソッド
	static private int select(Scanner scan) {

		System.out.println("1：登録　2：削除　3：一覧表示　9：終了");
		System.out.print("操作番号を入力してください：");

		int input = scan.nextInt();

		return input;
	}

	// 電話帳に名前と電話番号を登録するメソッド
	// HashMapのputメソッドを使って、キー（名前）と値（電話番号）のペアを登録
	// 同じキーが既に存在する場合は、値が上書きされる
	static private void register(Scanner scan, HashMap<String, String> phoneBook) {

		System.out.print("名前を入力してください：");
		String name = scan.next();
		System.out.print("電話番号を入力してください：");
		String phoneNumber = scan.next();

		// 電話帳に名前と電話番号を登録
		phoneBook.put(name, phoneNumber);
	}

	// 電話帳から名前と電話番号を削除するメソッド
	// HashMapのremoveメソッドを使って、キー（名前）に対応する値（電話番号）を削除
	// 存在しないキーを指定した場合は、何も起こらない
	static private void delete(Scanner scan, HashMap<String, String> phoneBook) {
		System.out.print("名前を入力してください：");
		String name = scan.next();

		// 電話帳から名前と電話番号を削除
		phoneBook.remove(name);
	}

	// 電話帳に登録されている名前と電話番号の一覧を表示
	// HashMapのkeySetメソッドを使って、すべてのキー（名前）を取得
	// 取得したキーを使って、getメソッドで対応する値（電話番号）を取得
	static private void list(HashMap<String, String> phoneBook) {

		System.out.println("名前\t\t電話番号");
		System.out.println("---------------------------");
		// 拡張for文を使って、すべてのキーを順番に取り出す
		for (String name : phoneBook.keySet()) {
			// getメソッドを使って、キーに対応する値を取得
			System.out.println(name + "\t" + phoneBook.get(name));
		}
	}

}