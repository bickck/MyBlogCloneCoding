package com.cos.blog.service;

import java.awt.print.Pageable;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.Board;
import com.cos.blog.model.User;
import com.cos.blog.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional
	public void write(Board board,User user) { // title, content
		board.setCount(0);
		board.setUserId(user);
		boardRepository.save(board);
	} 
	
	@Transactional(readOnly = true)
	public Page<Board> lists(Pageable pageable){
		return boardRepository.findAll(pageable);
	}
	@Transactional(readOnly = true)
	public Board detail(int id) {
		return boardRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("글 상세보기 실패: 아이디를 찾을 수 없습니다.");
		});
	}
	
	@Transactional
	public void deleteBoard(int id) {
		boardRepository.deleteById(id);
	}
}
