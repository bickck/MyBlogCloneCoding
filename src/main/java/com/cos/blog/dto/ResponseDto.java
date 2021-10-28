package com.cos.blog.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto<T> {

	HttpStatus status;
	T data;
	

	
	public ResponseDto(HttpStatus internalServerError, T string) {
		// TODO Auto-generated constructor stub
		this.status = internalServerError;
		this.data = string;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
