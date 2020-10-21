package sakila.service;

import java.sql.Connection;

import sakila.commons.DBUtil;
import sakila.dao.StaffDao;
import sakila.vo.Staff;

public class StaffService {
	private StaffDao staffDao; // staffDao를 가져옴

	public Staff getStaffByKey(Staff staff) {
		Staff returnStaff = null;
		staffDao = new StaffDao();
		Connection conn = null;

		try {
			conn = DBUtil.getConnection();
			System.out.println(conn + "conn의 연결 확인"); // 데이터베이스와 연결되었는지 확인

			conn.setAutoCommit(false); // 오토 커밋은 false로 설정
			returnStaff = staffDao.selectStaffByKey(staff, conn);
			System.out.println(returnStaff + "<--returnStaff확인 "); //확인
			
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return returnStaff;
	}
}
