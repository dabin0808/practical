package jsu.vo;

/*
 * 购物项，存储一项购物信息
 */
public class CartItem {
	private Book book; 	//包含书的信息
	private int count;  //包含书的数量
	
	//private double subtotal; //小计
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		//小计计算
		return count*book.getPrice();
	}

	
}
