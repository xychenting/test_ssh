package cn.edu.xmu.oneonezero.dao;

import cn.edu.xmu.oneonezero.entity.User;

public interface UserDao {


public User getUser(long id);  //根据用户ID得到User对象

public void insertUser(User user);  //添加用户到数据库

public boolean delUser(long id);	//根据用户id删除User对象

public boolean updateUser(User user);	//更新用户

}