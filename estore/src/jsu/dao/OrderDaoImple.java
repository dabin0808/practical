package jsu.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import jsu.utils.MyJdbcUtil;
import jsu.vo.Book;
import jsu.vo.Order;
import jsu.vo.OrderItem;

public class OrderDaoImple implements OrderDao {
	/*
	 * 保存订单(non-Javadoc)
	 * 
	 * @see estore.jsu.dao.user.OrderDao#saveOrder(java.sql.Connection,
	 * estore.jsu.vo.Order)
	 */
	@Override
	public void saveOrder(Connection conn, Order order) {
		QueryRunner runner = new QueryRunner();
		String sql = "insert into orders value(?,?,?,?,?,?)";
		
		Object[] params = { order.getOid(), order.getTotal(), order.getOrdertime(), order.getState(),
				order.getAddress(), order.getUser().getUid() };
		try {
			runner.update(conn, sql, params);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/*
	 * 保存订单项(non-Javadoc)
	 * 
	 * @see estore.jsu.dao.user.OrderDao#saveOrderItem(java.sql.Connection,
	 * estore.jsu.vo.Order)
	 */
	@Override
	public void saveOrderItem(Connection conn, OrderItem orderItem) {
		QueryRunner runner = new QueryRunner();
		String sql = "insert into orderitem value(?,?,?,?,?)";
		Object[] params = { orderItem.getItemid(), orderItem.getCount(), orderItem.getSubtotal(),
				orderItem.getBook().getBid(), orderItem.getOrder().getOid() };
		try {
			runner.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/*
	 * 根据用户id查找订单(non-Javadoc) 即，订单项+book ->订单信息
	 * 
	 * @see estore.jsu.dao.OrderDao#findUid(java.lang.String)
	 */
	@Override
	public List findUid(String uid) {
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		String sql = "select * from orders where uid=?";

		List<Order> list = null;
		try {
			try {
				list = runner.query(sql, new BeanListHandler<Order>(Order.class), uid);
					
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			
			//如果订单为空的话
			if(list == null) {
				return null;
			}
			//System.out.println("查询order订单：" + list.get(0).getOid() + "   " + list.get(0).getOrdertime());
			// list 集合没有完整(书籍信息）
			for (Order order : list) {
				// 遍历每一个订单
				// 一个用户可以有多个订单，每一个订单又可以有多个订单项 ，即须将多个订单项取出存入订单中
				String oid = order.getOid();
				// 多表查询，在OrderItem 中根据Oid可以知道订单项,查询的是订单项和书的信息
				// 连接两张表，ordersItem.bid = book.bid
				String sql2 = "select * from orderitem o ,book b where o.bid = b.bid and o.oid = ?";
				// 一条记录封装到一个map集合中，再把所有的map存入到一个List集合中。map集合的key是字段名称，map的值是字段对应的值
				List<Map<String, Object>> oblist = runner.query(sql2, new MapListHandler(), oid);

				// 把obList里面的数据封装到OrderItem对象中	 创建一个订单项
				// 取出订单项那部分
				for (Map<String, Object> map : oblist) {
				
					OrderItem orderItem = new OrderItem();
					BeanUtils.populate(orderItem, map);

					// 取出book那部分
					Book book = new Book();
					BeanUtils.populate(book, map);

					// 拼接orderItem对象
					orderItem.setBook(book);

					// 把orderItem 放入order中
					order.getOrderItems().add(orderItem);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return list;
	}

}
