import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

public class DBUtilsQuery_ResultSetHandler {

	public static void main(String[] args) throws SQLException {
		//queryMultiple();
		queryMultipleList(); 
	}
	//ArrayHandler
	public static void queryMultiple() throws SQLException
	{
		QueryRunner qr=new QueryRunner(JDBCUtils.getInstance().getDataSource());
		Object[] aa=qr.query("select * from account where id=?",new ArrayHandler(),1);
		
		System.out.println(Arrays.toString(aa));
	}
	//ArrayListHandler
	public static void queryMultipleList() throws SQLException
	{
		QueryRunner qr=new QueryRunner(JDBCUtils.getInstance().getDataSource());
		List<Object[]> aa=qr.query("select * from account",new ArrayListHandler());
		for(Object[] a : aa)
		{
			System.out.println(Arrays.toString(a));
		}
		
	}

}
