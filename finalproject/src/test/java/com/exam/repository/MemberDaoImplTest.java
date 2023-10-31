package com.exam.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exam.domain.RegisterRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDaoImplTest {
	@Autowired
	private MemberDao memberDao;
	
	@Ignore @Test
	public void registerTest() throws Exception {
		RegisterRequest regreq = new RegisterRequest();
		regreq.setEmail("lim@test.com");
		regreq.setName("임꺽정");
		regreq.setPassword("1111");
		
		memberDao.registerMember(regreq);
	}
	
	@Test /* Null 인지 아닌지 */
	public void testSelectWithPass() throws Exception {
		assertNotNull(memberDao.selectWithPass("hong@test.com", "1111"));
		assertNull(memberDao.selectWithPass("hong@test.com", "2222"));
	}
}
