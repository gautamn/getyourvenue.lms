package com.getyourvenue.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.getyourvenue.lms.dao.IUserDao;
import com.getyourvenue.lms.model.User;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
    private IUserDao userHibDaoImpl;
	
	@Transactional
	public List<User> listUsers() {
		
		return userHibDaoImpl.getAllUser();
	}
}
