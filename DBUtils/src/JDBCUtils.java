

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;



public class JDBCUtils {
	DataSource ds=null;
	private static JDBCUtils instance;
	public static JDBCUtils getInstance()
	{
		if(instance==null)
		{
			instance=new JDBCUtils();
		}
		return instance;
	}
	private JDBCUtils()
	{
		Properties p=new Properties();
		try {
			p.load(new FileInputStream("src/druid.properties"));
			ds=DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public Connection getConnection()
	{
		Connection conn=null;
		try {
			conn=ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public DataSource getDataSource()
	{
		return this.ds;
	}
	
	
}
