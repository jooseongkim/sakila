package sakila.dao;

import java.sql.*;

import sakila.query.StatsQuery;
import sakila.vo.Stats;

public class StatsDao {
	// 오늘 날짜가 있는지 없는지 확인 , 예외처리 작성
	public Stats selectDay(Connection conn, Stats stats) throws Exception {

		// 날짜를 받아와서 그 날에 접속자의 유무를 판별
		// 있으면 stats로 보내며 없으면 null

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
		System.out.println(returnStats+"<-returnState 실행 확인");
		return returnStats;

	}

	// 오늘 날짜에 접속자를 입력하는 메서드 생성
	public void insertStats(Connection conn, Stats stats) throws Exception { //예외 처리 추가

		PreparedStatement stmt = conn.prepareStatement(StatsQuery.INSERT_STATS);
		stmt.setNString(1, stats.getDay());
		System.out.println(stmt+"<--insertState stmt , getDay()");
		stmt.executeUpdate();
		
		
	}

	// 업데이트는 받아온 날짜의 접속자 수를 +1 증가시켜줌
	public void updateStats(Connection conn, Stats stats) throws Exception { //예외처리 추가

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
