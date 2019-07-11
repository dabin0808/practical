package jsu.service;

import java.util.List;

import jsu.dao.BookDao;
import jsu.dao.BookDaoImple;
import jsu.vo.Book;

/*
 * 所有图书业务处理
 */
public class BookService {
	/*
	 * 查询所有的图书
	 * 返回
	 */
	public List<Book> findAll() {
		BookDao dao = new BookDaoImple();
		
		return dao.findAll();
	}
	/*
	 * 根据类型查询图书
	 */
	public List<Book> findCid(String cid) {
			BookDao dao = new BookDaoImple();
		
		return dao.findCid(cid);
	}
	/*
	 * 根据类型查询图书
	 */
	public Book findBid(String bid) {
			BookDao dao = new BookDaoImple();
		
		return  dao.findBid(bid);
	}
	/*
	 * 搜索相关的书籍
	 */
	public List<Book> search(String sInput) {
		
		BookDao dao = new BookDaoImple();
		
		return  dao.search(sInput);
	}
	
	
}	
