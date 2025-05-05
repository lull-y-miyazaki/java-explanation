/**
 * 【問題17】問16で作成したJudgeGameに下記、仕様追加を反映し作成してください。
 * ■JudgeGame 追加仕様
 * ①Game終了後は「retry? y or n?」を表示し対処
 * ②最大5回まで繰り返し可能とし、終了後は何勝何敗か表示
 * ③Game開始後、2秒以内に入力がない場合は「You Lose!」とする

■ 実行イメージ
YOU：8 ENEMY：3
a [attack] OR d [Defense] :a
you lose!
Time Over!
retry? y or n :
 */

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService; // 複数のタスクを「スレッド」で実行する仕組み
import java.util.concurrent.Executors; // ExecutorServiceを動かすため
import java.util.concurrent.Future; // 別スレッドで実行したタスクの結果をあとから取り出すための箱
import java.util.concurrent.TimeUnit; // 時間の単位を表すクラス
import java.util.concurrent.TimeoutException; // 指定した時間内に終わらなかった時に発生する例外

public class JudgeGame2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 勝ち、負け、プレイ回数の初期化
		int wins = 0; // 勝った数
		int losses = 0; // 負けた数
		int playCount = 0; // プレイ回数

		// プレイ回数は最大5回まで
		final int maxGames = 5;

		// プレイ回数が5回未満の間繰り返す
		while (playCount < maxGames) {

			// プレイ回数を1回増やす
			playCount++;

			// プレイヤーと敵の数値をランダムに決定（1〜9）
			Random rand = new Random();
			int you = rand.nextInt(9) +1;
			int enemy = rand.nextInt(9) +1;

			// プレイヤーと敵の値と、ユーザーに攻防の入力を行ってもらうための表示
			System.out.println("YOU：" + you + "　ENEMY：" + enemy);
			System.out.print("a [attack] OR d [Defense] :");

			// 入力専用のスレッドを作成
			ExecutorService executor = Executors.newSingleThreadExecutor();

			// 入力を読み取る処理を別スレッドで実行(ScannerではなくSystem.inを直接使う
			// Future<String>：結果が後で返ってくる（＝将来の値）ことを表す。
			// executor.submit(...)：スレッドプール（ExecutorService）にタスクを渡して非同期に実行。
			// () -> { ... }：ラムダ式。Callable<String>（戻り値ありの処理）として渡している。
			Future<String> future = executor.submit(() -> {
                try {

                    // 入力をバイト（文字コード）で受け取り、文字列に変換
                    byte[] buffer = new byte[100];
                    int read = System.in.read(buffer);

					// 入力から余分な空白や改行を取り除く
                    return new String(buffer, 0, read).trim();

                } catch (Exception e) {
                    return null; // エラーが起きた場合は null を返す
                }
            });

			String input = null;
			try {
				// 2秒以内に入力があるかチェック
				input = future.get(2, TimeUnit.SECONDS);

			} catch (TimeoutException e) {

				// 2秒以内に入力がなかったときの処理
				System.out.println("you lose!");
				System.out.println("Time Over!");
				losses++; // 負けた数をカウント

				// スレッドを強制終了
				executor.shutdownNow();

				// リトライするかどうかのメソッド（下記に中身は記載あり）
				// retryがfalseだったらゲーム終了
				if (!retry(scanner))
					break; // ループ終了
				else
					continue; // 次のループへ

			} catch (Exception e) {

				// 予期しないエラーが発生した場合の処理
				System.out.println("エラーが発生しました。");
				executor.shutdownNow(); // スレッドを強制終了
				break; // ループ終了
			}

			// 入力が成功しても終了
			executor.shutdown();

			// 入力に基づいて勝敗を判定する仕組み
			// 初期値（負けた状態）
			boolean youWin = false;

			if (input.equals("a")) {

				// 攻撃の場合：自分の値が相手より大きければ勝ち
				youWin = you > enemy;

			} else if (input.equals("d")) {

				// 防御の場合：相手の値が自分以上なら勝ち
				youWin = enemy <= you;

			} else {

				// 入力が正しくない場合は無効（負け扱い）
				System.out.println("Invalid input! you lose!");
				losses++;
				if (!retry(scanner))
					break;
				else
					continue;
			}

			// 結果を表示し、勝ち負けの数を記録
			if (youWin) {
				System.out.println("you win!");
				wins++;
			} else {
				System.out.println("you lose!");
				losses++;
			}

			// リトライの確認
			if (!retry(scanner))
				break;
		}

		// 最終結果表示
		System.out.println("=== Result ===");
		System.out.println("Wins: " + wins + " Losses: " + losses);
		scanner.close();
	}

	// リトライするかどうかの確認メソッド
	private static boolean retry(Scanner scanner) {
		System.out.print("retry? y or n :");
		String again = scanner.nextLine();
		return again.equalsIgnoreCase("y");
	}

}
