package kadai1;

import java.util.Scanner;

//Step7：名前を取得し20文字より多い場合はエラーメッセージを出力し、
//20 文字以内ならば「ようこそ」と出力しなさい。

public class CheckString3 {

	public static void main(String[] args) {
        // Scannerクラスを使って、ユーザーからの入力を受け取るための準備
        // Scannerは、キーボードからの入力を簡単に扱うためのクラス
        // これを使うことで、ユーザーが入力したデータをプログラムで扱えるようになる
		// ユーザーからの入力を受け取る準備
        Scanner scan = new Scanner(System.in);

        // 名前の入力を促すメッセージを表示
        System.out.print("名前：");

        // 入力された名前（文字列）を取得して変数nameに保存
        // scan.next() は、Javaでユーザーから文字列を入力してもらうときに使うメソッド
        // ただし、スペースで区切られた単語の最初の部分だけを取得する
        // 例えば、「山田 太郎」と入力した場合、nameには「山田」だけが入る
        String name = scan.next();

        // 入力された名前が20文字より長い場合はエラーメッセージを表示
        // length()メソッドは、文字列の長さ（文字数）を調べるためのメソッド
        // name.length() は、nameという文字列の長さを取得する
        if (name.length() > 20) {
            System.out.println("エラー：20文字以内で入力してください");
        } else {
            // 20文字以内なら、あいさつメッセージを表示
            System.out.println("ようこそ" + name + "さん");
        }

        // Scannerを閉じて、入力を終了（後片付け）
        scan.close();
	}

}

// 参考：
//length():文字列の長さ（文字数）を調べるためのメソッド
