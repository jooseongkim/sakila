package sakila.dao;

import java.sql.*;

import sakila.query.StaffQuery;
import sakila.vo.Staff;

public class StaffDao {
	public Staff selectStaffByKey(Staff staff, Connection conn) throws Exception { // �삁�쇅泥섎━
		// �븘�씠�뵒�옉 鍮꾨�踰덊샇瑜� �엯�젰�빐�꽌 濡쒓렇�씤

		Staff returnStaff = null;

		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELECT_STAFF_BY_KEY);
		// staff荑쇰━�뿉�꽌 select staff by key瑜� 媛��졇�샂

		stmt.setString(1, staff.getEmail());
		stmt.setString(2, staff.getPassword());
		System.out.println(stmt + " <-stmt �옉�룞 �솗�씤 email,password");

		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			returnStaff = new Staff();
			returnStaff.setEmail(rs.getString("email"));
			returnStaff.setUserName(rs.getString("username"));
		}
		System.out.println(returnStaff + "<- returnStaff �떎�뻾 �솗�씤");

		return returnStaff;
	}
	
	public Staff selectStaffInfoById(Staff staff, Connection conn) throws Exception {
		//작성중
		return null;
	}
}
