import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class DBUtilsQuery_ResultSetHandler_Other {



	public static void main(String[] args) throws SQLException {
		//doColumnListHandler();
		//doScalarHandler();
		doKeyedHandler();
	}
	//ColumnListHandler
	public static void doColumnListHandler() throws SQLException
	{
		QueryRunner qr=new QueryRunner(JDBCUtils.getInstance().getDataSource());
		List<Object> list=  qr.query("select name,money from account",new ColumnListHandler<Object>("name"));
		System.out.println(list);
	}
	//ScalarHandler
	public static void doScalarHandler() throws SQLException
	{
		QueryRunner qr=new QueryRunner(JDBCUtils.getInstance().getDataSource());
		Object aa=qr.query("select count(*) from account",new ScalarHandler());
		System.out.println(aa);
	}
	
	//KeyedHandler
	//一条记录一个map，多条记录放在嵌套的map中
	public static void doKeyedHandler() throws SQLException
	{
		QueryRunner qr=new QueryRunner(JDBCUtils.getInstance().getDataSource());
		Map<String, Map<String, Object>> mp= qr.query("select  * from account",new KeyedHandler<String>("name"));
		for(String a:mp.keySet())
		{
			System.out.println(a+" "+mp.get(a));
		}
		
	}
	
	

}
