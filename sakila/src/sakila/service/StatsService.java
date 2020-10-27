package sakila.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import sakila.commons.DBUtil;
import sakila.dao.StatsDao;
import sakila.vo.Stats;

public class StatsService {
	private StatsDao statsDao;

	private Stats getToday() {
		// ���� ��¥�� ����
		Calendar today = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd"); // ���� - �� - ��
		String day = formater.format(today.getTime());
		Stats stats = new Stats();
		stats.setDay(day);
		return stats;
	}

	public Map<String, Object> getStats() {
		// ���� �湮�� ���� ��ȸ
		Map<String, Object> map = null;
		statsDao = new StatsDao();
		Stats stats = new Stats();
		Connection conn = null;

		try {
			conn = DBUtil.getConnection();
			System.out.println(conn + "<-���� Ȯ��");
			conn.setAutoCommit(false);

			stats = this.getToday();
			Stats todayStats = new Stats();
			todayStats = statsDao.selectDay(conn, stats);
			int totalCnt = statsDao.totalCount(conn);
			conn.commit();
			
			map = new HashMap<String, Object>();
			map.put("todayStats", todayStats);
			map.put("totalCnt", totalCnt);
		} catch (Exception e) {
			try { // �ѹ� ����
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public void countStats() { //������ �� ���
		statsDao = new StatsDao();
		Connection conn = null;
		Stats stats = new Stats();

		try {
			conn = DBUtil.getConnection();
			System.out.println(conn + "<- ����Ȯ��");
			//db�� ������ �Ǿ����� Ȯ��
			
			conn.setAutoCommit(false);

			Calendar today = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
			String day = formater.format(today.getTime());
			stats = new Stats();
			stats.setDay(day);
			System.out.println(stats+"stats");
			
			if(statsDao.selectDay(conn, stats) == null) {
				statsDao.updateStats(conn, stats);
			} else {
				stats = this.getToday();
			}
			if (statsDao.selectDay(conn, stats) == null) {
				statsDao.insertStats(conn, stats);
			} else {
				statsDao.updateStats(conn, stats);
			}
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.getStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
