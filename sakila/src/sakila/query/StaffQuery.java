package sakila.query;

public class StaffQuery {
	public final static String SELECT_STAFF_BY_KEY = "select email, username from staff where email=? and password = password(?)";
	public final static String SELECT_STAFF_INFO_BY_ID = "select * from staff where email=? and password = password(?) ";
}
