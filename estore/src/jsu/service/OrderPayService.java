package jsu.service;

import jsu.dao.OrderPayDao;
import jsu.dao.OrderPayDaoImple;

/*
 * 修改订单的支付，和地址
 */
public class OrderPayService {

	public void aPayAndAddress(String orderId, String address) {
		
		OrderPayDao dao = new OrderPayDaoImple();
		
		dao.aPayAndAdderss(orderId,address);
	}

}
