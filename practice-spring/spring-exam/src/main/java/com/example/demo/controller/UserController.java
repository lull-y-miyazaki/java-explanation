package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	// 一覧画面の表示
	@GetMapping("/users")
	public String index(
			@RequestParam(required = false) String keyword,
			Model model) {

		List<User> userList;

		// キーワードがない場合は全て表示させる
		if (keyword == null || keyword.isEmpty()) {
			userList = userRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
		} else { // 検索処理内容
			userList = userRepository.findByNameContainingOrderByIdAsc(keyword);
			// 検索後のキーワードの表示用
			model.addAttribute("keyword", keyword);
		}

		model.addAttribute("users", userList);

		return "users";
	}

	// 新規登録画面の表示
	@GetMapping("/users/add")
	public String create() {

		return "addUser";
	}

	// 新規登録の処理内容
	@PostMapping("/users/add")
	public String store(
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam String password,
			Model model) {

		User user = new User(name, email, password);
		userRepository.save(user);

		return "redirect:/users";
	}

	// 更新画面の表示
	@GetMapping("/users/{id}/edit")
	public String edit(
			@PathVariable Integer id,
			Model model) {

		User user = userRepository.findById(id).get();
		model.addAttribute("user", user);

		return "editUser";
	}

	// 更新の処理内容
	@PostMapping("/users/{id}/edit")
	public String update(
			@PathVariable Integer id,
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam String password,
			Model model) {

		User user = new User(id, name, email, password);
		userRepository.save(user);

		return "redirect:/users";
	}

	// 削除の処理内容
	@PostMapping("/users/{id}/delete")
	public String delete(
			@PathVariable Integer id,
			Model model) {

		userRepository.deleteById(id);

		return "redirect:/users";
	}

}
