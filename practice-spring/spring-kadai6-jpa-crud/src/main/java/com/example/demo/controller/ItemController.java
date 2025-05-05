package com.example.demo.controller;

//リストインターフェースをインポート
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;

@Controller //コントローラークラスであることを示すアノテーション
public class ItemController {
	@Autowired //ItemRepositoryをインスタンスかしてくれる（クラス内のNew演算子の記述不要、インスタンス化を一回で済ますことが可能）
	ItemRepository itemRepository;

	//①商品一覧表示
	@GetMapping("/items") //Getリクエストを処理する。引数はパス。
	//コントローラーからビューにデータを渡すため、引数にModel追加。
	public String index(Model model) {
		//JpaRepositoryのfindAll()メソッドでitemsテーブルの全てのレコードを取得し、変数itemListに格納
		List<Item> itemList = itemRepository.findAll();
		//ModelオブジェクトのaddAttributeメソッドでthymeleafにデーターを渡す
		//itemsという名前で変数itemListの値をビューに渡せるようにする
		model.addAttribute("items", itemList);

		//itemsという名前のビューを表示する
		return "items";
	}

	//②新規登録画面表示
	@GetMapping("/items/add")
	public String create() {
		//addItemというビューを返す
		return "addItem";
	}

	//新規登録画面
	@PostMapping("/items/add")
	public String Store(
			//パラメーターで送られてきたフォームに入力された値を受け取る
			@RequestParam(name = "categoryId", defaultValue = "") Integer categoryId,
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "price", defaultValue = "") Integer price) {

		//Itemオブジェクトの生成
		Item items = new Item(categoryId, name, price);
		//itemsテーブルに追加
		itemRepository.save(items);

		//ビューitemsにGetでリクエストし直す
		return "redirect:/items";
	}

	//③更新画面
	@GetMapping("/items/{id}/edit")
	public String edit(
			@PathVariable("id") Integer id, //パラメータを取得
			Model model) {
		//itemsテーブルから引数のidと一致する値があるか検索し、get()で値を取得
		Item item = itemRepository.findById(id).get();
		//itemsという名前で変数itemの値をビューに渡せるようにする
		model.addAttribute("items", item);
		//editItemとういビューを表示する
		return "editItem";
	}

	//④更新処理
	@PostMapping("/items/{id}/edit")
	public String update(
			//@PathVariableでURL のパスの一部からパスを取得(変更するレコードのidを取得)
			@PathVariable("id") Integer id,
			//@RequestParamURL のクエリパラメータからパスを取得(フォームから送信された値を取得)
			@RequestParam(name = "categoryId") Integer categoryId,
			@RequestParam(name = "name") String name,
			@RequestParam(name = "price") Integer price,
			Model model) {
		//Itemオブジェクトの生成し、引数の値でコンストラクタで初期化
		Item items = new Item(id, categoryId, name, price);
		//save()メソッドitemsテーブルに追加
		itemRepository.save(items);
		//商品一覧画面にリダイレクト
		return "redirect:/items";
	}

	//⑤削除機能
	@PostMapping("/items/{id}/delete")
	public String delete(
			//@PathVariableでURL のパスの一部からパスを取得(変更するレコードのidを取得)
			@PathVariable("id") Integer id) {
		//deleteById()メソッドで指定のidのレコードを削除
		itemRepository.deleteById(id);
		//商品一覧画面にリダイレクト
		return "redirect:/items";
	}

}
