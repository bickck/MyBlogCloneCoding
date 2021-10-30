package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.blog.model.User;

//DAO
//자동으로 bean 등록이 된다.
// @Repository // 생략가능
public interface UserRepository extends JpaRepository<User, Integer> {

	

}
//JPA nameing 전략
	// SELETE * FROM user WHERE uesrname =? AND password =?;

	/*
	 * User findByUsernameAndPassword(String username , String password);
	 * 
	 * 
	 * // 이렇게도 만들 수 있음
	 * 
	 * @Query(value = "SELETE * FROM user WHERE uesrname =? AND password =?",
	 * nativeQuery = true) User login(String username, String password);
	 * 
	 * 
	 * User findByUserNameAndPassword(String username, String password);
	 * 
	 */
