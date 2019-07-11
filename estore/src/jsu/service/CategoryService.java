package jsu.service;

import java.util.List;

import jsu.dao.CategoryDao;
import jsu.dao.CategoryImple;
import jsu.vo.Category;

/*
 * 分类业务处理
 */
public class CategoryService {
	/*
	 * 查询所有的分类
	 */
	public List<Category> findAll() {
		CategoryDao dao = new CategoryImple();
		
		return dao.findAll();
	}
	
	
}
