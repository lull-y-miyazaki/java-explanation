// Step7：名前（文字列）と年齢（整数）をキーボードから受け取り、エラーチェックをしなさい。
// 名前のエラーをチェックをするhasNameError()メソッドと、
// 年齢のエラーチェックをするhasAgeError()メソッドを作りなさい。

// このプログラムはユーザー登録を行うためのクラスです
package kadai3;

// キーボードからの入力を受け取るために必要なクラスをインポート
import java.util.Scanner;

// UserRegistration2という名前のクラスを定義
public class UserRegistration2 {

	// プログラムの実行開始点となるmainメソッド
	public static void main(String[] args) {

		// キーボードからの入力を受け取るためのScannerオブジェクトを作成
		Scanner scan = new Scanner(System.in);

		// ユーザーに名前の入力を促すメッセージを表示
		System.out.print("名前を入力してください：");

		// 入力された名前を変数nameに格納
		String name = scan.next();

		// 入力された名前が正しいかチェック
		if (hasNameError(name)) {

			// 名前にエラーが存在した場合mainメソッドを終了する
			scan.close();

			return;
		}

		// ユーザーに年齢の入力を促すメッセージを表示
		System.out.print("年齢を入力してください：");

		// 入力された年齢を整数として変数ageに格納
		int age = scan.nextInt();

		// 入力された年齢が正しいかチェック
		if (hasAgeError(age)) {

			// 年齢にエラーが存在した場合mainメソッドを終了する
			scan.close();

			return;
		}

		// 登録完了メッセージを表示
		System.out.println("名前：" + name + "、年齢：" + age + "で登録しました。");

		// Scannerオブジェクトを閉じてリソースを解放
		scan.close();
	}

	// 名前の入力値チェックを行うメソッド
	static boolean hasNameError(String name) {

		// 名前が20文字より長い場合エラー
		if (name.length() > 20) {

			System.out.println("名前は20文字以内で入力してください");

			return true;
		}

		// 名前に禁止文字「㌔」が含まれている場合エラー
		if (name.contains("㌔")) {

			System.out.println("名前に禁止文字が含まれています");

			return true;
		}

		// 名前が「admin」の場合エラー
		if (name.equals("admin")) {

			System.out.println("利用できない名前です");

			return true;
		}

		// エラーがない場合はfalseを返す
		return false;
	}

	// 年齢の入力値チェックを行うメソッド
	static boolean hasAgeError(int age) {

		// 年齢が0未満または130より大きい場合エラー
		if (age < 0 || 130 < age) {

			System.out.println("年齢は0以上130以下で入力してください");

			return true;
		}

		// エラーがない場合はfalseを返す
		return false;
	}
}
