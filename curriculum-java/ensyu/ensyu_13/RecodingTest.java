/**
 * 【問題13】
 * 実行結果になるように Recording クラスを完成させなさい。
 * なお、表示されている日付はプログラムを実行した日付が表示されるようにしなさい。
 */

public class RecodingTest {
    public static void main(String[] args) {

        // Recodingクラスのインスタンスを作成
        Recoding movie = new Recoding("ローマの休日", "旧作", "アンネ王女のローマでの滞在を描いた作品");

        // RecodingクラスのshowInfoメソッドを呼び出す
        movie.showInfo();
    }
}

