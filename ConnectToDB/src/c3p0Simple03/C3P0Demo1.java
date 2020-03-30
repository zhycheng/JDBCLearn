package c3p0Simple03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo2();
	}
	public static void Demo2()
	{
		Connection conn=null;
		PreparedStatement pps=null;
		ResultSet rs=null;
		try
		{
			//自动找配置
			ComboPooledDataSource dataSource=new ComboPooledDataSource();
			/*
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://192.168.1.7:3306/web_test3");
			dataSource.setUser("test");
			dataSource.setPassword("zhycheng");
			*/
			
			
			
			
			
			conn=dataSource.getConnection();
			String sql="select * from user";
			pps=conn.prepareStatement(sql);
			rs=pps.executeQuery();
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
			if(pps!=null)
			{
				try {
					pps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pps=null;
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
	
	public static void Demo1()
	{
		Connection conn=null;
		PreparedStatement pps=null;
		ResultSet rs=null;
		try
		{
			ComboPooledDataSource dataSource=new ComboPooledDataSource();
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://192.168.1.7:3306/web_test3");
			dataSource.setUser("test");
			dataSource.setPassword("zhycheng");
			conn=dataSource.getConnection();
			String sql="select * from user";
			pps=conn.prepareStatement(sql);
			rs=pps.executeQuery();
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
			if(pps!=null)
			{
				try {
					pps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pps=null;
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
