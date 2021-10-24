package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 사용자가 요청 -> 응답(Html 파일) @controller
// 사용자가 요청 -> 응답(Data)
// 인터넷에서 요청은 get만 할 수 있다.
@RestController
public class HttpControllerTest {

	@GetMapping("/test/html")
	public String getTestHtml(Member member) {
		return "test.html";
	}
	@PostMapping("Http/post")
	public String postTest(Member member) {
		return "post 요청" + member.getId() +" ," + "username" + member.getUsername() +" ,"
		+ "password" + member.getPassword() + " ," + "email"+member.getEmail();
	}
	@PutMapping("Http/put")
	public String putTest() {
		return "put 요청";
	}
	@DeleteMapping("Http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
