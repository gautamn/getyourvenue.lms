package com.getyourvenue.lms.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

public class LMSUtils {

	static Logger logger = Logger.getLogger(LMSUtils.class);

	public static String getMD5Hash(String str) {

		if (str == null)
			return null;
		String md5Hash = null;
		
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(str.getBytes(), 0, str.length());
			// Converts message digest value in base 16 (hex)
			md5Hash = new BigInteger(1, digest.digest()).toString(16);
		
		} catch (NoSuchAlgorithmException e) {

			logger.debug("Error in generating MD5 hash!!!", e);
		}
		return md5Hash;
	}

}
