package sakila.dao;

import java.sql.*;

import sakila.query.StatsQuery;
import sakila.vo.Stats;

public class StatsDao {
	// ���� ��¥�� �ִ��� ������ Ȯ�� , ����ó�� �ۼ�
	public Stats selectDay(Connection conn, Stats stats) throws Exception {

		// ��¥�� �޾ƿͼ� �� ���� �������� ������ �Ǻ�
		// ������ stats�� ������ ������ null

		Stats returnStats = null;
		
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELECT_DAY);
		stmt.setString(1, stats.getDay());
		System.out.println(stmt+"<--selectDay stmt , getDay()");
		
		
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			returnStats = new Stats();
			returnStats.setDay(rs.getString("day"));
			returnStats.setCount(rs.getLong("cnt"));
		}
		System.out.println(returnStats+"<-returnState ���� Ȯ��");
		return returnStats;

	}

	// ���� ��¥�� �����ڸ� �Է��ϴ� �޼��� ����
	public void insertStats(Connection conn, Stats stats) throws Exception { //���� ó�� �߰�

		PreparedStatement stmt = conn.prepareStatement(StatsQuery.INSERT_STATS);
		stmt.setNString(1, stats.getDay());
		System.out.println(stmt+"<--insertState stmt , getDay()");
		stmt.executeUpdate();
		
		
	}

	// ������Ʈ�� �޾ƿ� ��¥�� ������ ���� +1 ����������
	public void updateStats(Connection conn, Stats stats) throws Exception { //����ó�� �߰�

		PreparedStatement stmt = conn.prepareStatement(StatsQuery.UPDATE_STATS);
		stmt.setString(1,stats.getDay());
		System.out.println(stmt+"<--updateStats stmt , getDay()");
		stmt.executeUpdate();
		
	}
	
	public int totalCount(Connection conn) throws Exception {
		int total = 0;
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.TOTAL_COUNT);
		System.out.println(stmt+"<--total stmt");
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			total  = rs.getInt("sum(cnt)");
		}
		
		return total;
		
	}
}
