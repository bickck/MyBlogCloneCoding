package com.cos.blog.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.Board;
import com.cos.blog.model.User;
import com.cos.blog.service.BoardService;

@RestController
public class BoardApiController {
	
	@Autowired
	private BoardService boardService;

	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principalDetail) {
		boardService.write(board,principalDetail.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
		// 자바 오브젝트를 JSON으로 변환해서 반환
	}
	
	public ResponseDto<Integer> deleteById(@PathVariable int id) {
	
		boardService.deleteBoard(id);
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
		// 자바 오브젝트를 JSON으로 변환해서 반환
	}
	
}
