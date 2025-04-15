// step6：名前（文字列）と年齢（整数）をキーボードから受け取り、
// エラーチェックをしなさい。mainメソッドのみで処理します。

package kadai3;

// キーボードからの入力を受け取るためのScannerクラスをインポート
import java.util.Scanner;

/**
 * 名前（文字列）と年齢（整数）の入力をキーボードから受け取り入力値のチェックを行いなさい
 */
public class UserRegistration1 {
	// プログラムのエントリーポイント（開始点）
	public static void main(String[] args) {

		// キーボードからの入力を受け取るためのScannerオブジェクトを作成
		Scanner scan = new Scanner(System.in);

		// ユーザーに名前の入力を促すメッセージを表示
		System.out.print("名前を入力してください：");

		// キーボードから入力された文字列をname変数に格納
		String name = scan.next();

		// 名前の長さが20文字を超えているかチェック
		if (name.length() > 20) {

			// エラーメッセージを表示
			System.out.println("名前は20文字以内で入力してください");

			// Scannerを閉じてリソースを解放（なくてもOK）
			scan.close();

			return;
		}

		// 入力された名前が「admin」と一致するかチェック
		if (name.equals("admin")) {

			// エラーメッセージを表示
			System.out.println("利用できない名前です");

			// Scannerを閉じてリソースを解放
			scan.close();

			return;
		}

		// 名前に禁止文字「㌔」が含まれているかチェック
		if (name.contains("㌔")) {

			// エラーメッセージを表示
			System.out.println("名前に禁止文字が含まれています");

			// Scannerを閉じてリソースを解放
			scan.close();

			return;
		}

		// ユーザーに年齢の入力を促すメッセージを表示
		System.out.print("年齢を入力してください：");

		// キーボードから入力された整数をage変数に格納
		int age = scan.nextInt();

		// 年齢が0未満、または130より大きいかチェック
		if (age < 0 || 130 < age) {

			// エラーメッセージを表示
			System.out.println("年齢は0以上130以下で入力してください");

			// Scannerを閉じてリソースを解放
			scan.close();

			return;
		}

		// 入力された名前と年齢を表示して登録完了を通知
		System.out.println("名前：" + name + "、年齢：" + age + "で登録しました。");

		// Scannerを閉じてリソースを解放
		scan.close();
	}
}
