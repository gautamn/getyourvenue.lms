package com.getyourvenue.lms.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.getyourvenue.lms.model.LeadHeader;

public interface ILmsDao {

	Object editLead(HttpServletRequest request);
	LeadHeader editLeadAction(LeadHeader lmsHeader);
	LeadHeader viewLead(String leadId);
	List<LeadHeader> viewLeadList();
	LeadHeader saveLead(LeadHeader leadHeader);
	String findLeadAssignToByUserId(String assignId);
	String findLeadStatusByStatusId(String statusId);
	String findLeadNameByLeadId(String leadId);
	String findAlliedServiceById(String alliedServicesId);
	String findUserIdByName(String loginName);
	Map<String, String> getAllAlliedServices();
	String findAlliedServIdByName(String name);
}
