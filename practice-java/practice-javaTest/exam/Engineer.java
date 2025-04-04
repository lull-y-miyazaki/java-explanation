package exam;

/**
 * Engineer（エンジニア）クラスを作成しなさい
 * ・Employee(社員）クラスを継承する（2点）
 * ・フィールドは技術（skill）をもち、カプセル化しクラス外からの直接アクセスを禁止する（2点）
 * ・名前、年齢、技術の値を引数として受け取り、フィールドを初期化するコンストラクタを作成する（2点）
 * ・フィールドに対してゲッター、セッターを作成する（2点）
 * ・フィールドに保持された情報を出力するintroduce()メソッドを作成する（2点）
 * 　出力例：
 * 　　田中太郎さんは20歳です
 * 　　ネットワークエンジニアです
 */
public class Engineer extends Employee {

	// フィールド
	private String skill;

	// コンストラクタ
	public Engineer(String name, int age, String skill) {
		super(name, age);
		this.skill = skill;
	}

	// ゲッター、セッター
	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	// 情報出力メソッド
	public void introduce() {
		super.introduce();
		System.out.println(skill + "エンジニアです");
	}
}
