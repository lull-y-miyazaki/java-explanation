package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

// ランダム文字列サービスクラス
@Service
public class RandomStringService {

	// ランダムな文字列のリストを生成する処理
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
