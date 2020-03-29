package com.LearnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stat=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(
							"jdbc:mysql://192.168.1.7:3306/web_test3", 
							"test",
							"zhycheng"
							);
			stat=conn.createStatement();
			String sql="insert into user values(null,'eee','123','阿黄',21)";
			sql="update user set nickname='大黄是' where id=5";
			sql="delete from user where id=5";
			int rowNumber=stat.executeUpdate(sql);
			if(rowNumber>0)
			{
				System.out.println("保存用户成功");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
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
