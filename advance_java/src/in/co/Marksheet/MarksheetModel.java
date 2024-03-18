package in.co.Marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MarksheetModel {

	public void add(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi", "root", "root");
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?, ?, ?)");
		int pk = nextpk();
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getMaths());

		int i = ps.executeUpdate();

		System.out.println("Data inserted = " + i);

	}
	public Integer nextpk() throws Exception {
		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select max(id) from marksheet");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);

		}

		return pk + 1;
	}

	public void update(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi", "root", "root");

		PreparedStatement ps = conn.prepareStatement("update marksheet set name =?, maths = ? where id = ?");

		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getMaths());

		int i = ps.executeUpdate();

		System.out.println("Data inserted = " + i);

	}

	public void delete(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi", "root", "root");

		PreparedStatement ps = conn.prepareStatement("delete from marksheet where id = ?");

		ps.setInt(1, id);

		int i = ps.executeUpdate();

		System.out.println("Data deleted = " + i);
	}

	public MarksheetBean findByPk(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from marksheet where id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		MarksheetBean bean = null;
		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setMaths(rs.getInt(3));

		}
		return bean;
	}

	

	public void addData(MarksheetBean bean) throws Exception {
		int pk = nextpk();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi", "root", "root");
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,");
		ps.setInt(1, pk);
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getMaths());
		int i = ps.executeUpdate();
		System.out.println("data inserted =" + i);
	}

	public List search() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anandi","root","root");
		PreparedStatement ps = conn.prepareStatement("select * from marksheet");
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();

		while (rs.next()) {
			MarksheetBean bean = new MarksheetBean();

			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setMaths(rs.getInt(3));
			list.add(bean);
		}
		return list;
		
	}
}