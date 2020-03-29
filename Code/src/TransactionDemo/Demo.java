package TransactionDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.LearnJDBC.JDBCUtil;

public class Demo {

	public static void main(String[] args) {
		
		Test1();
	}
	
	public static void Test1()
	{
		Connection conn=null;
		PreparedStatement pps=null;
		try
		{
			conn=JDBCUtil.getConnection();
			//conn.setAutoCommit(false);
			String sql="update account set money=money+? where name=?";
			//预编译sql
			pps=conn.prepareStatement(sql);
			pps.setDouble(1, -1000);
			pps.setString(2, "aaa");
			pps.executeUpdate();
			//中间出现异常
			int a=2/0;
			pps.setDouble(1, 1000);
			pps.setString(2, "bbb");
			pps.executeUpdate();
			//conn.commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally
		{
			JDBCUtil.release(pps, conn);
		}
	}

}
