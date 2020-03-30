package ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.LearnJDBC.JDBCUtil;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pps=null;
		ResultSet rs=null;
		Demo1 d=null;
		try
		{
			d=new Demo1();
			conn=d.getConnection();
			String sql="select * from account";
			pps=conn.prepareStatement(sql);
			
			rs=pps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getDouble("money"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//JDBCUtil.release(rs, pps, conn);
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pps!=null)
			{
				try {
					pps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			d.addBack(conn);
		}
	}

}
