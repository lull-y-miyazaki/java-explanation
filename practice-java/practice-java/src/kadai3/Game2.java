// Step9：コンピュータがランダムに抽出した3桁の数字（数字は被らない）を当てるゲームを作成しなさい。
// 3桁のランダムな数字を返すメソッドと、ランダムな数字とキーボードから入力した数字を引数として
// 2つの数字を比較するメソッドの2つのメソッドを作成し、利用しなさい。

// このプログラムは数字当てゲーム（ヒット＆ブロー）を実装しています
package kadai3;

// 必要なクラスをインポート

// 動的な配列を扱うためのクラス
import java.util.ArrayList;

// コレクションを操作するためのユーティリティクラス
import java.util.Collections;

// ユーザーからの入力を受け取るためのクラス
import java.util.Scanner;

public class Game2 {
	public static void main(String[] args) {

		// プレイヤーの試行回数を記録する変数
		int count = 0;

		// キーボード入力を受け取るためのScannerオブジェクトを作成
		Scanner scan = new Scanner(System.in);

		// 3桁のランダムな数字を生成して保存
		String answer = makeAnswer();

		// ゲームのメインループ
		while (true) {

			// プレイヤーに数字の入力を促す
			System.out.print("3桁の数字を入力してください：");

			// プレイヤーの入力を文字列として受け取る
			String input = scan.next();

			// 試行回数を1増やす
			count++;

			// 入力された数字が正解かチェック
			if (checkAnswer(input, answer)) {

				// 正解の場合、試行回数を表示
				System.out.println(count + "回で当たりました！");

				// ゲームループを終了
				break;
			}
		}

		// Scannerオブジェクトを閉じる
		scan.close();
	}

	// プレイヤーの入力が正解かどうかをチェックするメソッド
	private static boolean checkAnswer(String input, String answer) {

		// 結果を格納する変数
		boolean result = false;

		// ヒット数とブロー数を記録する変数
		int hit = 0, blow = 0;

		// 入力された数字と正解を1桁ずつ比較
		for (int i = 0; i < answer.length(); i++) {

			// 入力された数字のi桁目と正解のi桁目を比較
			// もし桁位置と数字が両方一致する場合
			if (input.charAt(i) == answer.charAt(i)) {

				// 数と桁位置の両方が同じ場合（ヒット）
				hit++;

			// もし桁位置は違うが数字が同じ場合
			// 例えば、正解が「123」で入力が「321」の場合、1は桁位置が違うが数字は同じ
			} else if (answer.indexOf(input.charAt(i)) != -1) {

				// 数だけが同じで桁位置が違う場合（ブロー）
				blow++;
			}
		}

		// ヒット数とブロー数を表示
		System.out.println(hit + "ヒット・" + blow + "ブロー");

		// ヒット数が3の場合、全ての桁が正解
		// つまり、3桁の数字が全て一致する場合
		if (hit == answer.length()) {

			// falseをtrueに反転
			// つまり、正解した場合はtrueを返す
			result = !result;
		}

		// 結果を返す
		// つまり、正解した場合はtrueを返し、そうでない場合はfalseを返す
		return result;
	}

	// 0から9までの重複しないランダムな数値を3つ生成するメソッド
	private static String makeAnswer() {

		// 生成した数字を格納する文字列
		String answer = "";

		// ArrayListは可変長の配列を扱うためのクラス
		// ここではInteger型のリストを作成
		ArrayList<Integer> answerList = new ArrayList<Integer>();

		// 0から9までの数字をリストに追加
		for (int i = 0; i < 10; i++) {

			// addはリストに要素を追加するメソッド
			answerList.add(i);
		}

		// リストの要素の順番をランダムに入れ替える
		Collections.shuffle(answerList);

		// リストの先頭の3つの要素を文字列として連結
		for (int i = 0; i < 3; i++) {

			// getはリストの指定した位置の要素を取得するメソッド
			// 取得した要素を文字列に変換して連結
			// +=は文字列を連結する演算子
			answer += answerList.get(i);
		}

		// 生成した3桁の数字を返す
		return answer;
	}
}
