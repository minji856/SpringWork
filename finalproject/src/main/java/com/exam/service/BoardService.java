package com.exam.service;

import java.util.List;

import com.exam.domain.Board;

public interface BoardService {
//  전체 글 조회할 때 쓰는 메서드
	public List<Board> getList() throws Exception;

//	한개의 글 읽기
	public Board read(int bNO) throws Exception;

//	글 저장
	public void write(Board board) throws Exception;

	public void update(Board board) throws Exception;

	public void delete(int bNo) throws Exception;
}
