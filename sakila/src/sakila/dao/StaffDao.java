package sakila.dao;

import java.sql.*;

import sakila.query.StaffQuery;
import sakila.vo.Staff;

public class StaffDao {
	public Staff selectStaffByKey(Staff staff, Connection conn) throws Exception { //예외처리
		//아이디랑 비밀번호를 입력해서 로그인
		
		Staff returnStaff = null;
		
		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELECT_STAFF_BY_KEY);
		//staff쿼리에서 select staff by key를 가져옴
		
		stmt.setInt(1, staff.getStaffId());
		stmt.setString(2, staff.getPassword());
		System.out.println(stmt +" <-stmt 작동 확인 id,password");
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			returnStaff = new Staff();
			returnStaff.setStaffId(rs.getInt("staff_id"));
			returnStaff.setUserName(rs.getString("username"));
		}
		System.out.println(returnStaff + "<- returnStaff 실행 확인");
		
		
		return returnStaff;
	}
}
