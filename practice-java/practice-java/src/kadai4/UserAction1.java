// Step:4
// このクラスはユーザー情報を扱うプログラム
package kadai4;

public class UserAction1 {
	public static void main(String[] args) {

		// 1人目のユーザー（田中太郎）の情報を登録する処理
		// Userクラスのインスタンス（オブジェクト）を作成
		User u1 = new User();

		// ユーザーの名前を設定
		u1.name = "田中太郎";

		// ユーザーの年齢を設定
		u1.age = 20;

		// 設定した情報を画面に表示
		u1.showInfo();

		// 区切り線を表示
		System.out.println("---");

		// 2人目のユーザー（鈴木一郎）の情報を登録する処理
		// 新しいUserクラスのインスタンスを作成
		User u2 = new User();

		// ユーザーの名前を設定
		u2.name = "鈴木一郎";

		// ユーザーの年齢を設定
		u2.age = 25;

		// 設定した情報を画面に表示
		u2.showInfo();
	}
}