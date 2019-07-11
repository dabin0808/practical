package jsu.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import jsu.utils.MyJdbcUtil;
import jsu.vo.User;

/*
 * 用户相关的持久层代码
 */
public class UserDaoImple implements UserDao {
	/*
	 * 注册用户
	 */
	@Override
	public boolean saveUser(User user) {
		boolean flag = false;
		
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		String sql = "insert into user value(?,?,?,?,?,?)";
		Object[] params = { user.getUid(), user.getUsername(), user.getPassword(), user.getEmail(), user.getState(),
				user.getCode() };
		try { // 注册方法
			int count = runner.update(sql, params);
			// 返回值判断
			if (count > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return flag;
	}

	/*
	 * 登录的功能
	 * 
	 * @see estore.jsu.dao.user.UserDao#login(estore.jsu.vo.User)
	 */
	@Override
	public User login(User user)
	{
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		String sql = "select * from user where username = ? and password = ?";
		
		try
		{	//查询，
			return runner.query(sql, new BeanHandler<User>(User.class),user.getUsername(),user.getPassword());
		} catch (SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
