package exam;

/**
 * Employee（社員）クラスを作成しなさい
 * ・フィールドには名前（name）と年齢（age）をもつ（5点）
 * ・フィールドはカプセル化しクラス外からの直接アクセスを禁止する（2点）
 * ・フィールドの値を引数として受け取り初期化するコンストラクタを作成する（5点）
 * ・フィールドに対してゲッター、セッターを作成する（3点）
 * ・フィールドに保持された情報を出力するintroduce()メソッドを作成する（5点）
 * 　出力例「田中太郎さんは20歳です」
 */
public class Employee {
	// フィールド
	private String name; // 名前（String）
	private int age; // 年齢（int）

	// コンストラクタ
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// ゲッター、セッター
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// 情報出力用メソッド（インスタンスメソッド）
	public void introduce() {
		System.out.println(name + "さんは" + age + "歳です");
	}
}
