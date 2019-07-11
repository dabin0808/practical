package jsu.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import jsu.dao.OrderDao;
import jsu.dao.OrderDaoImple;
import jsu.utils.MyJdbcUtil;
import jsu.vo.Order;
import jsu.vo.OrderItem;
import jsu.vo.User;

public class OrderService {

	public void save(Order order) {
		//得保存订单，，-》》》订单里面还有订单项也需要保存
		//insert into orders  values()	insert into orderitem valuse();
		Connection conn = null;
		try {
			//开启事物
			conn = MyJdbcUtil.getConnection();
			//添加操作
			conn.setAutoCommit(false);
			
			OrderDao dao = new OrderDaoImple();
			//保存订单
		
			dao.saveOrder(conn,order);
			
			//保存订单项
			for (OrderItem orderItem : order.getOrderItems()) {
				dao.saveOrderItem(conn,orderItem);
			}
			
			//提交事务
			DbUtils.commitAndCloseQuietly(conn);
			
		} catch (SQLException e) {
			System.out.println("事务回滚了");
			DbUtils.rollbackAndCloseQuietly(conn);
			//遇到问题，回滚事务
			e.printStackTrace();
		}
		
		//添加操作
		//提交事物
		//遇到问题回滚
		
	}

	/*
	 * 根据Uid查找订单和订单项
	 */
	public List findUid(String Uid) throws IllegalAccessException, InvocationTargetException {
		
		OrderDao dao = new OrderDaoImple();
		System.out.println("开始查询订单：");
		return dao.findUid(Uid);
	}


}
