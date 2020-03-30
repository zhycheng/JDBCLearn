package Util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil {
	
	private static final ComboPooledDataSource dataSource=new ComboPooledDataSource();
	
	public static Connection getConnection()
	{
		Connection conn=null;
		try {
			conn= dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static DataSource getDataSource()
	{
		return dataSource;
	}
}
