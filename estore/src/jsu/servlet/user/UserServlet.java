package jsu.servlet.user;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.mchange.v2.beans.BeansUtils;
import com.mchange.v2.codegen.bean.BeangenUtils;

import jsu.service.UserService;
import jsu.servlet.BaseServlet;
import jsu.vo.User;

/**
 * 用户相关的Servlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see 注册用户的方法
	 */
	public String registUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// 接收数据
		// 封装数据
		// 处理数据
		// 显示数据

		// 接收数据
		Map<String, String[]> map = request.getParameterMap();
		
		
		System.out.println("Map数据：");
		for (String[] sc : map.values()) {
			System.out.println(sc+"  ");
		}
		// 封装数据
		
		User user = new User();
		System.out.println("Regist函数调用");
		try
		{
			
			BeanUtils.populate(user, map);
			// 处理数据
			// 调试
			System.out.println("调试数据"+user.getUsername()+"sdsdssa");
			
			UserService us = new UserService();

			// 注册用户
			boolean flag = us.registUser(user);
			// 调用返回的结果，调用不同页面处理
			if (flag == false)
			{
				// 向request域中存入消息
				request.setAttribute("msg", "注册失败！");
			} else
			{
				// 向request域中存入消息
				request.setAttribute("msg", "注册成功！");
			}

		} catch (Exception e)
		{	
			e.printStackTrace();
		}
		
		return "/jsps/msg.jsp";
	}

	/*
	    * 登录功能
	 */
	public String login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		//获取数据
		//封装数据
		//处理数据
		//显示数据
		
		//获取数据
		Map<String, String[]>map= request.getParameterMap();
		
		User user = new User();
		//封装数据
		try
		{
			BeanUtils.populate(user, map);
			System.out.println("111111111 login " +user.toString());
			UserService us =new UserService();
			//登录功能
			User exisUser = us.login(user);
			//如果登录失败，给出用户提示
			if(exisUser == null) {
				request.setAttribute("msg", "用户名或者密码错误");
				return "/jsps/msg.jsp";
			}else {
				//登录成功，把用户信息保存session中
				request.getSession().setAttribute("exisUser", exisUser);
				//转发，main
				request.setAttribute("msg", "欢迎您");
				return "/jsps/main.jsp";
			}//如果登录成功，把用户信息保存到session中，转发mian
			
		} catch (Exception e)
		{	
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 退出
	 */
	public String exit(HttpServletRequest request, HttpServletResponse response) {
		//session.invalid
		request.getSession().invalidate();
		return "index.jsp";
		
	}
	
/*	
	 * 验证查找用户id
	 
	public boolean finUid(HttpServletRequest request, HttpServletResponse response) {
		//
		request.getSession().invalidate();
		return false;
		
	}*/
}












