package com.getyourvenue.lms.service;

import java.util.List;

import com.getyourvenue.lms.model.User;

public interface IUserService {

	public List<User> listUsers();
	public User getUser(String emailid);
	public boolean isValidUser(String emailid, String password);
}
