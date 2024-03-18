
package in.co.colleble;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;



public class TestProducerINOUT {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");		
		

		CallableStatement callStmt = conn.prepareCall("{CALL empInOut(?)}");
	
		callStmt.setInt(1, 3);
	
		callStmt.registerOutParameter(1, Types.INTEGER);

		callStmt.execute();

		System.out.println(callStmt.getInt(1));
        callStmt.close();
        conn.close();


	}
}