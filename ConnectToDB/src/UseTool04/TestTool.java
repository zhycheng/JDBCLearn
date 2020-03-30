package UseTool04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Util.JDBCUtil;

public class TestTool {

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
			
			conn=JDBCUtil.getConnection();
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
