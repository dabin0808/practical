package jsu.vo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
 * 购物车,存储多项书籍
 */
public class Cart {
	// 总计
	private double total;
	
	//构造方法
	private Cart() {}
	
	 private static Cart instance = null;
	// 静态工厂方法
	    public static Cart getInstance() {
	        if(instance == null) {
	        	instance = new Cart();
	        }
	    	return instance;
	    }
	
	// 保存多项书籍（加入购物车的）
	Map<String, CartItem> map = new HashMap<String, CartItem>();

	// 包含方法(向购物车添加购物项，删除某一个购物项，清空购物车）
	/*
	 * 向购物车添加购物项 添加map中 *存在的话，计算加入 *不存在就，添加map中，总计变
	 */
	public void addCart(CartItem item) {
		String bookId = item.getBook().getBid();
		// 判断是否已经有了
		if (map.containsKey(bookId)) {
			// 直接加入，count+=就好了
			CartItem historyGartItem = map.get(bookId);
			historyGartItem.setCount(historyGartItem.getCount() + item.getCount());

		} else {
			// 说明map中没有该购物项，把书存入map中。
			map.put(bookId, item);
		}
		// 计算总计
		total += item.getSubtotal();
	}

	/*
	 * 删除某一个购物项 根据图书ID把购物项从map中删除 总计 = 总计-购物项小计
	 */
	public void removeCart(String bookId) {
		// 从map中移除一项购物项
		CartItem item = map.remove(bookId);
		// 计算总计
		total -= item.getSubtotal();

	}

	/*
	 * 清空购物车,清空map，total也归0
	 */
	public void clerCart() {
		map.clear();
		total = 0;
	}

	// 给出map
	public Map<String, CartItem> getMap() {
		return map;
	}

	// 给出总计
	public double getTotal() {
		return total;
	}

	// 相当于cartItem --Cart是javabean的一个属性${cart.cartItems}--获取的Callection 的集合
	// c:forEach	cart.cartItems 
	public Collection<CartItem> getCartItems() {
		return map.values();
	}
	
	
}
