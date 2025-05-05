/**
 * 【問題11】予め与えられた2つの配列ary1とary2をマージするプログラムを作成してください
 * ※aryの中身は好きに入れてOK
 *
 *  ■実行イメージ
 * ary1とary2のマージ結果
 * 2 9 12 15 15 19 20 21 22 30 32 40 44 50 53 64 90 93
 * ※マージとは:配列を結合すること
 */

import java.util.Arrays;

public class Merge {
	public static void main(String[] args) {

		// 予め与えられた配列
		int[] ary1 = {2, 9, 12, 15, 19, 21, 30, 40, 50, 64};
		int[] ary2 = {15, 20, 22, 32, 44, 53, 90, 93};

		// ary1とary2とは別の配列を準備して、ary1とary2を結合させるメソッド※を使う　※自分で作る、後述してる
		int[] mergedArray = mergeSortedArrays(ary1, ary2);

		// 結果を出力
		// Arrays.toString()メソッドは配列の中身を人間が読めるように出力してくれるメソッド
		System.out.println("ary1 と ary2のマージの結果");
		System.out.print(Arrays.toString(mergedArray));
	}

	// 結合させるためのメソッドを作成する（mergeSortedArrays）
	// 順番として・・①結合したい配列aryの長さを取得、②新しい配列に結合後の長さを付与、
	// ③それぞれの配列aryから中身をコピーして、新しい配列に貼り付け、④新しい配列の中身を昇順にする
	public static int[] mergeSortedArrays(int[] ary1, int[] ary2) {

		//　①それぞれの配列の長さを取得
		int len1 = ary1.length;
		int len2 = ary2.length;

		// ②新しい配列を作成
		// ここでは上記2つの配列の長さの合計のみ取得し、長さを指定する　※int[]配列は長さを指定してあげないと中に要素が入らないためエラー
		int[] mergedArray = new int[len1 + len2];

		// ③それぞれの配列の中身をコピーして、新しい配列に貼り付ける（コピー専用メソッドSystem.arraycopy()）
		// System.arraycopy(コピー元, コピー元の開始位置, コピー先, コピー先の開始位置, コピーする要素数);
		System.arraycopy(ary1, 0, mergedArray, 0, len1);
		System.arraycopy(ary2, 0, mergedArray, len1, len2);

		// Arrays.sort()メソッドで、引数の中身を昇順に並び替える
		Arrays.sort(mergedArray);

		return mergedArray;
	}

}

// 【やり方Part2】Listを使う！
// import java.util.Arrays;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Collection;
//
// public class Merge{
//   public static void main([String] arg){
//
// <<元の配列　※（補足1）>>
//  Integer[] ary1 = {12, 15, 30, 40, 44, 64, 90};
//  Integer[] ary2 = {2, 9, 15, 19, 20, 21, 22, 32, 50, 53, 93};
//
// <<配列をリストに変換>>
// List<Integer> list1 = new ArrayList<>(Arrays.asList(ary1));
// List<Integer> list2 = new ArrayList<>(Arrays.asList(ary2));
//
// <<リストをマージ>>
// list1.addAll(list2);
//
// <<ソート>>
// Collections.sort(list1);
//
// <<結果表示>>
// System.out.println("ary1とary2のマージ結果");
// System.out.println(list1);
//   }
// }

// 【補足1】int[]とInteger[]の違い
// int[] ary1 = {1, 2, 3}; 　　 ：intの配列ごと1つの要素とする　→　
// Integer[] ary1 = {1, 2, 3};　：1、2、3というそれぞれが要素になる
