/*
問題３:
*以下の Person3 クラス（作成済み）を、社員番号（String）とペアにして、Map に入れて管理してください。
*/

public class Person3 {

    // フィールド（属性）
    // private修飾子を使って、クラスの外から直接アクセスできないようにする
    // これにより、カプセル化が実現され、データの隠蔽が行われる
    private String name;

    // GetterとSetterメソッド
    // Getterメソッドは、nameフィールドの値を取得するためのメソッド
    public String getName() {
        return name;
    }

    // Setterメソッドは、nameフィールドの値を設定するためのメソッド
    public void setName(String name) {
        this.name = name;
    }

    // コンストラクタ
    // 引数を持つコンストラクタで、nameフィールドを初期化する
    public Person3(String name) {
        this.name = name;
    }

    // メソッド
    public void introduce() {
        System.out.println("私は" + name + "と申します。");
    }
}