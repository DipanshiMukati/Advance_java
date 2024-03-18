package in.co.Star;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import in.co.user.UserBean;
import in.co.util.JDBCDataSource;

public class StarModal {

	public void add(StarBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi", "root", "root");
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?, ?, ?)");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getMaths());
		int i = ps.executeUpdate();
		System.out.println("data inserted=" + i);

	}

	public void update(StarBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi", "root", "root");
		PreparedStatement ps = conn.prepareStatement("update marksheet set name =?, maths = ? where id = ?");
		ps.setInt(3, bean.getId());
		ps.setString(1, bean.getName());
		ps.setInt(2, bean.getMaths());
		int i = ps.executeUpdate();
		System.out.println("data updated=" + i);
	}

	public void delete(StarBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi", "root", "root");
		PreparedStatement ps = conn.prepareStatement("delete from marksheet where id = ?");
		ps.setInt(1, bean.getId());
		int i = ps.executeUpdate();
		System.out.println("data deleted=" + i);

	}

	public List search() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from marksheet");
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();

		while (rs.next()) {
			StarBean bean = new StarBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setMaths(rs.getInt(3));
			list.add(bean);
		}

		return list;

	}

	public StarBean Auth(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet where id = ? ");
		ResultSet rs = pstmt.executeQuery();
		pstmt.setInt(1, id);

		StarBean bean = null;

		while (rs.next()) {
			bean = new StarBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setMaths(rs.getInt(3));
		}
		return bean;

	}

	public StarBean findBypk(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from marksheet where id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		StarBean bean = null;
		while (rs.next()) {
			bean = new StarBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setMaths(rs.getInt(3));
		}
		return bean;

	}

	public Integer nextpk() throws Exception {
		int pk = 0;
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select max marksheet");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;

	}

	public void Add(StarBean bean) throws Exception {
		int pk = nextpk();
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?, ?, ?");
		
		ps.setInt(1, pk);
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getMaths());
		int i = ps.executeUpdate();
		System.out.println("data inserted=" + pk);
	}

}
