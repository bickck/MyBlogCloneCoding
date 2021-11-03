package com.cos.blog.api;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/auto/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		userService.register(user);
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
		// 자바 오브젝트를 JSON으로 변환해서 반환
	}

	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user) {
		userService.update(user);
		// 여기서는 트랜잭션이 종료되기 떄문에 DB에 값은 변경이 됐음
		// 하지만 세션값은 변경이 되지 않았기 때문에 강제적으로 변경해주어야함
		
		// 세션 등록
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
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

	/*
	 * Authentication authentication = new
	 * UsernamePasswordAuthenticationToken(principal,
	 * null,principal.getAuthorities()); SecurityContext context =
	 * SecurityContextHolder.getContext();
	 * context.setAuthentication(authentication);
	 * httpSession.setAttribute("SPRING_SECURITY_CONTEXT", context);
	 */
}
