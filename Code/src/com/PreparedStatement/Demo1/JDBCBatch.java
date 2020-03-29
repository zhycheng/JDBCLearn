package com.PreparedStatement.Demo1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.LearnJDBC.JDBCUtil;

public class JDBCBatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//demo1();
		demo2();
	}
	
	public static void demo1()
	{
		Connection conn=null;
		Statement stmt=null;
		try
		{
			conn=JDBCUtil.getConnection();
			stmt=conn.createStatement();
			String sql1="create database test1";
			String sql2="use test1";
			String sql3="create table user(id int primary key auto_increment,name varchar(20))";
			String sql4="insert into user values(null,'aaa')";
			String sql5="insert into user values(null,'bbb')";
			String sql6="insert into user values(null,'ccc')";
			String sql7="update user set name='mmm' where id=2";
			String sql8="delete from user where id=1";
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			stmt.addBatch(sql3);
			stmt.addBatch(sql4);
			stmt.addBatch(sql5);
			stmt.addBatch(sql6);
			stmt.addBatch(sql7);
			stmt.addBatch(sql8);
			stmt.executeBatch();
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			JDBCUtil.release(stmt, conn);
		}
	}
	/**
	 * 批处理
	 */
	public static void demo2()
	{
		long begin=System.currentTimeMillis();
		Connection conn=null;
		PreparedStatement stmt=null;
		try
		{
			conn=JDBCUtil.getConnection();
			String sql="insert into user values(null,?)";
			stmt=conn.prepareStatement(sql);
			for(int i=1;i<=1000;i++)
			{
				stmt.setString(1,"name"+i);
				stmt.addBatch();
				if(i%100==0)
				{
					stmt.executeBatch();
					stmt.clearBatch();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.release(stmt, conn);
		}
		long end=System.currentTimeMillis();
		System.out.println(end-begin);
	}

}
