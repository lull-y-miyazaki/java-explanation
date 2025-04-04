package quiz;

/**
 * Step1:for文を使って1～10までの数字を出力しなさい
 * Step2:1～10までの合計値をfor文を利用して計算しなさい
 */


public class quiz5 {

	public static void main(String[] args) {
		
		int sum = 0; // 合計を入れておく変数の定義（初期値は0にしておく）

        // 1から10までの数字を、1ずつ増やしながら繰り返す
        for (int i = 1; i <= 10; i++) {
            System.out.println(i); // 今のiの値（1〜10）を表示する
            sum += i; // sumにiを足していく（例：sum = sum + i と同じ意味）
        }

        // ループが終わった後、合計を表示する
        System.out.println("合計:" + sum); // 1〜10まで足した結果（55）が表示される
	}

}
