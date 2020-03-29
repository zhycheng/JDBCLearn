package com.LearnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 

 
 
public class Test {
 
	public static void main(String[] args) {
		ResultSet rs=null;
		Statement stmt=null;
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(
					"jdbc:mysql://192.168.1.7:3306/web_test3", 
					"test",
					"zhycheng"
					);
			stmt=(Statement) conn.createStatement();
			rs=stmt.executeQuery("select * from user");
			while(rs.next())
			{
				System.out.print(rs.getInt("id")+" ");
				System.out.print(rs.getString("username")+" ");
				System.out.print(rs.getString("password")+" ");
				System.out.print(rs.getString("nickname")+" ");
				System.out.println(rs.getInt("age"));
				System.out.println("----------------");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
			
			if(stmt!=null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				stmt=null;
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

