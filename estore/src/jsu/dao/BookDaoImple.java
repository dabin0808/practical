package jsu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.management.RuntimeErrorException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import jsu.utils.MyJdbcUtil;
import jsu.vo.Book;

public class BookDaoImple implements BookDao {
	/*
	 * 查询所有的分类
	 * 
	 * @see estore.jsu.dao.user.BookDao#findAll()
	 */
	@Override

	public List<Book> findAll() {
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());

		try {
			//查找书籍未被删除的 0
			return runner.query("select * from book where isdel=?", new BeanListHandler<Book>(Book.class), 0);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/*
	 * 查询根据类型的图书
	 * 
	 * @see estore.jsu.dao.user.BookDao#findCid()
	 */
	@Override
	public List<Book> findCid(String cid) {

		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			return runner.query("select * from book where cid=? and isdel=?", new BeanListHandler<Book>(Book.class),
					cid, 0);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/*
	 * 查询一种图书
	 * 
	 * @see estore.jsu.dao.user.BookDao#findCid()
	 */
	@Override
	public Book findBid(String bid) {
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		try {
			//查询与一个图书名相同的book
			return runner.query("select * from book where bid=?", new BeanHandler<Book>(Book.class), bid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	
	/*
	 * 搜索相关的书籍
	 * 模糊查询
	 */
	public List<Book> search(String sInput) {
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		String sql = "select * from book where concat(bname,author,price) like ?";
		
		try {
			return runner.query(sql,new BeanListHandler<Book>(Book.class), "%"+sInput+"%");
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

}
