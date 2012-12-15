package com.getyourvenue.lms.dao;

import java.util.List;

import com.getyourvenue.lms.model.User;

public interface IUserDao {

	public List<User> getAllUser();
	public boolean isValidUser(String emailid, String password);
}
