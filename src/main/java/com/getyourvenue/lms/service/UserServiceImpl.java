package com.getyourvenue.lms.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.getyourvenue.lms.dao.IUserDao;
import com.getyourvenue.lms.model.User;
import com.getyourvenue.lms.utils.LMSUtils;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
    private IUserDao userHibDaoImpl;
	
	static Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Transactional
	public List<User> listUsers() {
		
		return userHibDaoImpl.getAllUser();
	}

	@Transactional
	public User getUser(String emailid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public boolean isValidUser(String emailid, String password) {
		
		password=LMSUtils.getMD5Hash(password);
		return userHibDaoImpl.isValidUser(emailid, password);
	}
}
