package com.cos.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.blog.config.auth.PrincipalDetail;

@Controller
public class BoardController {
	
	@Autowired
	private PrincipalDetail principalDetail;
	
	//@AuthenticationPrincipal PrincipalDetail detail

	@GetMapping({"/",""})
	public String index() {
		// /WEB-INF/views/ .jsp
		System.out.println("로그인 사용자 아이디:"+ principalDetail.getUsername());
		return "index";
	}
	
	//USER 권한이 필요
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
}
