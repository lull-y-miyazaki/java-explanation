// Step5：
// 名前と趣味を登録できるプログラムを作成し、最後に自己紹介となるように出力してください。
// 趣味は３つ登録を受け付けて配列に保存します。出力する際には拡張 for 文を利用して出力してください。
// このプログラムは個人情報を入力して自己紹介を行うプログラムです

package kadai2;

// キーボードからの入力を受け付けるためのScannerクラスをインポート
import java.util.Scanner;

// Introduce2という名前のクラスを定義
public class Introduce2 {

	// プログラムの実行開始点となるmainメソッド
	public static void main(String[] args) {

		// ユーザーの入力を受け取る準備（Scannerの作成）
        // System → Javaの標準的なクラス
        // .in → 「入力（input）」の略
		Scanner scan = new Scanner(System.in);

		// ユーザーに情報登録の開始を通知
		System.out.println("情報を登録します");

		// 名前の入力を促すメッセージを表示
		System.out.print("名前：");

		// 入力された名前を変数nameに格納
		// next()メソッドは、スペースで区切られた単語を1つだけ読み取る
		String name = scan.next();

		// 趣味を格納するための3つの要素を持つ配列を作成
		// String型の配列hobbyListを宣言し、3つの要素を持つ配列を作成
		// [3]は配列のサイズを指定しており、0,1,2の3つのインデックスを持つ
		String[] hobbyList = new String[3];

		// 1つ目の趣味の入力を促すメッセージを表示
		System.out.print("趣味1：");

		// 入力された1つ目の趣味を配列の最初の要素に格納
		// [0]は配列の最初のインデックスを指定しており、1つ目の趣味が格納される
		hobbyList[0] = scan.next();

		// 2つ目の趣味の入力を促すメッセージを表示
		System.out.print("趣味2：");

		// 入力された2つ目の趣味を配列の2番目の要素に格納
		// [1]は配列の2番目のインデックスを指定しており、2つ目の趣味が格納される
		hobbyList[1] = scan.next();

		// 3つ目の趣味の入力を促すメッセージを表示
		System.out.print("趣味3：");

		// 入力された3つ目の趣味を配列の3番目の要素に格納
		// [2]は配列の3番目のインデックスを指定しており、3つ目の趣味が格納される
		hobbyList[2] = scan.next();

		// 区切り線を表示
		System.out.println("---");

		// 入力された名前を使って自己紹介のメッセージを表示
		System.out.println("こんにちは" + name + "です");

		// 趣味の紹介を開始するメッセージを表示
		System.out.println("私の趣味は、");

		// 配列に格納された趣味を順番に表示するための拡張for文
		// for(要素の型 変数名 : 配列名) の形でループを作成
		for (String hobby : hobbyList) {

			// 各趣味の前に「・」を付けて表示
			System.out.println("・" + hobby);
		}

		// 趣味の紹介を終了するメッセージを表示
		System.out.println("です");

		// Scannerを閉じて受付終了
		scan.close();
	}
}
