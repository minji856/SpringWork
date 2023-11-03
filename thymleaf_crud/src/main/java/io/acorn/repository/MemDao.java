package io.acorn.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.acorn.domain.Member;

@Repository
public class MemDao {
	@Autowired 	// 객체를 잘 주입 받아오는게 중요
	private DataMappingInterface dataInterface;
	
	public List<Member> getDataAll(){
//		System.out.println("확인 : " + dataInterface);
		List<Member> list = dataInterface.selectAll();
		return list;
	}
	
	public boolean insertData(Member mem) {
		int result = dataInterface.insertData(mem);
		if(result > 0)
			return true;
		else
			return false;
	}
}
