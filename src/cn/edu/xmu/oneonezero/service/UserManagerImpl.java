package cn.edu.xmu.oneonezero.service;

import cn.edu.xmu.oneonezero.dao.UserDao;
import cn.edu.xmu.oneonezero.entity.User;

public class UserManagerImpl implements UserManager {

	private UserDao userDao; //创建一个UserDao实例

	public void setUserDao(UserDao userDao) {  
	    this.userDao = userDao;
	}


	@Override
	public boolean delUser(long id) {
		return userDao.delUser(id);
	}


	@Override
	public User getUser(long id) {
		return userDao.getUser(id);
	}

	@Override
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

}
