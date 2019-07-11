package jsu.dao;

import jsu.vo.User;

public interface UserDao
{

	boolean saveUser(User user);

	User login(User user);
	
}
