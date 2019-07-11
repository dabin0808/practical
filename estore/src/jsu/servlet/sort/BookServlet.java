package jsu.servlet.sort;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsu.service.BookService;
import jsu.servlet.BaseServlet;
import jsu.vo.Book;

/**
 * 图书类型所有输出Servlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 查找所有的图书
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BookService bs = new BookService();
		List<Book> booklist = bs.findAll();
		// 设置参数，存入域中
		request.setAttribute("booklist", booklist);

		// 返回页面
		return "/jsps/book/list.jsp";
	}

	/*
	 * 查询根据图书类型的图书
	 */
	public String findCid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 取得主键（类编号）
		String cid = request.getParameter("cid");

		// 处理
		BookService bs = new BookService();
		//取得类编号相同的Book。
		List<Book> booklist = bs.findCid(cid);
		// 设置域
		request.setAttribute("booklist", booklist);
		return "/jsps/book/list.jsp";
	}

	/*
	 * 显示一个图书
	 */
	public String findBid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 取得主键(书编号)
		String bid = request.getParameter("bid");
		
		//处理
		BookService bs = new BookService();
		Book book = bs.findBid(bid);
		//设置域
		request.setAttribute("book", book);
		//返回
		return "/jsps/book/desc.jsp";
		
	}
	
	/*
	 * 搜索相关的内容书本
	 */
	public String search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 取得输入内容
		String sInput = request.getParameter("sInput");
		
		// 处理
		BookService bs = new BookService();
		//取得类编号相同的Book。
		System.out.println("调用search搜索：");
		List<Book> booklist = bs.search(sInput);
		// 设置域
		for (Book book : booklist) {
			System.out.println(book.getBname()+book.getAuthor());
		}
		request.setAttribute("booklist", booklist);
		return "/jsps/book/list.jsp";
	}
}
