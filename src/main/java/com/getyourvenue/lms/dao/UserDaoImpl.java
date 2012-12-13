package com.getyourvenue.lms.dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.getyourvenue.lms.model.User;

@Repository
public class UserDaoImpl implements IUserDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
	public List<User> getAllUser() {
		
		List<User> userList=new LinkedList<User>();
		String sql="Select * from user";
		List<?> results = jdbcTemplate.queryForList(sql);
		
		for(Object o: results){
			Map<?,?> map = (HashMap<?,?>)o;
			User user = new User();
			//user.setUserId(((Integer)map.get("user_id")).toString());
			//user.setUserName((String)map.get("username"));
			userList.add(user);
		}
		return userList;
	}
}
