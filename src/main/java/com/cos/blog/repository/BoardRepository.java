package com.cos.blog.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

	Page<Board> findAll(Pageable pageable);

}
