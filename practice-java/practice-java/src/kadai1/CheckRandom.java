package kadai1;

//Randomクラスを使うためのインポート
//→java.utilパッケージにあるRandomクラスを使うためのインポート文
//→java.utilは、Javaの標準ライブラリに含まれるユーティリティクラスをまとめたパッケージ
//→Randomクラスは、ランダムな数値を生成するためのクラス
import java.util.Random;

//Step8：実行するとランダムに「グー」「チョキ」「パー」と出力されるプログラムを作りなさい

public class CheckRandom {

	public static void main(String[] args) {
		// ランダムな数を作るためのオブジェクトを準備
        //Random()クラスについて
        //→ランダム（＝予測できない）な数値を作るための便利なクラス
        Random rand = new Random();

        // 0～2のどれかの整数をランダムで取得（0, 1, 2のいずれか）
        // rand.nextInt(3)は、0から2までの整数をランダムに生成するメソッド
        // 3を指定することで、0, 1, 2のいずれかの整数が得られる
        int dice = rand.nextInt(3);

        // ランダムな数に応じて、じゃんけんの手を表示する
        switch (dice) {

            // diceの値が0の場合
            // caseは、switch文の中で条件分岐を行うためのキーワード
            // つまり、rand.nextInt(3)が0を返した場合
            case 0:
                System.out.println("グー");

                // breakは、switch文の中でcaseを抜けるためのキーワード
                // つまり、次のcaseに進まないようにする
                // これがないと、次のcaseも実行されてしまう
                break;

            // diceの値が1の場合
            // つまり、rand.nextInt(3)が1を返した場合
            case 1:
                System.out.println("チョキ");
                break;

            // diceの値が2の場合
            // つまり、rand.nextInt(3)が2を返した場合
            case 2:
                System.out.println("パー");
                break;
        }
	}

}
