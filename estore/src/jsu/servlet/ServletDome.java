package jsu.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDome
 */
@WebServlet("/ServletDome")
public class ServletDome extends BaseServlet{

	/**
	 * 添加
	 */
	public String addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		System.out.println("addUser..");
		response.getWriter().println("addUser..");
		// 请求转发 request.getRequestDispatcher("").forward(request, response);

		// 重定向, 则return null
		//response.sendRedirect("");

		// 请求转发路径 ，
		return "";
	}

	/**
	 * 更新
	 */
	public String updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		System.out.println("updateUser...");
		// 重定向, 则return null
		//response.sendRedirect("");

		// 转发路径 ，
		return "";
	}

	/**
	 * 删除
	 */
	public String delUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("delUser...");
		// 重定向, 则return null
		//response.sendRedirect("");

		// 转发路径 ，
		return "";
	}
}
