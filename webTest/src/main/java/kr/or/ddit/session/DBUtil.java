package kr.or.ddit.session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	//static 초기화 블럭
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection1(){
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ddit","java");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			return null;
		}
	}
	public static Connection getConnection2(){
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","testID","java");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			return null;
		}
	}
}
