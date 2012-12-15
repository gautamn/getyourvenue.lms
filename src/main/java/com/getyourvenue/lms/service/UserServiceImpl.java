package com.getyourvenue.lms.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.log4j.Logger;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.getyourvenue.lms.dao.IUserDao;
import com.getyourvenue.lms.model.User;

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
		
		/*byte[] data = password.getBytes(); 
		MD5Digest md5;
		
		try {
			md5 = MD5Digest.class.newInstance();
			md5.update(data,0,data.length); 
	        int length = md5.getDigestSize();
	        byte[] md5ByteArr = new byte[length];
	        md5.doFinal(md5ByteArr, 0);
			password=new String(md5ByteArr);
			
		} catch (Exception e) {
			logger.error("Error occured while generating MD5 password!!!", e);
		}
		
		logger.debug("Passed changed to:"+password);*/
		
		return userHibDaoImpl.isValidUser(emailid, password);
	}
}
