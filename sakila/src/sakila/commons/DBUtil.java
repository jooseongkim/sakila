package sakila.commons;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getConnection() throws Exception { //����ó�� �Է�
		
		// db������ ���� ������ ��� �ٸ� ������ �߰��� ���� �ʿ���� �����ų �� �ֵ��� ��

		// db���� ���� / ������ �ʴ� ���̹Ƿ� �տ� final�� �����ش�.
		final String driver = "org.mariadb.jdbc.Driver";
		final String dbaddr = "jdbc:mariadb://localhost:3306/sakila";
		final String dbid = "root";
		final String dbpw = "java1004";

		// ����̹� ��������
		Class.forName(driver);

		// db����
		Connection conn = DriverManager.getConnection(dbaddr, dbid, dbpw);
		//����̹� �Ŵ����� ���� 

		return conn;
	}
}
