package DruidProperties02;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class Demo1 {

	public static void main(String[] args)
	{
		Connection conn=null;
		PreparedStatement stat=null;
		ResultSet rs=null;
		try
		{
			Properties p=new Properties();
			p.load(new FileInputStream("src/druid.properties"));
			DataSource dds=DruidDataSourceFactory.createDataSource(p);
			conn=dds.getConnection();
			String sql="select * from user";
			stat=conn.prepareStatement(sql);
			rs=stat.executeQuery();
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
