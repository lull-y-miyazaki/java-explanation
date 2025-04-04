package quiz;

import java.util.Scanner;

/**
 * キーボードから取得した点数によってメッセージを変えなさい
 * ・7だったら「大当たり」
 * ・7以外で7の倍数「当たり」
 * ・それ以外「ハズレ」
 */

public class quiz2 {

	public static void main(String[] args) {
		
		// Scannerオブジェクトを作成し、標準入力を受け取れるようにする
		Scanner scan = new Scanner(System.in);

		// ユーザーに入力を促すメッセージを表示
		System.out.print("入力：");

		// ユーザーから整数の入力を受け取る
		int input = scan.nextInt();

		// 入力された値に対して判定処理を行う
		if (input == 7) {  // 入力された値が7の場合
		    // "大当たり"と表示
			System.out.println("大当たり");
		} else if (input % 7 == 0) {  // 入力された値が7の倍数の場合
		    // "当たり"と表示
			System.out.println("当たり");
		} else {  // 上記の条件に当てはまらない場合（7や7の倍数でない場合）
		    // "ハズレ"と表示
			System.out.println("ハズレ");
		}

		// Scannerオブジェクトを閉じる（メモリに無駄な容量が残らないように）
		scan.close();

	}

}
