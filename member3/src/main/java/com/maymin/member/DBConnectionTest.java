package com.maymin.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* 이 작업은 매번 반복될 수 밖에 없다 -> 템블릿으로 Spring 답게 쓸거다 */
public class DBConnectionTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";	
		Connection conn = 
			DriverManager.getConnection(url, "scott", "1111");
		System.out.println(conn);
		conn.close();
	}
}
