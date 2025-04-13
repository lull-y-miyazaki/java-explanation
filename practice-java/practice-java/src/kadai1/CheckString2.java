package kadai1;

//Step6：英語で取得した色名を
//「switch文」を利用して日本語で出力しなさい

import java.util.Scanner;

public class CheckString2 {

	public static void main(String[] args) {
		// ユーザーからの入力を受け取る準備
        Scanner scan = new Scanner(System.in);

        // prnt()は改行しないで表示する
        System.out.print("色を入力して下さい：");

        // 入力された文字列を変数colorに保存
        // scan.next() は、Javaでユーザーから文字列を入力してもらうときに使うメソッド
        // ただし、スペースで区切られた単語の最初の部分だけを取得する
        String color = scan.next();

        // 入力された色に応じて、対応するメッセージを表示する
        // swich文は、指定した変数の値に応じた処理を実行するための構文
        switch (color) {

            // 入力が "red" の場合
            case "red":
                System.out.println("赤です");
                break; // 処理をここで止めて、switch文を抜ける

            // 入力が "green" の場合
            case "green":
                System.out.println("緑です");
                break;

            // 入力が "blue" の場合
            case "blue":
                System.out.println("青です");
                break;

            // それ以外の色が入力された場合
            default:
                System.out.println("他の色を入力してください");
                break;
        }

        // Scannerを閉じる
        scan.close();
	}

}

// 参考：
//以下、if文の場合（もし聞かれたら丁寧に解説してください）

//eqals()メソッドは、文字列が同じかどうかを比較するために使う
//if (color.equals("red")) {
//			System.out.println("赤です");
//
//else ifは、()の中の条件がtrueのときに{}の中を実行する
//		} else if (color.equals("green")) {
//			System.out.println("緑です");
//
//		} else if (color.equals("blue")) {
//			System.out.println("青です");
//
//		} else {
//			System.out.println("他の色を入力してください");
//		}


//switch文の文法

//switch (値を入れる変数) {
//case 値1:
//    値1と一致したときの処理
//    break;
//
//case 値2:
//    値2と一致したときの処理
//    break;
//
//// 必要に応じてcaseは何個でも追加できる
//
//default:
//    どのcaseにも当てはまらなかった場合の処理（省略も可）
//    break;
//}

