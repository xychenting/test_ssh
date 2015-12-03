package cn.edu.xmu.oneonezero.service;

import cn.edu.xmu.oneonezero.entity.User;

public interface UserManager {  

//为view层提供直接调用的接口
public User getUser(long id);  

public void insertUser(User user);  

public boolean delUser(long id);  

public boolean updateUser(User user);  
}  