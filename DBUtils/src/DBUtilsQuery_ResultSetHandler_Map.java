import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

public class DBUtilsQuery_ResultSetHandler_Map {

	public static void main(String[] args) throws SQLException {
		//queryMultiple();
		queryMultipleList();
	}
	//MapHandler
	public static void queryMultiple() throws SQLException
	{
		QueryRunner qr=new QueryRunner(JDBCUtils.getInstance().getDataSource());
		Map<String,Object> aa=qr.query("select * from account where id=?",new MapHandler(),1);
		
		System.out.println(aa);
	}
	//MapListHandler
	public static void queryMultipleList() throws SQLException
	{
		QueryRunner qr=new QueryRunner(JDBCUtils.getInstance().getDataSource());
		List<Map<String,Object>> aa=qr.query("select * from account",new MapListHandler());
		for(Map<String,Object> a : aa)
		{
			System.out.println(a);
		}
		
	}

}
