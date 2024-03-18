package in.co.transition;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.Statement;

	public class TestInsert {

		public static void main(String[] args) throws Exception {

			Connection conn = null;

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi", "root", "root");

				Statement stmt = conn.createStatement();

				conn.setAutoCommit(false);

				int i = stmt.executeUpdate("insert into marksheet values(41, 'xyz',  66)");
				i = stmt.executeUpdate("insert into marksheet values(42,  'xyz', 98)");
				i = stmt.executeUpdate("insert into marksheet values(43,  'xyz', 98)");

				conn.commit();

				System.out.println("data inserted = " + i);
			} catch (Exception e) {
				conn.rollback();
				System.out.println(e.getMessage());
			} finally {
				conn.close();
			}
		}

	}

