import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

public class DBUtilsAddDeleteUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//doInsert();
		//doUpdate();
		doDelete();
	}
	
	public static void doInsert()
	{
		QueryRunner qr=new QueryRunner(JDBCUtils.getInstance().getDataSource());
		try {
			qr.update("insert into account values(null,?,?)","ddd",12000);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void doUpdate()
	{
		QueryRunner qr=new QueryRunner(JDBCUtils.getInstance().getDataSource());
		try {
			qr.update("update account set name=?,money=? where id=?","uuuuu",34,4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void doDelete()
	{
		QueryRunner qr=new QueryRunner(JDBCUtils.getInstance().getDataSource());
		try {
			qr.update("delete from  account  where id=?",4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
