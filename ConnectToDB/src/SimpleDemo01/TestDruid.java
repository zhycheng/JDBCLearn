package SimpleDemo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alibaba.druid.pool.DruidDataSource;

public class TestDruid {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		try
		{
			DruidDataSource dds=new DruidDataSource();
			dds.setDriverClassName("com.mysql.jdbc.Driver");
			dds.setUrl("jdbc:mysql://192.168.1.7:3306/web_test3");
			dds.setUsername("test");
			dds.setPassword("zhycheng");
			conn=dds.getConnection();
			String sql="select * from user";
			stat=conn.prepareStatement(sql);
			rs=stat.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt("id"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs=null;
			}
			if(stat!=null)
			{
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				stat=null;
			}
			
			if(conn!=null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn=null;
			}
			
		}

	}

}
