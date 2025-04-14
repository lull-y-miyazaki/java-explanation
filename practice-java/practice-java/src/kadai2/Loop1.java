// Step1：
// for文を使って、1から10までの数字を繰り返し表示するプログラム

package kadai2;

public class Loop1 {

	public static void main(String[] args) {

        // iは1からスタートして、10まで1ずつ増えていく
        // i <= 10は、iが10以下の間ループを続ける条件
        // for(初期化; 条件; 処理後の処理)
        // i++は、iを1増やす処理。後置なので、iの値を表示した後に1増える
        for (int i = 1; i <= 10; i++) {

            // 現在のiの値を表示
            // (iは1から10までの数字)
            System.out.println(i);
        }
	}

}
