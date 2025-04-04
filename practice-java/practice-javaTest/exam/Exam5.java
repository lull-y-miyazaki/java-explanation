package exam;

/**
 * Employee（社員）クラスを作成しなさい
 */
public class Exam5 {
	public static void main(String[] args) {

		// Employeeオブジェクトの生成（引数1：名前、引数2：年齢）
		Employee e1 = new Employee("田中太郎", 20);

		// Employeeクラスのintroduceメソッドの呼び出し
		e1.introduce();
	}
}