package com.getyourvenue.lms.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.getyourvenue.lms.model.LeadHeader;
import com.getyourvenue.lms.model.LeadHeaderWrapper;

public interface ILmsService {
	public Object editLead(HttpServletRequest request);
	public LeadHeader editLeadAction(HttpServletRequest request);
	public LeadHeader viewLead(String leadId);
	public List<LeadHeaderWrapper> viewLeadList(HttpServletRequest request);
	public LeadHeader saveLead(HttpServletRequest request);
	public Map<String, String> getAllAlliedServices();
}
