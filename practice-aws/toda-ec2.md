# EC2 + Ansible + Tomcat + Spring Boot WAR 配置手順

## ⭐️ 事前準備（最初の1回だけ）

GitHubからプロジェクトZipを取得し、EC2にアップロードします。

1. GitHubの対象リポジトリページで、右の緑のボタン「Code」>「Download ZIP」をクリック
2. ダウンロードした `reskill-ansible-groupwork-ec2.zip` をデスクトップに保存
3. 以下をローカルPCのターミナルで実行

```bash
scp reskill-ansible-groupwork-ec2.zip ec2-user@<EC2のグローバルIP>:~/
ssh ec2-user@<EC2のグローバルIP>
```

---

## ⭐️ EC2での初期設定（Ansibleを使う準備）

```bash
$ su -
# dnf update                      # パッケージの最新化
# dnf install zip                 # zip解凍コマンドのインストール
# pip --version                   # pipバージョン確認
# pip3 --version                  # pip3の確認
# python3 --version               # Python3の確認
# dnf install python3.12          # Python 3.12インストール
# dnf install python3-pip         # pipのインストール
# pip install ansible             # Ansible本体インストール
# ansible --version               # インストール確認
# unzip reskill-ansible-groupwork-ec2.zip
# cd ansible_reskill
# ansible-playbook -i hosts tomcat-setup.yml
```

> 📌 **Ansible** はJavaやTomcatなどのインストール作業を自動化してくれます。

---

## ⭐️ PostgreSQL の初期化と起動

```bash
# sudo su - postgres
$ initdb -E ja_JP.UTF-8           # データベースの初期化
$ exit                            # postgresユーザーを抜ける
# systemctl start postgresql      # PostgreSQL起動
# systemctl enable postgresql     # 自動起動を有効化
```

> ⚠️ その後、Spring Bootアプリケーションに合わせてDB名・ユーザー名を作成してください。

---

## ⭐️ Tomcat自動起動設定

```bash
# systemctl enable tomcat
```

---

## ⭐️ EclipseでSpring BootアプリからWARファイルを作成

`build.gradle` に以下を追加：

```groovy
plugins {
	id 'war'
	id 'java'
	id 'eclipse'
	id 'org.springframework.boot' version '3.4.1'
	id 'io.spring.dependency-management' version '1.1.7'
}
group = 'com.example'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '21'
ext['tomcat.version'] = '10.1.41'
java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}
repositories {
	mavenCentral()
}
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation("com.codeborne:selenide:7.9.1")
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
	testImplementation("org.junit.jupiter:junit-jupiter:5.12.2")
	providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'
	implementation("org.springframework.boot:spring-boot-gradle-plugin:3.5.0")
}
tasks.named('test') {
	useJUnitPlatform()
}
```

* `Window > ビューの表示 > Gradleタスク`を開く
* 該当プロジェクトの `build > war`タスクを実行
* `build/libs/`配下に `.war`ファイルが作成される

---

## ⭐️ WARファイルをEC2にアップロード

```bash
scp <warファイル名>.war ec2-user@<EC2のIP>:~/
```

---

## ⭐️ Tomcat配置先に移動

```bash
ssh ec2-user@<EC2のIP>
$ su -
# mv <warファイル名>.war /usr/share/tomcat/
```

---

## ⭐️ Tomcatを再起動

```bash
# systemctl restart tomcat
```

WARファイルはTomcatによって自動解凍され、
`http://<EC2のIP>:8080/<プロジェクト名>` でアクセスできます。

---

## 💡 補説

* Ansibleで初期設定を一括完了
* WARファイルの再配置後はTomcatを再起動する
* EC2のセキュリティグループで`8080`番ポートを開放しておく

---

## 📙 参考

* SCP: [https://yasuhira-blog.com/linux-command-scp](https://yasuhira-blog.com/linux-command-scp)
* WARとは: [https://ja.wikipedia.org/wiki/WAR\_(ファイルフォーマット)](https://ja.wikipedia.org/wiki/WAR_%28ファイルフォーマット%29)

```
```
