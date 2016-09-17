package com.bx.service;

import com.bx.entity.User;

/**
 * @date 2016年4月1日 UserDao.java
 * @author CZP
 * @parameter
 */
public interface UserService {

	public User login(User user) throws Exception;

	public void update(User user);

}
