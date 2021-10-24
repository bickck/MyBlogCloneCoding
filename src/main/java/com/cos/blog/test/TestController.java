package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test/jsp")
	public String getTestJsp(Member member) {
		System.out.println("getTestJsp");
		return "test";
	}
}
