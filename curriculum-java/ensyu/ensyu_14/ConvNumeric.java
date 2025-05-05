/**
 * 【問題14】
 * 実行結果になるように漢数字を数値に変換するプログラムを作成してください。
 *
 * ■実行イメージ
 * 任意の漢数字を入力してEnterを押してください
 * 三千七百十二
 * 3712
 */

// 漢数字→数字や単位→数値というキーと値のセットでデータを保存できるようにHashMapを使う
import java.util.HashMap;
// HashMap を使うために必要
import java.util.Map;
// ユーザーからの入力を受け取る
import java.util.Scanner;

public class ConvNumeric {

	// 漢数字の一から九や零を数字に変換するためのMap
	// 変数の再代入を防ぐためにfinalメソッド
	private static final Map<Character, Integer> kanjiToNum = new HashMap<>();

	// 十、百、千、万、億などの単位を数値として扱うためのマップ
	private static final Map<Character, Integer> unitToNum = new HashMap<>();

	// staticブロック：クラスが読み込まれた時に最初に一回だけ実行されるブロック ≠コンストラクタ
	static {

		// 漢数字 → 数字
		kanjiToNum.put('零', 0);
		kanjiToNum.put('一', 1);
		kanjiToNum.put('二', 2);
		kanjiToNum.put('三', 3);
		kanjiToNum.put('四', 4);
		kanjiToNum.put('五', 5);
		kanjiToNum.put('六', 6);
		kanjiToNum.put('七', 7);
		kanjiToNum.put('八', 8);
		kanjiToNum.put('九', 9);

		// 単位（掛け算になる部分）→ 数値
		unitToNum.put('十', 10);
		unitToNum.put('百', 100);
		unitToNum.put('千', 1000);
		unitToNum.put('万', 10000);
		// unitToNum.put('億', 100000000);
	}

	// メインメソッド
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("任意の漢数字を入力して Enter を押してください");

		// ユーザーからの入力を受け取り
		String input = scanner.nextLine();

		// 漢数字を数値に変換する
		int number = convertKanjiToNumber(input);

		// 結果を表示
		System.out.println(number);
	}

	// 漢数字の文字列を数値（int）に変換するメソッド
	public static int convertKanjiToNumber(String kanji) {

		// 初期化
		int result = 0; // 最終的な合計（これがreturnされる）
		int section = 0; // 「万」のときに使用
		int num = 0; // 個々の漢数字を一時的に保存するための変数（例：「三」なら3）

		for (int i = 0; i < kanji.length(); i++) {

			// 入力された漢数字の文字列を1文字ずつ取り出して調べる
			char c = kanji.charAt(i);

			// cが漢数字（一〜九）の場合
			if (kanjiToNum.containsKey(c)) {

				// numに数字を代入（例：「三」だったら「3」）
				num = kanjiToNum.get(c);

				// cが単位（十、百、千、万など）の場合
			} else if (unitToNum.containsKey(c)) {

				// unitNumに代入（例：「千」だったら「1000」）
				int unitNum = unitToNum.get(c);

				if (unitNum >= 10000) {

					section = (section + num) * unitNum;
					result += section;
					section = 0;

				} else {
					// 「十」「百」「千」など
					// 「三十」→ 3 * 10、「百」だけ→ 1 * 100
					section += (num == 0 ? 1 : num) * unitNum;
				}

				num = 0; // 次の数字のためにリセット
			}
		}

		// 最後に残っている数字やsectionを加える
		result += section + num;
		return result;
	}

}