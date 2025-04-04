package exam;

import java.util.ArrayList;
import java.util.List;

/**
 * Employee（社員）クラスとEmgineer（エンジニア）クラスの
 * オブジェクトをListに複数追加し全て出力しなさい
 */
public class Exam7 {
	public static void main(String[] args) {

		// Employeeクラスのオブジェクトを保存できるListを生成
		// Listは、複数のオブジェクトを順序付けて保存できるインターフェースです
		// ArrayListは、Listインターフェースを実装したクラスで、動的にサイズが変わる配列です
		// <Employee>はジェネリクスで、Listに保存できるオブジェクトの型を指定します
		List<Employee> list = new ArrayList<>();

		// 「田中太郎、20歳」のEmployeeオブジェクトを生成しListに追加する
		// add()メソッドで、Listにオブジェクトを追加します
		list.add(new Employee("田中太郎", 20));

		// 「鈴木一郎、25歳、Java」のEngineerオブジェクトを生成しListに追加する
		// EngineerはEmployeeを継承しているので、Employee型のListに追加できます
		// これはポリモーフィズム（多態性）の例です
		list.add(new Engineer("鈴木一郎", 25, "Java"));

		// 「佐藤花子、30歳」のEmployeeオブジェクトを生成しListに追加する
		list.add(new Employee("佐藤花子", 30));

		// 拡張for文と、introduce()メソッドを利用して各オブジェクトの情報を全て出力
		for (Employee e : list) {
			e.introduce();
		}
	}
}