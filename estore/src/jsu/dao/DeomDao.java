package jsu.dao;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Connection;

import jsu.utils.MyJdbcUtil;
import jsu.vo.Book;


/**
 * @author MAIBENBEN
 * @version 1.0
 * @data 2019年6月29日 下午9:06:24
 * @description:
 */
public class DeomDao {

	public static void main(String[] args) throws PropertyVetoException, SQLException {
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		String bid ="001";
		Book book = new Book();
		try {
			//查询与一个图书名相同的book
			book =  runner.query("select * from book where bid=?", new BeanHandler<Book>(Book.class), bid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		System.out.println(book.getAuthor()+"  123");
	}
	
	
	
}


