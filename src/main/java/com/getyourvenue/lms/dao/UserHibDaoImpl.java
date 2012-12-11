package com.getyourvenue.lms.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.getyourvenue.lms.model.User;

@Repository
public class UserHibDaoImpl  implements IUserDao{
	
	@Autowired
	private SessionFactory mySessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {
		
		return (List<User>)mySessionFactory.getCurrentSession().createQuery("from User").list();
	}

}
