package exam;

/**
 * Employee（社員）クラスを継承してEngineer（エンジニア）クラスを作成しなさい
 */
public class Exam6 {
	public static void main(String[] args) {

		// Engineerオブジェクトの生成（引数1：名前、引数2：年齢、引数3：プログラミング言語）
		// EngineerクラスはEmployeeクラスを継承しています
		// 継承とは、既存のクラスの機能を引き継いで新しいクラスを作ることです
		// 継承することで、コードの再利用性が高まり、拡張性のあるプログラムを作れます
		Engineer e1 = new Engineer("鈴木一郎", 25, "Java");
		
		// Engineerクラスのintroduceメソッドの呼び出し
		// 継承したクラスは、親クラスのメソッドをオーバーライド（上書き）することができます
		// これにより、同じメソッド名でも異なる動作を定義できます
		e1.introduce();
	}
}