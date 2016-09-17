package com.bx.service.impl;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bx.dao.BaseDAO;
import com.bx.entity.User;
import com.bx.service.UserService;
import com.bx.util.MD5Util;

/**
 * @date 2016年4月1日 UserDaoImpl.java
 * @author CZP
 * @parameter
 */

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private BaseDAO<User> baseDAO;

	@Override
	public User login(User user) throws Exception {
		StringBuffer hql = new StringBuffer();
		List<Object> param = new LinkedList<>();
		hql.append(" from User ");
		if (user != null) {
			hql.append(" where userName=? and password =? ");
			param.add(user.getUserName());
			param.add(MD5Util.EncodeByMD5(user.getPassword()));
		}
		return baseDAO.get(hql.toString(), param);

	}

	@Override
	public void update(User user) {
		baseDAO.merge(user);
	}

}
