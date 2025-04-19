/*
Lesson14 問題４:
*前章で作成した HandyPhone4 クラスを継承して、SmartPhone クラスを定義してください。
*SmartPhone クラスは、無線通信が可能です。
*また、Audio インターフェースを実装していて、音楽を聴くことができます。
*Audio インターフェースと HandyPhone4 クラスは作成済みです。
*/

// HandyPhone4を親クラスとして継承
// extendsキーワードを使って親クラスを指定する
// RemotableとAudioをインターフェースとして実装
// implementsキーワードを使ってインターフェースを指定する
public class Lesson14_4_SmartPhone extends HandyPhone4 implements Lesson14_3_Remotable, Audio {

	// HandyPhone4のコンストラクタを呼び出す
	public Lesson14_4_SmartPhone(String no, String mailAddress) {
		super(no, mailAddress);
	}

	// Audioインターフェースのplayメソッドをオーバーライド
	public void play() {
		System.out.println("スマートフォンで音楽を再生しました。");
	}

	// Audioインターフェースのstopメソッドをオーバーライド
	public void stop() {
		System.out.println("スマートフォンの音楽を停止しました。");
	}

	// Remotableインターフェースのuploadメソッドをオーバーライド
	public void upload() {
		System.out.println("スマートフォンでデータをアップロードしました。");
	}

	// Remotableインターフェースのdownloadメソッドをオーバーライド
	public void download() {
		System.out.println("スマートフォンでデータをダウンロードしました。");
	}
}

// 補足：

// インタフェースとは
	// インタフェースは、クラスの設計図(規格)のようなもので、クラスが実装すべきメソッドの名前や引数、戻り値の型を定義するもの
	// インタフェースは、クラスがどのような機能を持つべきかを示すために使用される
	// インタフェースは、複数のクラスで共通の機能を持たせるために利用される
	// インタフェースは、クラスが実装することを強制するため、インタフェースを実装したクラスは、インタフェースで定義されたメソッドを必ず実装しなければならない


// 抽象クラスとは
	// インスタンス化できないクラスのこと
	// 他のクラスに継承されることを目的としており、共通処理をまとめることができる
	// 親クラス(スーパークラス)は1つのみ

	// 抽象メソッドを持つことができる
	// 抽象メソッドは、実装を持たないメソッドのこと
	// 抽象メソッドは、サブクラスで実装する必要がある

// ポリモーフィズムとは
	// 「同じメソッド名でも、呼び出される内容がクラスによって違う」仕組み
	// 具体的には、親クラスのメソッドをサブクラスでオーバーライドすることで、同じメソッド名でも異なる処理を実行できるようになる
