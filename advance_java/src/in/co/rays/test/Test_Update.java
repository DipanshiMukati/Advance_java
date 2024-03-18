package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test_Update {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi","root","root");
		Statement stmt = conn.createStatement();
	//	int i = stmt.executeUpdate("alter table marksheet add roll_no int");
		//System.out.println("data inserted ="+i);
//		int i = stmt.executeUpdate("update marksheet set roll_no =11 where id = 1");
//		System.out.println(" data updated ="+i);
//		int i = stmt.executeUpdate("delete from marksheet where id =13");
//		System.out.println("Data deleted");
		int i = stmt.executeUpdate("alter table marksheet drop roll_no");
		System.out.println("Data deleted"+i);

	}

}
