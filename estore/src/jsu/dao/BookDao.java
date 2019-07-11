package jsu.dao;

import java.util.List;

import jsu.vo.Book;

public interface BookDao {

	List<Book> findAll();

	List<Book> findCid(String cid);

	Book findBid(String bid);
	
	/*
	 * 搜索相关的书籍
	 */
	List<Book> search(String sInput);
}
