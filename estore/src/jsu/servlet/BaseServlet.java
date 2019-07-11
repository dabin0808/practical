package jsu.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 通用servlet
 */
public class BaseServlet extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{	
		//设置编码
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		// 进行一些控制
		// 对用户一些要求，servletdome调用方法 http://localhost/estore/dome?method=addUser
		// addUser方法的签名也有要求，addUser（HTTPServletRequest
		// request，HTTPServletResponse response）
		// 参数也必须是request，response。
		// 获取method参数
		String methodName = req.getParameter("method");
		
		//输出测试method值
		System.out.println("1result值："+methodName);
		
		if (methodName == null || methodName.trim().isEmpty())
		{// 去掉空格
			throw new RuntimeException("亲，请你传入method参数");
		}

		// 通过反射机制，完成
		// 获取class对象，获取method对象，相当于获得addUser。。。方法
		Class cla = this.getClass();
		Method method = null;
		try
		{
			method = cla.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			System.out.println("method="+method);
		} catch (Exception e)
		{
			throw new RuntimeException("亲，您传入的" + methodName + "不存在");
		}
		// method 已经有值了 
		//方法调用
		try
		{	//result 保存	,接收方法返回值	//jsps/msg.jsp 
			String result = (String)method.invoke(this, req, resp);
			System.out.println("2result值："+result);
			
			//请求转发
			if(result!=null && !result.trim().isEmpty()){
				req.getRequestDispatcher(result).forward(req, resp);
				//resp.sendRedirect(req.getContextPath() + result);
				System.out.println("请求转发了");
			}
			
		} catch (Exception e)
		{
			System.out.println("程序内部出问题了");
			throw new RuntimeException(e);
		}

		/*
		 * //简单调用
		 * 
		 * if("addUser".equals(method)){ addUser(req, resp); }else
		 * if(method.equals("updateUser")){ updateUser(req, resp); }
		 */

	}

	
}
