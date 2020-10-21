package sakila.query;

public class StaffQuery {
	public final static String SELECT_STAFF_BY_KEY = "select staff_id, username from staff where staff_id=? and password = password(?)";
}
