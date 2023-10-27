package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.domain.Board;
import com.exam.repository.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired	// setter 메서드 주입이랑 같은 
	private BoardDao boardDao;
	
	@Override
	public List<Board> getList() throws Exception {
		return null;
	}

	@Override
	public Board read(int bNO) throws Exception {
		return null;
	}

	@Override
	public void write(Board board) throws Exception {
	//// BoardDaoImpl dao = new BoardDaoImpl();
	//// dao.write(board); 의존성이 너무 높다
		boardDao.write(board);
	}

	@Override
	public void update(Board board) throws Exception {

	}

	@Override
	public void delete(int bNo) throws Exception {

	}

}
