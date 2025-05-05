/**
 * 【問題１】
 * 文字列配列「"apple", "orange", "melon", "peach", "lemon", "grape"」の中に、キーボードから入力した文字列が含まれているかどうかを調べるプログラムを作成してください。
 * なお、文字列は完全一致のみ可とします。
 * 条件：Stringクラスのメソッド使用可
 */

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        // String型の文字列の配列を作成
        String[] arr = { "apple", "orenge", "melon", "peach", "lemon", "grape" };

        // Scannerクラスは、ユーザーからの入力を受け取るためのクラス
        Scanner scan = new Scanner(System.in);

        // 検索結果を格納する変数
        // ここでは、検索結果が見つかったかどうかを示すために使用
        // 変数の初期値はfalse
        boolean search = false;

        // while文を使って、検索が見つかるまで繰り返す
        // (!searchは、検索結果が見つからない限りtrue
        while (!search) {

            // ユーザーに入力を促す
            System.out.println("検索文字列を入力してください");

            // nextLine()メソッドを使って、ユーザーからの入力を受け取る
            // 文字列を入力するためのメソッド
            String str = scan.nextLine();

            // 検索処理
            // 拡張for文を使って、配列のすべての要素に対して順番に処理
            for (String item : arr) {

                // equals()メソッドを使って、配列の要素とユーザーが入力した文字列を比較
                if (item.equals(str)) {

                    // 検索結果が見つかった場合、searchをtrueに設定
                    search = true;
                    break;
                }
            }

            // 結果の表示
            if (search) {
                System.out.println("検索文字列がみつかりました");
            } else {
                System.out.println("検索文字列がみつかりませんでした \n");
            }
        }

        // Scannerクラスを閉じる
        scan.close();
    }
}
