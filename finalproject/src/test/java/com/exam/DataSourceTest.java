package com.exam;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class DataSourceTest {
	@Autowired
	private DataSource dataSource; // 주입을 받도록. 미리 만들어 놓은게 있으니까 환경을 또 만들 필요가 없다
	
	@Test
	public void testHikari() {
		try(Connection con = dataSource.getConnection()){
			System.out.println(con);
		}
		catch(Exception err) {
			err.printStackTrace();
		}
	}
}
