package jsu.vo;
/*
 * 订单项
 */
public class OrderItem {
	//订单项编号
	 private String itemid;
	 //数量
	 private int count;
	 //小计
	 private double subtotal;
	 
	 //bid 用对象接
	 private Book book;
	 //原本order.oid的 ，而现在使用对象接。订单编号
	 private Order order;
	 
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}

	 
	 
}
