package jsu.service;

import jsu.dao.UserDao;
import jsu.dao.UserDaoImple;
import jsu.utils.MyUUIDUtil;
import jsu.vo.User;

/*
 * 用户相关的业务类
 */
public class UserService
{
	/*
	 * 业务层注册用户
	 */
	public boolean registUser(User user)
	{
		//调用持久层代码注册用户
		UserDao dao = new UserDaoImple();
		System.out.println("//调用持久层代码注册用户");
		//添加业务
		/**
		 * 用户主键（字符串类型）
		 *用户状态设置0
		 *生成激活码
		 */
	
		//生成主键，随机32位UUID码
		user.setUid(MyUUIDUtil.getUUID());
		//设置状态码为0
		user.setState(0);
		
		//生成激活码
		String code = MyUUIDUtil.getUUID()+MyUUIDUtil.getUUID();
		
		
		//发送一份邮件
		user.setCode(code);
		return dao.saveUser(user);
	}
	


	public User login(User user)
	{
		UserDao dao = new UserDaoImple();
		
		return dao.login(user);
	}
}
