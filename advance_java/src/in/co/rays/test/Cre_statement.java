package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Cre_statement {
	public static void main(String[] args) throws Exception  {
		
	Class.forName("com.mysql.cj.jdbc.Driver");
 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi","root","root");
  Statement stmt =  conn.createStatement();
   int i = stmt.executeUpdate("insert into marksheet values(14,'shreya',40,67,36)");
    System.out.println("data inserted ="+ i);
   }
 }