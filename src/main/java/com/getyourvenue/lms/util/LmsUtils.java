package com.getyourvenue.lms.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import org.apache.log4j.Logger;

public class LmsUtils {
	static Logger logger = Logger.getLogger(LmsUtils.class);
	public static String getRandomId(){
		String randomId = String.valueOf(Math.abs(UUID.randomUUID().getLeastSignificantBits()));
		logger.info("The Id generated is "+ randomId);
		return randomId;
	}
	
	public static String readProperty(String key){
		Properties properties = new Properties();
		try{
			InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("message.properties");
			properties.load(inputStream);
		}
		catch(IOException ex){
			logger.error("unable to load the property from file");
			ex.printStackTrace();
		}
		return properties.getProperty(key);
	}
	
	public static Timestamp getTimeStamp(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(cal.getTime());
	    Date dat = null;
		try {
			dat = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Timestamp(dat.getTime());
	}

}
