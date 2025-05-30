# 4.1.3 【練習】パーミッション変更と確認のコマンド実行

次のコマンドが持つ意味を確認しながら実行し、Linuxにおけるファイルのアクセス権（パーミッション）の仕組みを学びます。

---

## ✅ コマンドとその意味

```bash
$ cd ~
```
- ホームディレクトリに移動

```bash
$ cp /etc/fstab .
```
- `/etc/fstab` を現在のディレクトリにコピー（`.` はカレントディレクトリを意味）

```bash
$ ls -l fstab
```
- `fstab` ファイルの詳細情報（所有者、パーミッションなど）を確認

```bash
$ cat fstab
```
- ファイルの内容を表示（読み取り可能である場合）

---

## ✅ パーミッションを変更し、動作を確認する

```bash
$ chmod a-r fstab
```
- 全ユーザー（a=all）から読み取り権限（r）を削除

```bash
$ ls -l fstab
```
- パーミッションの変化を確認（`r` が削除されている）

```bash
$ cat fstab
```
- 読み取り権限がないため、エラーになるはず（例：`Permission denied`）

---

## ✅ パーミッションを明示的に設定する

```bash
$ chmod 666 fstab
```
- 所有者・グループ・その他すべてに「読み取り（4）＋書き込み（2）＝6」の権限を付与

```bash
$ ls -l fstab
```
- `rw-rw-rw-` というパーミッションが表示されることを確認

---

## 🔍 補足：権限の表現

| 数値 | 意味        | 説明                     |
|------|-------------|--------------------------|
| 4    | 読み取り（r） | ファイルの内容を表示可能 |
| 2    | 書き込み（w） | ファイルの編集が可能     |
| 1    | 実行（x）     | 実行可能（スクリプトなど） |
| 0    | 権限なし     | アクセス不可              |

- 例：`chmod 644 file` → 所有者がrw、他はrのみ

---

## ✅ 演習のねらい

- `chmod` の使い方を理解する
- `ls -l` や `cat` との組み合わせで、パーミッションの挙動を体感する
- エラーを通じてパーミッションの重要性を理解する

-----

# 4.1.4 【練習】chownコマンドによる所有者・グループの変更

次のコマンドが持つ意味を確認しながら、ファイルやディレクトリの所有者・グループ変更を体験します。

---

## ✅ コマンド一覧と解説

```bash
# cp /etc/hosts /home/student/
```
- `/etc/hosts` を `/home/student/` にコピー（所有者は root）

```bash
# ls -l /home/student/
```
- ファイルの所有者・グループ・パーミッションを確認

```bash
# chown student /home/student/hosts
```
- 所有者を `student` に変更（グループはそのまま）

```bash
# ls -l /home/student/
```
- 所有者が `student` に変わっていることを確認

```bash
# chown student:student /home/student/hosts
```
- 所有者とグループの両方を `student` に変更

```bash
# ls -l /home/student/
```
- グループ名も `student` に変わっていることを確認

```bash
# chown -R root:root /home/student/
```
- ディレクトリ配下すべての所有者とグループを `root` に変更（再帰的）

```bash
# ls -l /home/student/
```
- 所有者・グループがすべて `root` になっていることを確認

```bash
# chown -R student.student /home/student/
```
- ディレクトリ配下すべてを `student` ユーザー・グループに再度変更

```bash
# ls -l /home/student/
```
- 元に戻っていることを確認

---

## 🔍 補足：chownの書式

- 所有者のみ変更：  
  ```bash
  chown ユーザー名 ファイル名
  ```

- 所有者とグループ両方を変更：  
  ```bash
  chown ユーザー名:グループ名 ファイル名
  ```

- `-R` オプションでディレクトリ内すべてを再帰的に対象にできる

---

## ✅ まとめ

| コマンド                        | 目的                           |
|---------------------------------|--------------------------------|
| `chown student file`           | 所有者の変更                  |
| `chown student:group file`     | 所有者とグループの同時変更    |
| `chown -R user:group dir/`     | ディレクトリ配下すべてを変更  |

-----

# 4.1.4 【練習】su・chgrpコマンドによるユーザー切り替えとグループ変更

この練習では、`su` コマンドでユーザーを切り替えたうえで、ファイルのグループを `chgrp` コマンドで変更する操作を確認します。

---

## ✅ 実行コマンドとその意味

```bash
# su - sato
```
- `sato` ユーザーに切り替える（`-` を付けるとログインシェルとして完全に切り替わる）

```bash
$ cp /etc/hosts .
```
- `hosts` ファイルを現在のディレクトリ（ホームディレクトリ）にコピー

```bash
$ ls -l hosts
```
- コピーしたファイルの所有者とグループを確認  
  例：`-rw-r--r-- 1 sato sato ... hosts`

```bash
$ chgrp eigyo hosts
```
- 所有グループを `eigyo` に変更

```bash
$ ls -l hosts
```
- グループが `eigyo` に変わっているかを確認

---

## 🔍 補足解説

| コマンド      | 説明                                 |
|---------------|--------------------------------------|
| `su - sato`   | ユーザー `sato` に切り替え           |
| `cp`          | ファイルをコピー                     |
| `chgrp`       | 所有グループの変更                   |
| `ls -l`       | パーミッション・所有者・グループの確認 |

- `chgrp` は **グループの所有権だけを変更**したいときに使います。
- 対象のグループに所属していないと変更できません。

---

## ✅ 確認ポイント

- `hosts` の所有者は `sato` のまま
- グループが `sato` → `eigyo` に変更されている

