/*
* Step8：Humanクラス（Step6で作成済み）とWarriorクラス（Step7で作成済み）を利用し、以下の出力結果になるようにPlayGameクラス（mainメソッドを定義しているクラス）を作成しなさい。
*/

package kadai6;

import java.util.Scanner;

public class PlayGame {
	public static void main(String[] args) {

		// Humanクラスの配列を作成
		// 3人のキャラクターを作成するため、要素数3の配列を作成
		Human[] party = new Human[3];

		// キーボードからの入力を受け付けるために、Scannerクラスを利用
		Scanner scan = new Scanner(System.in);

		// パーティを作成するメソッドを呼び出す
		// 引数にキーボードからの入力を受け付けるScannerクラスのオブジェクトとHumanクラスの配列を渡す
		makeParty(scan, party);

		// while(条件式)
		// 条件式がtrueの間、繰り返し処理を行う
		// 条件式がfalseになると、繰り返し処理を終了する
		while (true) {

			System.out.println();

			// 下に定義した操作を選択するselectOperationメソッドを呼び出す
			// 引数にキーボードからの入力を受け付けるScannerクラスのオブジェクトを渡す
			// 戻り値として、選択した操作を受け取る
			int operation = selectOperation(scan);

			// 選択した操作に応じて、処理を分岐する
			// 1:一覧表示 2:攻撃 9:終了
			if (operation == 1) {

				// 一覧表示するshowメソッドを呼び出す
				// Humanクラスの配列を引数に渡すことで、パーティの情報を表示する
				show(party);

			// 選択した操作が2の場合は攻撃する
		} else if (operation == 2) {

				// 攻撃するattackメソッドを呼び出す
				// attackメソッドを呼び出す
				attack(party);

			// 選択した操作が1と2以外の場合は終了する
			} else {

				// 終了
				break;
			}
		}
	}

	// パーティを作成するメソッド
	// private修飾子をつけてカプセル化、static修飾子をつけてクラスメソッドにする
	// 戻り値はないのでvoidを指定
	// 引数にキーボードからの入力を受け付けるScannerクラスのオブジェクトとHumanクラスの配列を渡す
	private static void makeParty(Scanner scan, Human[] party) {

		System.out.println("=== パーティを作成します ===");

		// 繰り返し処理を利用して、パーティの人数分キャラクターを作成する
		// for(初期化文; 条件式; 更新後)
		// 条件式がtrueの間、繰り返し処理を行う
		for (int index = 0; index < party.length; index++) {

			System.out.print("どちら（1:市民 2:戦士）を作成しますか：");

			// ScannerクラスのnextInt()メソッドを利用して、整数値を受け取る
			// 市民か戦士かを選択する
			int kind = scan.nextInt();

			System.out.print("名前：");

			// Scannerクラスのnext()メソッドを利用して、文字列を受け取る
			String name = scan.next();

			// 選択したキャラクターの種類に応じて、処理を分岐する
			// 1:市民 2:戦士
			switch (kind) {

			// 1を選択した場合
			case 1:

				// 市民の作成
				// party[index]はHumanクラスの配列で、partyの人数分の要素を持つ
				// つまり人数分のキャラクターを作成する
				party[index] = new Human(name);

				// break文で処理を終了する
				break;

			// 2を選択した場合(それ以外の値が選択された場合)
			default:

				// 戦士の作成
				System.out.print("種別：");

				// Scannerクラスのnext()メソッドを利用して、文字列を受け取る
				// 戦士の種別を入力する
				String type = scan.next();

				// party[index]はHumanクラスの配列で、partyの人数分の要素を持つ
				// つまり人数分のキャラクターを作成する
				party[index] = new Warrior(name, type);
			}
		}
		System.out.println("=== パーティを作成しました ===");
	}

	// 操作を選択するメソッド
	private static int selectOperation(Scanner scan) {
		System.out.print("操作（1:一覧表示 2:攻撃 9:終了）を選択してください：");

		// ScannerクラスのnextInt()メソッドを利用して、整数値を受け取る
		int operation = scan.nextInt();

		// 選択した操作を返す
		return operation;
	}

	// 攻撃するメソッド
	// private修飾子をつけてカプセル化、static修飾子をつけてクラスメソッドにする
	// 戻り値はないのでvoidを指定
	// Humanクラスの配列は、パーティの人数分の要素を持つ
	private static void attack(Human[] party) {

		// 拡張for文を利用して、配列の要素を順番に取り出す
		// for(型 変数名 : 配列名)
		for (Human member : party) {

			// キャラクターの人数分攻撃する
			// それぞれのキャラクターのattack()メソッドを呼び出す
			member.attack();
		}
	}

	// 一覧表示するメソッド
	// private修飾子をつけてカプセル化、static修飾子をつけてクラスメソッドにする
	// 戻り値はないのでvoidを指定
	// Humanクラスの配列は、パーティの人数分の要素を持つ
	private static void show(Human[] party) {

		// 拡張for文を利用して、配列の要素を順番に取り出す
		// for(型 変数名 : 配列名)
		for (Human member : party) {

			// キャラクターの人数分情報を表示する
			// それぞれのキャラクターのinfo()メソッドを呼び出す
			member.info();
		}
	}
}
