package jsu.servlet.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsu.service.OrderPayService;
import jsu.service.OrderService;
import jsu.servlet.BaseServlet;

/**
    * 订单的支付
 * Servlet implementation class OrderPay
 */
@WebServlet("/OrderPay")
public class OrderPay extends BaseServlet {
	private static final long serialVersionUID = 1L;
  
    /*
               * 订单的支付根据用户id
     */
	public String orderPay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取得地址，支付方式（只保存是否支付）
		String address = request.getParameter("address");
		//订单的id
		String orderId = request.getParameter("orderId");
		
		//新建处理，调用修改地址和支付结果
		OrderPayService os = new OrderPayService();
		System.out.println("修改支付方式");
		System.out.println("信息"+address+"   Oreder  "+orderId);
		os.aPayAndAddress(orderId,address);
		
		return "pay.jsp";
	}


}
