package in.co.Sun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import in.co.Marksheet.MarksheetBean;

public class SunModal {

	public void add (SunBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?)");
		
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getMaths());
		int i = ps.executeUpdate();
		System.out.println("data inserted"+i);
		
	}
	
	public void update(SunBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi", "root", "root");
        
		PreparedStatement ps = conn.prepareStatement("update marksheet set name =?, maths = ? where id = ?");

		ps.setInt(3, bean.getId());
		ps.setString(1, bean.getName());
		ps.setInt(2, bean.getMaths());
		
		int i = ps.executeUpdate();
		System.out.println("data inserted= "+i);
	}
	
	
	
}
