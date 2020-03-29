package com.LouDong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.LearnJDBC.JDBCUtil;

public class JDBCDemo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//LouDong.login("ccc' -- ", "12s3");
		login("ccc' -- ", "12s3");
	}
	
	public static void login(String username,String password)
	{
		Connection conn=null;
		PreparedStatement pps=null;
		ResultSet rs=null;
		
		boolean flag=false;
		try
		{
			conn=JDBCUtil.getConnection();
			String sql="select * from user where username=? and password=?";
			pps.getConnection().prepareStatement(sql);
			pps.setString(1, username);
			pps.setString(2, password);
			//执行sql语句
			rs=pps.executeQuery();
			if(rs.next())
			{
				System.out.println("success");
			}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			JDBCUtil.release(rs, pps, conn);
		}
		
		
	}

}
