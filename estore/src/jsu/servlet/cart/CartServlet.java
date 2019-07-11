package jsu.servlet.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import jsu.service.BookService;
import jsu.servlet.BaseServlet;
import jsu.vo.Book;
import jsu.vo.Cart;
import jsu.vo.CartItem;
import jsu.vo.User;

/**
 * 购物车
 */
@WebServlet("/CartServlet")
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
   /*
    * 添加一个商品到购物车
    */
	public String addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//用户
		User user =(User)request.getSession().getAttribute("exisUser");
		if(user == null) {
			System.out.println("用户没有登陆~~");
			request.setAttribute("msg", "您，还未登录");
			return "/jsps/msg2.jsp";
		}
		//先获取购物车，
		Cart cart = getCart(request);
		
		//先把购物项准备好，直接可以添加进购物车中
		//购物项中包含书的信息，数量(count）,小计(计算的)
		
		 //count值
		String sCount = request.getParameter("count");
		//count 值转化
		Integer count = Integer.valueOf(sCount);
		//从desc中获得bookId主键
		String bookId = request.getParameter("bookId");
		//从数据库中根据主键，取得book对象
		BookService bs = new BookService();
		Book book = bs.findBid(bookId);
		
		//设置购物项
		CartItem item =new CartItem();
		item.setBook(book);
		item.setCount(count);
		
		//添加购物车中
		cart.addCart(item);
		
		System.out.println("验证:数量"+count +"书籍名:"+bookId);
		return "jsps/cart/list.jsp";
		
		
	}
	
	
	/*
	 * 从session中，获取购物车
	 */
	public Cart getCart(HttpServletRequest request) {
		
		Cart cart = (Cart)request.getServletContext().getAttribute("cart");
		//判断是否第一次，如果没有购物车就再建一个，再存入session中。第二次访问即可；
			if(cart == null) {
				 cart = Cart.getInstance();
				 //存入session中
				
				 request.getServletContext().setAttribute("cart", cart);
			}
		return cart;
		
	}
	/*
	 * 移除购物车中的一个购物项
	 */
	public String removeCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//先获取购物车，
		Cart cart = getCart(request);
		String bid = request.getParameter("bid");
		
		//移除
		cart.removeCart(bid);
		return "jsps/cart/list.jsp";
		
	}
	/*
	 * 清空购物车
	 */
	public String clearCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//先获取购物车，
		Cart cart = getCart(request);
	
		//清空
		cart.clerCart();
		return "jsps/cart/list.jsp";
		
	}
	
}
