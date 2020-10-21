package sakila.dao;

import java.sql.*;

import sakila.query.StaffQuery;
import sakila.vo.Staff;

public class StaffDao {
	public Staff selectStaffByKey(Staff staff, Connection conn) throws Exception { //����ó��
		//���̵�� ��й�ȣ�� �Է��ؼ� �α���
		
		Staff returnStaff = null;
		
		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELECT_STAFF_BY_KEY);
		//staff�������� select staff by key�� ������
		
		stmt.setInt(1, staff.getStaffId());
		stmt.setString(2, staff.getPassword());
		System.out.println(stmt +" <-stmt �۵� Ȯ�� id,password");
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			returnStaff = new Staff();
			returnStaff.setStaffId(rs.getInt("staff_id"));
			returnStaff.setUserName(rs.getString("username"));
		}
		System.out.println(returnStaff + "<- returnStaff ���� Ȯ��");
		
		
		return returnStaff;
	}
}
