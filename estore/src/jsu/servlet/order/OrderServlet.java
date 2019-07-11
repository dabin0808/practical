package jsu.servlet.order;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsu.service.OrderService;
import jsu.servlet.BaseServlet;
import jsu.utils.MyUUIDUtil;
import jsu.vo.Cart;
import jsu.vo.CartItem;
import jsu.vo.Order;
import jsu.vo.OrderItem;
import jsu.vo.User;

/**
 * 订单servlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
   	
	/**
	 * 把购物车添加入订单 Order
	 * 订单<-订单项
	 * 购物车<-购物项
	 */
	public String addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//设置一个订单
		Order order = new Order();
		
		//订单主键
		order.setOid(MyUUIDUtil.getUUID());
		//订单地址
		order.setAddress(null);
		//订单时间
		order.setOrdertime(null);
		//订单状态	1 未付款 2已付款 未发货 3 已发货，未收货  4，订单完成
		order.setState(1);
		
		//购物车
		//Cart cart = (Cart)request.getSession().getAttribute("cart ");
			Cart cart = (Cart)request.getServletContext().getAttribute("cart");
			//购物车为空 
			if(cart == null) {
				request.setAttribute("msg", "您的购物车为空");
				return "/jsps/msg.jsp";
			}
		//订单小计
		order.setTotal(cart.getTotal());

		//用户
			User existUser =(User) request.getSession().getAttribute("exisUser");
			System.out.println("用户信息"+existUser.getUsername());
			order.setUser(existUser);
		//设置订单下的所有订单项
		//	order.setOrderItems(orderItems);
		//订单项与购物项是相同的,获取购物项
			for(CartItem cartItem: cart.getCartItems()) {
				//把购物项（cartItem）封装到订单项（OrderItem）
				OrderItem item = new OrderItem();
				//数量
				item.setCount(cartItem.getCount());
				//小计
				item.setSubtotal(cartItem.getSubtotal());
				//一本书籍的对象
				item.setBook(cartItem.getBook());
				//随机的ItemID(主键）
				item.setItemid(MyUUIDUtil.getUUID());
				//order
				item.setOrder(order);
				//订单项添加入订单list
				order.getOrderItems().add(item);
				
			}
			//输出订单和订单项
			System.out.println("订单：地址"+order.getAddress()+" ID: "+order.getOid());
			System.out.println("订单项："+order.getOrderItems().get(0).getItemid()+"dd订单项"+order.getOrderItems().get(0).getOrder().getOid());
			//处理
			OrderService os = new OrderService();
			//保存
			os.save(order);
			
			System.out.println("已经加入订单了");
			
			//清空购物车
			cart.clerCart();
			
			//把订单，返回到页面
			request.setAttribute("order", order);
			return "jsps/order/desc.jsp";
	}
	
	/*
	  * 通过用户id，查询用户的订单
	 */
	public String findUid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IllegalAccessException, InvocationTargetException  {
		//从session中获取用户的id
		User user = (User) request.getSession().getAttribute("exisUser");
		
		//调用业务层，处理
		OrderService os = new OrderService();
		
		List<Order> oList = os.findUid(user.getUid());
		
		if(oList.size()==0) {
			request.setAttribute("msg", "您还没有提交订单呢");
			return "/jsps/msg2.jsp";
		}
		// 向request域中
		
		request.setAttribute("obList", oList);
		
		System.out.println("用户id订单查询完成"+oList.get(0).getOid() +oList.get(0).getTotal());
		
		return "/jsps/order/list.jsp";
	}
	
}










