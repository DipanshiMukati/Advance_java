package in.co.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserModal {
    public void add(UserBean bean) throws Exception {
    	Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi", "root", "root");
		PreparedStatement ps = conn.prepareStatement("insert into user values(?, ?, ?, ?, ?, ?, ?)");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getFirstname());
		ps.setString(3, bean.getLastName());
		ps.setString(4, bean.getLoginid());
		ps.setString(5, bean.getPassword());
		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(7, bean.getAddress());
        int i = ps.executeUpdate();
        System.out.println("data insedrted="+i);
    }
    public List search(UserBean bean) throws Exception{
    	Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi", "root", "root");
		PreparedStatement ps = conn.prepareStatement("insert into user values(?, ?, ?, ?, ?, ?, ?)");
		ResultSet rs = ps.executeQuery();
		List list =  new ArrayList();
		while(rs.next());
		bean.setId(rs.getInt(1));
		bean.setFirstname(rs.getString(2));
		bean.setLastName(rs.getString(3));
		bean.setLoginid(rs.getString(4));
		bean.setPassword(rs.getString(5));
		bean.setDob(rs.getDate(6));
		bean.setAddress(rs.getString(7));
		
		

		return list;
    	
    	
    }
}
