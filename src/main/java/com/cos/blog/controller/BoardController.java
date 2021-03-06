package com.cos.blog.controller;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private PrincipalDetail principalDetail;

	@Autowired
	private BoardService boardService;

	// /WEB-INF/views/ .jsp
	// @AuthenticationPrincipal PrincipalDetail detail

	@GetMapping({ "/", "" })
	public String index(Model model, @PageableDefault(size=3,sort="id",direction = Sort.Direction.DESC)Pageable pageable) {

		model.addAttribute("boards",boardService.lists(pageable));
		System.out.println("로그인 사용자 아이디:" + principalDetail.getUsername());
		return "index";
	}

	// USER 권한이 필요
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
	
	@GetMapping("/board/{id}")
	public String findById(@PathVariable int id	, Model model) {
		model.addAttribute("board",boardService.detail(id));
		
		return "board/detail";
		
	}
}
