/**
 * Step6：ランダム文字列の生成する個数を画面から入力できるようにしなさい
 * Step7：「英字を含める」チェックボックスを追加しなさい
 */

package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

// ランダム文字列サービスクラス
// Serviceクラスは、ビジネスロジック(独立した処理を行うクラス)を記述するクラス
@Service
public class RandomStringService {

	// ランダムな文字列のリストを生成する処理
	// 引数：charLength(文字列の長さ)、withNumber(数字を含むか)、withAlphabet(英字を含むか)、cureateCount(生成する個数)
	public List<String> generate(int charLength, boolean withNumber, boolean withAlphabet, int cureateCount) {

		// 生成した文字列を保存するList
		List<String> list = new ArrayList<>();

		// 生成する個数分繰り返す
		for (int i = 0; i < cureateCount; i++) {
			if (withNumber && withAlphabet) {

				// 英数字を含む文字列をListに追加
				list.add(RandomStringUtils.randomAlphanumeric(charLength));
			} else if (withNumber) {

				// 数字のみの文字列をListに追加
				list.add(RandomStringUtils.randomNumeric(charLength));
			} else if (withAlphabet) {

				// 英字のみの文字列をListに追加
				list.add(RandomStringUtils.randomAlphabetic(charLength));

			} // 英字、数字のチェックボックスがどちらもチェックされていない場合は生成しない
		}
		return list;
	}
}

/**
 * 補足：
 * - RandomStringUtilsクラスは、Apache Commons Langライブラリに含まれるユーティリティクラスで、ランダムな文字列を生成するためのメソッドを提供しています。
 * - randomAlphanumericメソッドは、指定された長さのランダムな英数字の文字列を生成します。
 * - randomNumericメソッドは、指定された長さのランダムな数字の文字列を生成します。
 * - randomAlphabeticメソッドは、指定された長さのランダムな英字の文字列を生成します。
*/