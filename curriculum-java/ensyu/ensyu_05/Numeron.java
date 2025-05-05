// 【問題5】プログラムが0〜9までの数字3つを使ってランダムに作成した3ケタの番号を当てるゲームを作成してください。
// ただし、「550」「337」といった同じ数字を2つ以上使用した番号はないように作成してください。

// 必要なライブラリをインポート
import java.util.ArrayList; // サイズが自動で増える配列（リスト）
import java.util.List;
import java.util.Random;    // 「ランダムな数字」を作るための道具
import java.util.Scanner;

public class Numeron {
	public static void main(String[] args) {

		// 3桁のランダムな数字（重複なし）を生成して追加していくためのリスト
		List<Integer> answer = new ArrayList<>();

		// ランダムな数を作るためのクラス
		Random rand = new Random();

		// answerリストに数字が3つ入るまで、くり返してねという命令
		while (answer.size() < 3) {

		 // 0〜9の中からランダムに数字を1つ選ぶ
			int num = rand.nextInt(10);

			// すでに含まれていない数字だけを追加（重複チェック）
			if (!answer.contains(num)) {

				// 重複していないと確認ができたら、answerにnumを追加する
				answer.add(num);
			}
		}

		// 最終的にanswerに重複しない数字が3つ入る！


		// ユーザーにルールを表示
		System.out.println("■■■ Numeronルール ■■■");
		System.out.println("プログラムが0～9までの数字3つを使って作成した3ケタの番号を当ててください。");
		System.out.println("ただし、「550」「377」といった同じ数字を2つ以上使用した番号はありません。");
		System.out.println("入力した数字の、「位置」と「数字」が当たっていたら「eat」とカウント、");
		System.out.println("「数字」だけあってたなら「bite」とカウントします。");
		System.out.println("eat : 3になったら、ゲーム終了です。");


		// ユーザー（キーボード）からの入力を受け取る準備
		Scanner scan = new Scanner(System.in);

		// ユーザーの試行回数をカウント（この後の毎回のループで turn++ していく）
		int turn = 0;

		System.out.println();
		System.out.println("------ ゲーム開始 ------");

		// 正解（eatが3）で break; されるまで無限ループ
		while (true) {
			turn++;  // 回数を1回分追加

			System.out.println("3文字の数値を入力して下さい");

			// 入力を受け取る（String型で。intだと012などが誤認されるため）
			String input = scan.nextLine();

			// ユーザーの予想を格納するリスト
			List<Integer> guess = new ArrayList<>();

			// 入力された文字列を1文字ずつ分解
			for (char c : input.toCharArray()) {
				int pieces = Character.getNumericValue(c);  // 変数cの文字を数値に変換
				guess.add(pieces); // guessリストに追加
			}

			// 「eat」と「bite」の数をカウントする変数
			// eat：位置も数字も合ってる数
			// bite：数字は合ってるけど、位置が違う数
			int eat = 0;
			int bite = 0;

			// 各位置の数字を比較して、eat/biteを判定
			for (int i = 0; i < 3; i++) {
				if (guess.get(i).equals(answer.get(i))) {
					eat++;  // 数字も位置も一致するときeatの数を増やす
				} else if (answer.contains(guess.get(i))) {
					bite++;  // 数字は合ってるけど、位置が違うときbiteの数を増やす
				}
			}

			// eatが3なら正解 → ゲーム終了
			if (eat == 3) {
				System.out.println("------ ゲーム終了 ------");
				System.out.println("実施回数は " + turn + "回でした。");
				break;  // ループを抜けて終了

			} else {
				// 正解していない場合、ヒントを表示して続ける
				System.out.println("------ " + turn + "回目 ------");
				System.out.println("eat : " + eat + " bite : " + bite);
				System.out.println();
			}
		}

		// スキャナを閉じる（メモリを節約）
		scan.close();
	}
}

// 【補足】
// List<Integer> 変数 = new ArrayList<>();　は「サイズが自動で増える配列（リスト）」のようなもの
// 　▶︎標準機能のcontains() を使うことで、すでに入ってる数字かどうかをチェックできる
// 　▶︎ランダムに選んだ数字を複数保存するため
