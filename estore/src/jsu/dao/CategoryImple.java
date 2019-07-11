package jsu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import jsu.utils.MyJdbcUtil;
import jsu.vo.Category;

public class CategoryImple implements CategoryDao {
	/*
	 * 读取数据库的分类
	 * @see estore.jsu.dao.user.CategoryDao#findAll()
	 */
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		
		try {
			return runner.query("select * from category", new BeanListHandler<Category>(Category.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException (e);
		}
		
	}

}
