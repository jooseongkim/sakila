package sakila.commons;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getConnection() throws Exception { //예외처리 입력
		
		// db연결을 위한 변수를 적어서 다른 곳에서 추가로 적을 필요없이 실행시킬 수 있도록 함

		// db변수 지정 / 변하지 않는 값이므로 앞에 final을 적어준다.
		final String driver = "org.mariadb.jdbc.Driver";
		final String dbaddr = "jdbc:mariadb://localhost:3306/sakila";
		final String dbid = "root";
		final String dbpw = "java1004";

		// 드라이버 가져오기
		Class.forName(driver);

		// db연결
		Connection conn = DriverManager.getConnection(dbaddr, dbid, dbpw);
		//드라이버 매니저와 연결 

		return conn;
	}
}
