package com.cos.blog.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;

	@PostMapping("/auto/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("UserApiController: sava call ");

		user.setRole(RoleType.USER);
		userService.register(user);
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
		// 자바 오브젝트를 JSON으로 변환해서 반환
	}
	/*
	 * @PostMapping("/api/user/login") public ResponseDto<Integer>
	 * login(@RequestBody User user, HttpSession httpSession) {
	 * System.out.println("UserApiController: login call "); User principal =
	 * userService.login(user); if (principal != null) {
	 * httpSession.setAttribute("principal", principal); } return new
	 * ResponseDto<Integer>(HttpStatus.OK, 1); // 자바 오브젝트를 JSON으로 변환해서 반환 }
	 */
}
