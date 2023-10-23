package com.maymin.member.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
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
		String sql = "select * from member where email=?";
		/* 3개의 인자 */
		Member mem = jdbcTemplate.query(sql, 
					new PreparedStatementSetter() {
			// 오브젝트 배열로 하면 코드가 간단해지지만 이걸 권장해서 씀. 물음표에 들어갈 값만 정해주면 됨
						@Override
						public void setValues(PreparedStatement ps) throws SQLException {
							ps.setString(1, email);
						}
					}, 
					new ResultSetExtractor<Member>() {
						@Override
						public Member extractData(ResultSet rs) throws SQLException, DataAccessException {
							// 실제 데이터 위치로 포인터 옮겨주는 작엄. 이미 결과를 가지고 왔다
							// <T> 제너릭을 Member 타입으로
							Member member = null;
							if(rs.next()) {
								member = new Member(rs.getString("email"),
										rs.getString("name"),
										rs.getString("password"),
										rs.getTimestamp("registerDate"));
								member.setId(rs.getLong("id"));
//								return member; // if 문 안에 선언했기 때문인데 다시 밖으로 뺌
							} 
							return member;
						}
					});
		return mem;
	}
	
	/* 모든 사람 조회기능 */
	public Collection<Member> selectAll(){
		String sql = "select * from member";
		// 무명클래스 인터페이스를 통해서 바로 객체를 생성할 수 있음
		List<Member> result = jdbcTemplate.query(sql, new RowMapper() {
		
			// 데이터 갯수만큼 반복을 돌아서 result에 쌓아 놓는다
			@Override 
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member dto = new Member(rs.getString("email"),
						rs.getString("name"),
						rs.getString("password"),
						rs.getTimestamp("registerDate"));
				dto.setId(rs.getLong("id"));	// ID값 까지 묶여야한다 입력받는 정보가 아니기 때문
				return dto;
			}
		});
		return result;
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
		/*
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
		*/
		
		String sql = "insert into member(id, email, password, name, " +
				"registerDate) values(seq_id.nextVal,?,?,?,?)";

		// 물음표에 들어갈 값을 배열로 묶어주는
		/*
		Object[] values = new Object[] { member.getEmail(), member.getPassword(),
				member.getName(),
				new Timestamp(member.getRegisterDate().getTime())};
		
		jdbcTemplate.update(sql, values);*/
		
		// 여러 파라미터를 받을 수 있어서
		jdbcTemplate.update(sql, 	member.getEmail(), 
									member.getPassword(),
									member.getName(),
				new Timestamp(member.getRegisterDate().getTime()));
		
	}
	
	public void update(Member member) {
		String sql = "update member set password=? where email=?";
		
		jdbcTemplate.update(sql, member.getPassword(), member.getEmail());
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
