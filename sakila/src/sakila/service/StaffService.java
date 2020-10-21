package sakila.service;

import java.sql.Connection;

import sakila.commons.DBUtil;
import sakila.dao.StaffDao;
import sakila.vo.Staff;

public class StaffService {
	private StaffDao staffDao; // staffDao�� ������

	public Staff getStaffByKey(Staff staff) {
		Staff returnStaff = null;
		staffDao = new StaffDao();
		Connection conn = null;

		try {
			conn = DBUtil.getConnection();
			System.out.println(conn + "conn�� ���� Ȯ��"); // �����ͺ��̽��� ����Ǿ����� Ȯ��

			conn.setAutoCommit(false); // ���� Ŀ���� false�� ����
			returnStaff = staffDao.selectStaffByKey(staff, conn);
			System.out.println(returnStaff + "<--returnStaffȮ�� "); //Ȯ��
			
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
