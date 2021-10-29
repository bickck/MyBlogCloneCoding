package com.cos.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

import net.bytebuddy.pool.TypePool.Default.ReaderMode;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void register(User user) {
		userRepository.save(user);
	}
	
	@Transactional(readOnly = true) // Select 할 때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료(정합성)
	public User login(User user) {
		return userRepository.findByUserNameAndPassword(user.getUsername(),user.getPassword());
	}
}
