package in.co.transitionhelding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class Employee {

	public static void main(String[] args) throws Exception {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi", "root", "root");

			Statement stmt = conn.createStatement();

			conn.setAutoCommit(false);

			int i = stmt.executeUpdate("insert into marksheet values (34,'hari',76)");
			i = stmt.executeUpdate("insert into marksheet values (35,'reena',65)");
			i = stmt.executeUpdate("insert into marksheet values (36,'areena',45)");

			conn.commit();

			System.out.println("inserted data =" + i);
		} catch (Exception e) {
			conn.rollback();
			System.out.println(e.getMessage());
		} finally {
			 conn.close();
			
		}
	}

}
