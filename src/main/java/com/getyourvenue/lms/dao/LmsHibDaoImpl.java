package com.getyourvenue.lms.dao;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.getyourvenue.lms.model.Enumeration;
import com.getyourvenue.lms.model.LeadContactInfo;
import com.getyourvenue.lms.model.LeadHeader;

@Repository
public class LmsHibDaoImpl implements ILmsDao {
	
	@Autowired
	private SessionFactory mySessionFactory;
	

	@Override
	public Object editLead(HttpServletRequest request) {
		return null;
	}

	@Override
	public LeadHeader editLeadAction(LeadHeader lmsHeader) {
		//String leadId = request.getParameter("leadId");
		Session session = null;
		//LmsHeader lmsHeader = null;
		try {
			session = mySessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			//lmsHeader = (LmsHeader) session.get(LmsHeader.class, lmsHeader.getLeadId());
			
			//setModel(lmsHeader, request);
			//setNowTimeStamp(lmsHeader);
			//lmsHeader.setStatusId("LEAD_VERIFIED");
			session.update(lmsHeader);
			session.saveOrUpdate(lmsHeader);
			trans.commit();
		} catch(Exception ex){
			  ex.printStackTrace();
	    }
	    finally{
	    	if(session.isOpen()) {
	    		session.close();
	    	}
	    }
		return lmsHeader;
	}

	private void setNowTimeStamp(LeadHeader lmsHeader) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		lmsHeader.setLastUpdatedStamp(Timestamp.valueOf((dateFormat.format(date))));
	}


	@Override
	public LeadHeader viewLead(String leadId) {
		Session session = null;
		LeadHeader leadHeader = null;
		try {
			session = mySessionFactory.openSession();
			leadHeader = (LeadHeader) session.get(LeadHeader.class, leadId);
		} catch(Exception ex){
			  ex.printStackTrace();
	    }
		finally{
	    	if(session.isOpen()) {
	    		session.close();
	    	}
	    }
		return leadHeader;
	}

	@Override
	public List<LeadHeader> viewLeadList() {
		Session session = null;
		List<LeadHeader> leadHeaderList = null;
		try {
			session = mySessionFactory.openSession();
			leadHeaderList = session.createQuery("from LeadHeader").list();
		} catch(Exception ex){
			  ex.printStackTrace();
	    }
	    finally{
	    	if(session.isOpen()) {
	    		session.close();
	    	}
	    }
		
		return leadHeaderList;
	}

	@Override
	public LeadHeader saveLead(LeadHeader leadHeader) {
		Session session = null;
		String message = "";
		Transaction transaction = null;
		try {
			session = mySessionFactory.openSession();
			transaction =session.beginTransaction();
			session.saveOrUpdate(leadHeader);
			transaction.commit();
		} catch(Exception ex){
			  ex.printStackTrace();
			  if(transaction!=null){
				  transaction.rollback();
			  }
	    }
	    finally{
	    	if(session.isOpen()) {
	    		session.close();
	    	}
	    }
		return leadHeader;
	}

	@Override
	public String findLeadAssignToByUserId(String userId) {
		Session session = null;
		String userName = "";
		try {
			session = mySessionFactory.openSession();
			List<String> userNameList = session.createSQLQuery("SELECT name from user_info where user_id="+userId).list();
			userName= userNameList.get(0);
		} catch(Exception ex){
			  ex.printStackTrace();
	    }
	    finally{
	    	if(session.isOpen()) {
	    		session.close();
	    	}
	    }
		return userName;
	}

	@Override
	public String findLeadStatusByStatusId(String statusId) {
		Session session = null;
		String description = "";
		try {
			session = mySessionFactory.openSession();
			List enumList = session.createQuery("from Enumeration where enum_id='"+statusId+"'").list();
			Enumeration enumeration = (Enumeration)enumList.get(0);
			description= enumeration.getDescription();
		} catch(Exception ex){
			  ex.printStackTrace();
	    }
	    finally{
	    	if(session.isOpen()) {
	    		session.close();
	    	}
	    }
		return description;
	}

	@Override
	public String findLeadNameByLeadId(String leadId) {
		Session session = null;
		String clientName = "";
		try {
			session = mySessionFactory.openSession();
			List customerList = session.createQuery("from LeadContactInfo where lead_header='"+leadId+"'").list();
			LeadContactInfo contactInfo =(LeadContactInfo)customerList.get(0);
			clientName= contactInfo.getClientName();
		} catch(Exception ex){
			  ex.printStackTrace();
	    }
	    finally{
	    	if(session.isOpen()) {
	    		session.close();
	    	}
	    }
		return clientName;
	}

	@Override
	public String findAlliedServiceById(String alliedServicesId) {
		Session session = null;
		String heading = "";
		try {
			session = mySessionFactory.openSession();
			List alliedServiceList = session.createSQLQuery("SELECT heading from allied_services where allied_service_id="+alliedServicesId).list();
			heading =(String)alliedServiceList.get(0);
		} catch(Exception ex){
			  ex.printStackTrace();
	    }
	    finally{
	    	if(session.isOpen()) {
	    		session.close();
	    	}
	    }
		return heading;
	}

	@Override
	public String findUserIdByName(String loginName) {
		Session session = null;
		String name = "";
		try {
			session = mySessionFactory.openSession();
			List<String> userId = session.createSQLQuery("SELECT user_id from user_info where name='"+loginName
					+"'").list();
			name =(String)userId.get(0);
		} catch(Exception ex){
			  ex.printStackTrace();
	    }
	    finally{
	    	if(session.isOpen()) {
	    		session.close();
	    	}
	    }
		return name;
	}
	public Map<String, String> getAllAlliedServices() {
		Session session = null;
		List<String> listOfAllied = null;
		Map<String, String> alliedServiceMap = new HashMap<String, String>();
		try {
			session = mySessionFactory.openSession();
			listOfAllied = session.createSQLQuery("SELECT heading,allied_service_id FROM allied_services").list();
			for (Object alliedService : listOfAllied) {
				Object[] objList = (Object[])alliedService;
				alliedServiceMap.put(objList[1].toString(), objList[0].toString());
			}
		} catch(Exception ex){
			  ex.printStackTrace();
	    }
	    finally{
	    	if(session.isOpen()) {
	    		session.close();
	    	}
	    }
		return alliedServiceMap;
	}

	@Override
	public String findAlliedServIdByName(String name) {
		Session session = null;
		String alliedServId = "";
		try {
			session = mySessionFactory.openSession();
			//alliedServId = session.createSQLQuery("SELECT heading FROM allied_services where heading =").list();
		} catch(Exception ex){
			  ex.printStackTrace();
	    }
	    finally{
	    	if(session.isOpen()) {
	    		session.close();
	    	}
	    }
		return alliedServId;
	}
}
