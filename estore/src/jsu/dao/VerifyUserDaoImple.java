package jsu.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import jsu.utils.MyJdbcUtil;

/*
 * 验证用户
 */
public class VerifyUserDaoImple implements VerifyUserDao{
	

	/*
	  *  登录验证用户的id
	 * (non-Javadoc)
	 * @see estore.jsu.dao.VerifyUserDao#verifyUserFindId(java.lang.String)
	 */
	@Override
	public Long verifyUserFindId(String userId) {
		//创建连接，SQL
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		String sql = "select count(username) from user where username=?";

		long count;
		try {
			count = (long) runner.query(sql, new ScalarHandler(), userId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return count;
	}

}
