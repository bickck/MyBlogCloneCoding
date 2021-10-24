package com.cos.blog.test;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {

	@Autowired //DummyController가 메모리에 뜰 때 @Autowired가 되어있는 것도 뜬다. // 의존성 주입
	private UserRepository userRepository;
	
	@GetMapping("/dummy/user")
	public List<User> list(){
		return userRepository.findAll();
	}
	
	// 한 페이지당 2건에 데이터를 받아 볼 예정
	@GetMapping("/dummy/user/page")
	public Page<User> pageList(@PageableDefault(size = 2, sort = "id",direction = Sort.Direction.DESC) Pageable page){
		 Page<User> users= userRepository.findAll(page);
		 return users;
	}
	
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		/*
		User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
			@Override
			public User get() {
				// TODO Auto-generated method stub
				return new User();
			}
		});
		*/
		//이 형태를 권장
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalAccessError>() {

			@Override
			public IllegalAccessError get() {
				// TODO Auto-generated method stub
				return new IllegalAccessError("not exist user" + id);
			}
			
		});
		
		// 요청: 웹브라우저
		// user 객체 = 자바 오브첵트
		// 변환 (웹브라우저가 이해할 수 있는 데이터 -> json(Gson 라이브러리)
		// 스프링 부트 = MessageConverter라는 애가 응답시에 자동 작동
		// 만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson 라이브러리를 호출해서
		// user 오브젝트를 json으로 변환해서 브라우저에게 던져줌
		return user;
	}
	
	
	@PostMapping("/dummy/join")
	public String join(User user) {
		
		//System.out.println("username" + user.getusername());
		//System.out.println("password" + user.getpassword());
		//System.out.println("email" + user.getemail());
		userRepository.save(user);
		return "register sucess";
	}
}
