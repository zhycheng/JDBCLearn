package ConnectionPool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.LearnJDBC.JDBCUtil;

public class Demo1 implements DataSource{
	//在初始化的时候提供一些连接
	private List<Connection> connList=new ArrayList<Connection>();
	
	public Demo1()
	{
		//初始化连接
		for(int i=0;i<3;i++)
		{
			connList.add(JDBCUtil.getConnection());
		}
		
	}
	
	
	
	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=connList.remove(0);
		return conn;
	}
	
	public void addBack(Connection conn)
	{
		connList.add(conn);
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



}
