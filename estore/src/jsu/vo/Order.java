package jsu.vo;

import java.util.ArrayList;
import java.util.List;

/*
 * 创建订单Javabean
 */
public class Order {
	//订单的编号
	private String oid;
	//订单总数
	private double total;
	//订单创建的时间
	private String ordertime;
	
	//订单的状态
	private int state;
	//订单的地址
	private String address;
	
	//用户对象 （uid)
	private User user;
	
	//多个订单项
	private List<OrderItem> orderItems  =  new ArrayList<OrderItem>();

	
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	
}
