package jsu.service;

import jsu.dao.VerifyUserDao;
import jsu.dao.VerifyUserDaoImple;
import jsu.vo.User;

/*
 * 用户验证的处理层
 */
public class VerifyUserService {
	
	
	/*
	 *验证用户的id是否已经存在 
	 */
	public boolean verifyUserFindId(String userId)
	{	
		//创建
		VerifyUserDao dao = new VerifyUserDaoImple();
		//调用处理
		long count =dao.verifyUserFindId(userId);
		
		System.out.println("输出count 值"+count);
		if(count > 0)
			return true;
		return false;
	
	}
}
