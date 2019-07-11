package jsu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 检查是否
 */
@WebFilter(urlPatterns= {"/*"},initParams= {
		//@WebInitParam(name ="s1",value="/jsps/cart/list.jsp"),
		//@WebInitParam(name="s2",value=""),
		
	}
)
public class CheckLoginFilter implements Filter {

   private FilterConfig config;

	public void init(FilterConfig fConfig) throws ServletException {
		this.config= fConfig;
	}

    
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//参数初始化
		String s1 = config.getInitParameter("s1");
		//String s2 = config.getInitParameter("s2");
		//获取会话对象，
		HttpSession session = ((HttpServletRequest)request).getSession();
		//获取请求资源路径
//		String requestPath =((HttpServletRequest)request).getServletPath();
		String url = ((HttpServletRequest)request).getRequestURI();
		System.out.println(session.getAttribute("exisUser") + "---");
		System.out.println(url + "+++");
		
		//如果满足条件，不进行拦截
		if(!(session.getAttribute("exisUser") == null && url.indexOf("list.jsp") >= 0)) {
			chain.doFilter(request, response);
		}else {
			//对请求进行拦截，返回登陆页面
			request.setAttribute("msg", "请先登陆");
			request.getRequestDispatcher("msg2.jsp").forward(request, response);
			
		}
		
	}
	
	public void destroy() {
    	this.config= null;
	}

	
}
