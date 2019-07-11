package jsu.servlet.sort;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsu.service.CategoryService;
import jsu.servlet.BaseServlet;
import jsu.vo.Category;


/**
 * 分类显示
 * Servlet 
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
                * 查询所有的书籍类型信息，转发left.jsp
     */
    public String findAll(HttpServletRequest request,HttpServletResponse response) {
	
    	CategoryService cs = new CategoryService();
    	
    	List<Category> clist = cs.findAll();
    	
    	//输出测试
    	for(Category e:clist)
    		System.out.println(e.getCname());
    	
    	//封装到request域，中
    	request.setAttribute("clist", clist);
    	return "/jsps/left.jsp";
        
    }

}
