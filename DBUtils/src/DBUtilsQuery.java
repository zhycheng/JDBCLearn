import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

public class DBUtilsQuery {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//querySingle();
		queryMultiple();
	}
	public static void queryMultiple() throws SQLException
	{
		QueryRunner qr=new QueryRunner(JDBCUtils.getInstance().getDataSource());
		List<Account> acList=qr.query("select * from account", new ResultSetHandler<List<Account>>() {

			@Override
			public List<Account> handle(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub 
				List<Account> list=new ArrayList<Account>();
				while(rs.next())
				{
					Account ac=new Account();
					ac.setId(rs.getInt("id"));
					ac.setName(rs.getString("name"));
					ac.setMoney(rs.getDouble("money"));
					list.add(ac);
				}
				return list;
			}	
		});
		for(int i=0;i<acList.size();i++)
		{
			System.out.println(acList.get(i));
		}
		
	}
	
	public static void querySingle() throws SQLException
	{
		QueryRunner qr=new QueryRunner(JDBCUtils.getInstance().getDataSource());
		Account ac=qr.query("select * from account where id=?", new ResultSetHandler<Account>() {
			@Override
			public Account handle(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				Account ac=new Account();
				if(rs.next())
				{
					ac.setId(rs.getInt("id"));
					ac.setName(rs.getString("name"));
					ac.setMoney(rs.getDouble("money"));
				}
				return ac;
			}
			
		},1);
		System.out.println(ac);
	}

}
