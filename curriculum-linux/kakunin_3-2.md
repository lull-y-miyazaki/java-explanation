# 3.2 確認問題

この確認問題では、グループとユーザーの作成、属性の設定、サブグループへの追加、設定内容の確認を行います。

---

## ✅ 手順とコマンド

### 1. `webmaster` グループを作成する

```bash
# groupadd webmaster
```

---

### 2. 以下の情報でユーザー `taro` を追加する

| 項目               | 内容                |
|--------------------|---------------------|
| ユーザー名         | taro                |
| ホームディレクトリ | /home/taro_user     |
| プライマリグループ | taro（自動作成）     |
| サブグループ       | webmaster           |

```bash
# useradd -d /home/taro_user -m -g taro -G webmaster taro
```

- `-d`：ホームディレクトリを指定
- `-m`：ホームディレクトリを作成
- `-g`：プライマリグループを指定（taro）
- `-G`：サブグループ（webmaster）を指定

※ `taro` というグループが存在しない場合、先に以下を実行：

```bash
# groupadd taro
```

---

### 3. 既存の `student` ユーザーを `webmaster` サブグループに追加

```bash
# usermod -aG webmaster student
```

- `-aG`：既存のサブグループに追加（上書きしない）

---

### 4. `/etc/passwd` および `/etc/group` ファイルで設定結果を確認

```bash
# grep taro /etc/passwd
# grep taro /etc/group
# grep student /etc/group
```

- `/etc/passwd`：ホームディレクトリ・ログインシェルなどを確認
- `/etc/group`：グループメンバーに `taro` や `student` が追加されていることを確認

---

## 🔍 補足

- `/etc/passwd`：ユーザーの基本情報（ユーザー名、UID、GID、ホームディレクトリなど）を保持
- `/etc/group`：各グループに属するユーザーの一覧を管理
- ユーザーが複数のグループに所属することで、アクセス権限の柔軟な制御が可能になります。