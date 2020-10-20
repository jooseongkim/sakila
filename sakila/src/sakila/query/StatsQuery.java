package sakila.query;

public class StatsQuery {
	public static final String INSERT_STATS = "insert into stats(day, cnt) values (?, 1)";
	public static final String UPDATE_STATS = "update stats set cnt=cnt+1 where day=?";
	public static final String SELECT_DAY = "select * from stats where day=?";
	public static final String TOTAL_COUNT = "select sum(cnt) from stats";
}
