package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //このクラスがSpring Bootアプリケーションと表し、必要な設定も自動で行ってくれる
public class SpringChap2HelloApplication {

	public static void main(String[] args) { //Spring版のmainメソッド
		SpringApplication.run(SpringChap2HelloApplication.class, args);

	}

}
