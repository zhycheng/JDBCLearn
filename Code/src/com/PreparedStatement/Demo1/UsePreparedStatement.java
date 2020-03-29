package com.PreparedStatement.Demo1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.LearnJDBC.JDBCUtil;

public class UsePreparedStatement {

	public static void main(String[] args) {
		
		//doInsert();
		//doUpdate();
		//doDelete();
		doQuery();
	}
	
	public static void doInsert()
	{
		Connection conn=null;
		PreparedStatement pps=null;
		try
		{
			conn=JDBCUtil.getConnection();
			String sql="insert into user values(null,?,?,?,?)";
			pps=conn.prepareStatement(sql);
			pps.setString(1, "eee");
			pps.setString(2, "abc");
			pps.setString(3, "老大啊");
			pps.setInt(4, 44);
			int num=pps.executeUpdate();
			if(num>0)
			{
				System.out.println("插入成功");
			}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			JDBCUtil.release(pps, conn);
		}
	}
	
	public static void doUpdate()
	{
		Connection conn=null;
		PreparedStatement pps=null;
		try
		{
			conn=JDBCUtil.getConnection();
			String sql="update user set username=?,password=?,nickname=?,age=? where id=?";
			pps=conn.prepareStatement(sql);
			pps.setString(1, "oppo");
			pps.setString(2, "11111111");
			pps.setString(3, "eclipse");
			pps.setInt(4, 2);
			pps.setInt(5, 6);
			int num=pps.executeUpdate();
			if(num>0)
			{
				System.out.println("插入成功");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.release(pps, conn);
		}
	}
	
	public static void doDelete()
	{
		Connection conn=null;
		PreparedStatement pps=null;
		try
		{
			conn=JDBCUtil.getConnection();
			String sql="delete from user where id=?";
			pps=conn.prepareStatement(sql);
			pps.setInt(1, 6);
			int num=pps.executeUpdate();
			if(num>0)
			{
				System.out.println("删除成功");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.release(pps, conn);
		}
	}
	
	public static void doQuery()
	{
		Connection conn=null;
		PreparedStatement pps=null;
		ResultSet rs=null;
		try
		{
			conn=JDBCUtil.getConnection();
			String sql="select * from user";
			pps=conn.prepareStatement(sql);
			;
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
			JDBCUtil.release(rs,pps, conn);
		}
	}
	
	

}
