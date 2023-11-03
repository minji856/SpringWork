package io.acorn.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import io.acorn.domain.Member;

// DAO , mapper 사이를 연결해주는 역할
// mybatis가 이미 어노테이션을 통해서 인터페이스의 객체를 생성해둠
@Mapper
public interface DataMappingInterface {
	@Select("SELECT * FROM mem")
	List<Member> selectAll();
	
//	void 로 받아도 되지만 검증하기 편하게
	@Insert("INSERT INTO mem values(#{num}, #{name}, #{addr})")
	int insertData(Member mem);
	
	@Select("SELECT * FROM mem WHERE num=#{num}")
	Member selectOne(String num);
	
	@Update("UPDATE mem SET name=#{name}, addr=#{addr} where num=#{num}")
	int updateData(Member mem);
	
	@Delete("DELETE from mem where num=#{num}")
	int deleteData(String num);
}
