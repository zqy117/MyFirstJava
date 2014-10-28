package DataBaseManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.sql.RowSet;

import com.sun.rowset.CachedRowSetImpl;

/**
 * 数据库管理类
 * @author qianyuanzhang
 *
 */
public class DateBaseManager {
	private static Connection conn;
	private static Statement st;

	/**
	 * 执行SQL语句(CUD)
	 * @param sqls 需要执行的Sql语句集合
	 * @return 是否执行成功
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static Boolean execute(List<String> sqls) throws ClassNotFoundException, SQLException {

		conn = getConnection();

		try {
			st = conn.createStatement();
			Iterator<String> sqlIter = sqls.iterator();
			while (sqlIter.hasNext()) {
				String sql = sqlIter.next();
				st.executeUpdate(sql);
			}
			conn.commit();
			conn.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			try {// 操作不成功则回退
				conn.rollback();
			}catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
	}

	public static RowSet query(String sql) throws ClassNotFoundException, SQLException {

		Connection conn = getConnection();
		try {
			Statement st = (Statement) conn.createStatement();
			CachedRowSetImpl rowSet = new CachedRowSetImpl();
			ResultSet rs = st.executeQuery(sql);
			rowSet.populate(rs);
			
			rs.close();
			st.close();
			
//			conn.close();
			return rowSet;

		} catch (SQLException e) {
			System.out.println("查询失败" + e.toString());
			return null;
		}
	}


	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		Connection con = null;
		//第一步：加载MySQL的JDBC的驱动
		Class.forName("com.mysql.jdbc.Driver");
        
        //取得连接的url,能访问MySQL数据库的用户名,密码；studentinfo：数据库名
        
        //第二步：创建与MySQL数据库的连接类的实例
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8", "root", "root");
        con.setAutoCommit(false);
        return con;        
	}
}
