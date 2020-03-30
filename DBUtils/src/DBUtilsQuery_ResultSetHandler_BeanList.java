import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class DBUtilsQuery_ResultSetHandler_BeanList {

	public static void main(String[] args) throws SQLException {
		//queryMultiple();
		queryMultipleList();
	}
	//ArrayHandler
	public static void queryMultiple() throws SQLException
	{
		QueryRunner qr=new QueryRunner(JDBCUtils.getInstance().getDataSource());
		Account aa=qr.query("select * from account where id=?",new BeanHandler<Account>(Account.class),1);
		
		System.out.println(aa);
	}
	//ArrayListHandler
	public static void queryMultipleList() throws SQLException
	{
		QueryRunner qr=new QueryRunner(JDBCUtils.getInstance().getDataSource());
		List<Account> aa=qr.query("select * from account",new BeanListHandler<Account>(Account.class));
		for(Account a : aa)
		{
			System.out.println(a);
		}
		
	}

}
