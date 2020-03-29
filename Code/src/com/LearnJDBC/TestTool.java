package com.LearnJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTool {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=JDBCUtil.getConnection();
			stmt=conn.createStatement();
			String sql="select * from user";
			rs=stmt.executeQuery(sql);
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
			JDBCUtil.release(rs, stmt, conn);
		}
		
	}

}
