package com.maymin.member.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.maymin.member.model.Member;

// DAO 클래스만 수정해주면 된다
@Repository
public class MemberDao {
	// dependency 있어야 불러올 수 있음
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MemberDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/* 한사람 조회기능 */
	public Member selectByEmail(String email) {
		return null;
	}
	/* 모든 사람 조회기능 */
	public Collection<Member> selectAll(){
		return null;
	}
	
	// id는 시퀀스로 입력할 거라서 insert에서 지정 안함
	public void insert(Member member) {
		// 인터페이스 상속받은 객체를 여기에 담아줌 이름을 따로 안 말들어도 인자값안에 클래스 만들 수 있음 - 무명클래스
		// 이 메서드 하나로 끝났다 코드에만 딱 집중. 연결, 해제 코드 없음
		/*
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "insert into member(id, email, password, name, " +
						"registerDate) values(seq_id.nextVal,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, member.getEmail());
				stmt.setString(2, member.getPassword());
				stmt.setString(3, member.getName());
				stmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
				
				return stmt;
			}
		});
		*/
		
	// 람다문법 Lambda
		jdbcTemplate.update(
				(Connection con) -> {
				String sql = "insert into member(id, email, password, name, " +
						"registerDate) values(seq_id.nextVal,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, member.getEmail());
				stmt.setString(2, member.getPassword());
				stmt.setString(3, member.getName());
				stmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
				
				return stmt;
			}
		);
	}
	
	public void update(Member member) {
	
	}
}

//// class 이름은 내맘대로
//class PreparedStatementImpl implements PreparedStatementCreator{
//	@Override
//	public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//		// 물음표를 prepared로 처리하기 위해서
//		String sql = "insert into member(id, email, password, name, " +
//				"regdate) values(seq_id,nextVal,?,?,?,?)";
//		PreparedStatement stmt = con.prepareStatement(sql);
//		stmt.setString();
//		
//		return null;
//	}
//}
