package jsu.servlet.user;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsu.service.VerifyUserService;

/**
    * 用户验证
 * Servlet implementation class VerifyUserId
 */
@WebServlet("/VerifyUserId")
public class VerifyUserId extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * 验证用户的ID
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//取得id
		String userid = request.getParameter("userid");
		//进行id业务
		VerifyUserService vs =new VerifyUserService();
		
		boolean flag = vs.verifyUserFindId(userid);
		
		//flag不为0的话，表示已经存在了
		System.out.println(flag);
		if(flag==true) {
			response.getWriter().print("NAME已经存在了");
		}else {
			response.getWriter().print("NAME可以使用");
		}
		
		
		
	}

}
