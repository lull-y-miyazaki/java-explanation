# ✅ Windowsユーザー向け  
# AWS EC2 で Spring Boot アプリをデプロイする手順（Java + PostgreSQL）

---

## 🔰 事前準備（初回のみ）

### 1. AWSアカウント作成とEC2インスタンスの立ち上げ

- AWS アカウントを作成  
- IAMユーザー（管理者権限）を作成  
- EC2 インスタンスを作成  
  - OS：**Ubuntu (無料枠)**  
  - キーペア：例 `spring-ec2` を作成（後でSSH接続に使用）  
  - セキュリティグループ：デフォルトでOK（あとでポートを追加）

> 🔍 EC2 はアプリを動かす仮想サーバー。Ubuntu は軽量で Java アプリに適しています。

---

## 🔐 2. SSH接続の準備（Windows）

### 🔸 `.pem` ファイルの保存と権限変更（Git Bash）

```bash
mv /c/Users/yourname/Downloads/spring-ec2.pem ~/.ssh/
chmod 400 ~/.ssh/spring-ec2.pem
```

> 🔍 `.pem` ファイルは鍵の役割。`chmod 400` はセキュリティ上のパーミッション設定です。

### 🔸 SSH接続

```bash
ssh -i ~/.ssh/spring-ec2.pem ubuntu@[EC2のパブリックIP]
```

> 🔍 EC2 にリモートログイン。以後このターミナル上で操作していきます。

---

## ☕ Java 21 のインストール（EC2内）

```bash
sudo apt update && sudo apt upgrade -y
sudo apt install -y openjdk-21-jdk
java --version
```

> 🔍 Spring Boot 3.x は Java 17 以上が必要。Java 21 は安定かつ最新のLTSです。

---

## 🐘 PostgreSQL のインストールと設定

```bash
sudo apt install -y postgresql postgresql-contrib
sudo systemctl enable --now postgresql
```

> 🔍 データベース(PostgreSQL)をインストールし、自動起動設定します。

### 🔸 PostgreSQLにログインしてDB作成

```bash
sudo -i -u postgres psql

DROP USER IF EXISTS student;
DROP DATABASE IF EXISTS my_spring_ec;
CREATE USER student WITH PASSWORD 'himitu';
CREATE DATABASE my_spring_ec OWNER student ENCODING 'UTF8';
\l  -- DB一覧の確認
\q  -- 終了
```

> 🔍 アプリから接続するためのユーザー・データベースを作成します。

---

## 🛠 プロジェクトのクローン（GitHub）

### 🔸 GitインストールとSSH鍵設定

```bash
sudo apt install -y git
ssh-keygen -t ed25519
cat ~/.ssh/id_ed25519.pub
```

➡ GitHub → Settings → SSH and GPG keys → 公開鍵を登録

> 🔍 GitHub に鍵を登録して、パスワードなしでセキュアに clone できるようにします。

```bash
eval "$(ssh-agent -s)"
ssh-add ~/.ssh/id_ed25519
```

### 🔸 プロジェクトをクローン

```bash
git clone git@github.com:yourname/yourproject.git
cd yourproject
```

> 🔍 GitHub の Spring Boot プロジェクトを EC2 にコピーします。

---

## ⚙️ Spring Boot アプリのビルド・起動

```bash
chmod +x gradlew
./gradlew clean build -x test
cd build/libs
java -jar my-spring-ec-0.0.1-SNAPSHOT.jar
```

- `chmod +x gradlew`: Gradleのビルドツールを実行可能に  
- `clean build`: 前回の成果物削除＋JARファイル生成  
- `-x test`: テストをスキップして高速ビルド  
- `java -jar`: アプリを起動

> 🔍 アプリをビルドして `.jar` ファイルから実行します。

---

## 🌐 セキュリティグループのポート解放（AWS管理画面）

- HTTP (80)： `0.0.0.0/0`
- カスタム TCP (8080)： `0.0.0.0/0`

> 🔍 外部からアプリにアクセスできるようにポートを開放します。

---

## 🌍 アプリにアクセス

```
http://[EC2のパブリックIP]:8080
```

> 🔍 Webブラウザでアクセスして、Spring Boot アプリが表示されれば成功です。

---

## 🔧 トラブルシューティング

| 症状                     | 対処法                                                   |
|--------------------------|------------------------------------------------------------|
| SSH接続できない          | `.pem` のパーミッション（chmod 400）とファイルパス確認     |
| ポートが開かない         | セキュリティグループに `8080` を開放済みか確認              |
| git clone できない       | GitHubにSSH鍵が登録済みか、ssh-add 済みか確認               |
| Java実行失敗             | Javaバージョンや `.jar` ファイルのパスを確認                |

---

## 📌 補足ポイント

- EC2を再起動するとアプリが止まる → `screen` や `nohup` で常駐化可能
- Java 21 を使用しているため Spring Boot 3.x に対応
- ビルド失敗時は `build.gradle` の依存関係を確認

---
