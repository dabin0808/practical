package jsu.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.List;

import jsu.vo.Order;
import jsu.vo.OrderItem;
/*
 * 保存订单和订单项
 */
public interface OrderDao {

	void saveOrder(Connection conn, Order order);
	
	void saveOrderItem(Connection conn, OrderItem orderItem);

	List findUid(String uid);


}
