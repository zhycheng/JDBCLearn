package com.LouDong;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.LearnJDBC.JDBCUtil;

public class LouDong {
	public static void main(String[] args)
	{
		
	}
	public static void  login(String username,String password)
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=JDBCUtil.getConnection();
			stmt=conn.createStatement();
			String sql="select * from user where username='"+username+"' and password='"+password+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				System.out.println("success");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.release(rs, stmt, conn);
		}
	}

}
