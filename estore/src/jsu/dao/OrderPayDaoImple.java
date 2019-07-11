package jsu.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import jsu.utils.MyJdbcUtil;
import jsu.vo.Order;

/*
 * 修改地址和支付结果
 */

public class OrderPayDaoImple implements OrderPayDao {

	/*
	 * 根据订单id，修改地址和支付结果(non-Javadoc)
	 * 
	 * @see jsu.dao.OrderPayDao#aPayAndAdderss(java.lang.String, java.lang.String)
	 */
	@Override
	public void aPayAndAdderss(String orderId, String address) {
		
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		Connection conn = null;
		try {
			conn = MyJdbcUtil.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//执行数据库操作，根据id查找到订单，然后修改支付结果（state），地址(address)
		//1，查询出这个订单
		String sql = "update orders set address=?, state=? where oid=?";
		Object[] params = new Object[3];
		params[0]=address;
		params[1]=2;
		params[2]=orderId;
		System.out.println("订单  "+params[0]+" ad:   "+params[1]+"     数组0   "+params[2]);
		try {
			System.out.println("订单"+orderId+" ad:"+address);
			
			int i =runner.update(sql,params[0],params[1],params[2]);
			
			System.out.println("sql 语句"+i);
			
		} catch (SQLException e) {
			 e.printStackTrace();
		 throw new RuntimeException (e);
		 }
		
	}

}
