package in.co.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Pre_statement {
      public static void main(String[] args) throws Exception {
    	  
    	  Class.forName("com.mysql.cj.jdbc.Driver");
    	  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi","root","root");
    	  PreparedStatement ps = conn.prepareStatement("insert into marksheet values(19,'shivam',50,71,60)");
    	  int i = ps.executeUpdate();
    	  System.out.println("inserted data="+i);
    	  
    	  
    	  
    	  
    	  
      }
      
}