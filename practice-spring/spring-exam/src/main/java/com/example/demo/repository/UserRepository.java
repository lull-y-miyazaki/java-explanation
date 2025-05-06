package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	// クエリメソッド SELECT * FROM users WHERE name LIKE '%name%' ORDER BY id ASC;
	List<User> findByNameContainingOrderByIdAsc(String keyword);

	// クエリメソッド SELECT * FROM users WHERE email = ? AND password = ?;
	User findByEmailAndPassword(String email, String password);

}