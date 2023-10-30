package com.exam.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.domain.Board;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSession sqlSession;
	
//	절대 수정되서도 안되고 여러개 생성되서도 안 된다 상수는 대문자로
	private static final String NAMESPACE = "com.exam.mybatis.boardMapper";
	
	@Override
	public List<Board> getList() throws Exception {
//		mybatis에게 요청해서 db 데이터 꺼내오기
		return sqlSession.selectList(NAMESPACE + ".getList");
	}

	@Override
	public Board read(int bNo) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".read", bNo);
	}

	@Override
	public int write(Board board) throws Exception {
		/* mybatis에서 설정한 mapper의 sql문 */
		return sqlSession.insert(NAMESPACE + ".write", board);
	}

	@Override
	public int update(Board board) throws Exception {
		return sqlSession.update(NAMESPACE + ".update", board);
	}

	@Override
	public int delete(int bNo) throws Exception {
		return sqlSession.delete(NAMESPACE + ".delete");
	}

}
