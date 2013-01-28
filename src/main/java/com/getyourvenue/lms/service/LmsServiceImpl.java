package com.getyourvenue.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getyourvenue.lms.constants.LMSConstants;
import com.getyourvenue.lms.dao.ILmsDao;
import com.getyourvenue.lms.model.AlliedServiceComposite;
import com.getyourvenue.lms.model.LeadAlliedService;
import com.getyourvenue.lms.model.LeadContactInfo;
import com.getyourvenue.lms.model.LeadHeader;
import com.getyourvenue.lms.model.LeadHeaderWrapper;
import com.getyourvenue.lms.model.LeadHistory;
import com.getyourvenue.lms.util.LmsUtils;

@Service
public class LmsServiceImpl implements ILmsService{
	
	 Logger logger = Logger.getLogger(LmsServiceImpl.class);

	@Autowired
    private ILmsDao userHibDaoImpl;

	@Override
	public Object editLead(HttpServletRequest request) {
		return userHibDaoImpl.editLead(request);
	}

	@Override
	public LeadHeader editLeadAction(HttpServletRequest request) {
		LeadHeader lmsHeader = prepareLead(request);
		return userHibDaoImpl.saveLead(lmsHeader);
	}

	@Override
	public LeadHeader viewLead(String leadId) {
		LeadHeader leadHeader = userHibDaoImpl.viewLead(leadId);
		leadHeader= prepareLeadHeaderWrapper(leadHeader);
		return leadHeader;
	}
	
	private LeadHeader prepareLeadHeaderWrapper(LeadHeader leadHeader){
		leadHeader.setStatusId(findLeadStatusByStatusId(leadHeader.getStatusId()));
		leadHeader.setAssignTo((findLeadAssignToByUserId(leadHeader.getAssignTo())));
		List<LeadHistory> leadHistories = leadHeader.getLeadHistory();
		for(LeadHistory history: leadHistories){
			history.setStatusId(findLeadStatusByStatusId(history.getStatusId()));
			history.setAssignedTo((findLeadAssignToByUserId(history.getAssignedTo())));
			history.setAssignedFrom((findLeadAssignToByUserId(history.getAssignedFrom())));
		}
		List<LeadAlliedService> alliedServices =leadHeader.getAlliedService();
		if(alliedServices!=null){
			for(LeadAlliedService alliedService : alliedServices){
				AlliedServiceComposite alliedServiceComposite = alliedService.getAlliedServiceComposite();
				alliedServiceComposite.setAlliedServicesId(findAlliedServiceById(alliedService.getAlliedServiceComposite().getAlliedServicesId()));
				alliedService.setAlliedServiceComposite(alliedServiceComposite);
			}
		}
		return leadHeader;
	}
	
	private String findAlliedServiceById(String alliedServicesId) {
		return  userHibDaoImpl.findAlliedServiceById(alliedServicesId);
	}

	@Override
	public List<LeadHeaderWrapper> viewLeadList(HttpServletRequest request) {
		List<LeadHeader> listHeader = userHibDaoImpl.viewLeadList();
		List<LeadHeaderWrapper> leadHeaderWrappers = prepareLeadHeaderWrapperList(listHeader);
		return leadHeaderWrappers;
	}

	private List<LeadHeaderWrapper> prepareLeadHeaderWrapperList(List<LeadHeader> listHeader) {
		List<LeadHeaderWrapper> leadHeaderWrappers = new ArrayList<LeadHeaderWrapper>();
		if(listHeader!=null && listHeader.size()>0){
			for(LeadHeader leadHeader : listHeader){
				LeadHeaderWrapper leadHeaderWrapper = new LeadHeaderWrapper();
				leadHeaderWrapper.setLeadHeader(leadHeader);
				leadHeaderWrapper.setLeadName(findLeadNameByLeadId(leadHeader.getLeadId()));
				leadHeaderWrapper.setStatus(findLeadStatusByStatusId(leadHeader.getStatusId()));
				leadHeaderWrapper.setAssignTo(findLeadAssignToByUserId(leadHeader.getAssignTo()));
				leadHeaderWrappers.add(leadHeaderWrapper);
			}
		}
		return leadHeaderWrappers;
	}

	private String findLeadNameByLeadId(String leadId) {
		return userHibDaoImpl.findLeadNameByLeadId(leadId);
	}

	private String findLeadAssignToByUserId(String assignId) {
		return userHibDaoImpl.findLeadAssignToByUserId(assignId);
	}

	private String findLeadStatusByStatusId(String statusId) {
		return userHibDaoImpl.findLeadStatusByStatusId(statusId);
	}

	@Override
	public LeadHeader saveLead(HttpServletRequest request) {
		LeadHeader leadHeader = prepareLead(request);
		leadHeader= prepareLeadHeaderWrapper(userHibDaoImpl.saveLead(leadHeader));
		return leadHeader;
	}
	
	private LeadHeader prepareLead(HttpServletRequest request) {
		logger.info("preparing the LeadHeader Object");
		LeadHeader leadHeader = new LeadHeader();
		String leadId = request.getParameter("leadid");
		if(leadId == null || leadId == "") {
			leadId= LmsUtils.getRandomId();
		}
		leadHeader.setLeadId(leadId);
		String statusId = request.getParameter("statusId");
		if (statusId.equals(LMSConstants.LEAD_CREATED)) {
			statusId = LMSConstants.LEAD_CREATED;
		}
		leadHeader.setStatusId(statusId);
		leadHeader.setEventType(LMSConstants.LEAD_CREATED);
		leadHeader.setBudget(Double.parseDouble(request.getParameter("budget")));
		String assignto = request.getParameter("assignto");
		String approvelogin = request.getParameter("approvelogin");
		String uploadlogin = request.getParameter("uploadlogin");
		if(assignto != null && !"".equals(assignto)) {
			leadHeader.setAssignTo(findUserIdByName(assignto));
		}
		if(approvelogin != null && !"".equals(approvelogin)) {
			leadHeader.setAssignTo(findUserIdByName(approvelogin));
		}
		if(uploadlogin != null && !"".equals(uploadlogin)) {
			leadHeader.setAssignTo(findUserIdByName(uploadlogin));
		}
		/*leadHeader.setApproverLogin(findUserIdByName(request.getParameter("approvelogin")));
		leadHeader.setUploaderLogin(findUserIdByName(request.getParameter("uploadlogin")));*/
		leadHeader.setPre_no_of_guest(Integer.parseInt(request.getParameter("prefnoofguest")));
		leadHeader.setPreferDate(request.getParameter("date"));
		leadHeader.setLeadInfo("created");
		leadHeader.setFromChannel(request.getParameter("frmchannel"));
		leadHeader.setCreatedStamp(LmsUtils.getTimeStamp());
		leadHeader.setLastUpdatedStamp(LmsUtils.getTimeStamp());
		leadHeader.setContactInfo(prepareLeadContactInfo(request,leadHeader));
		leadHeader.setLeadHistory(prepareLeadHistory(request,leadHeader));
		leadHeader.setAlliedService(prepareLeadAlliedService(request,leadHeader));
		return leadHeader;
	}
    private String findUserIdByName(String loginName) {
		return userHibDaoImpl.findUserIdByName(loginName);
	}
private List<LeadHistory> prepareLeadHistory(HttpServletRequest request, LeadHeader leadHeader){
	  logger.info("preparing the History Object");
	    LeadHistory leadHistory = new LeadHistory();
	    leadHistory.setLead_header(leadHeader);
	    leadHistory.setStatusId(leadHeader.getStatusId());
	    leadHistory.setAssignedFrom(leadHeader.getAssignTo());
	    leadHistory.setAssignedTo(leadHeader.getAssignTo());
	    leadHistory.setStatusDateTime(LmsUtils.getTimeStamp());
	    leadHistory.setCreatedStamp(LmsUtils.getTimeStamp());
	    leadHistory.setLastUpdatedStamp(LmsUtils.getTimeStamp());
		List<LeadHistory> leadHistoryList = new ArrayList<LeadHistory>();
		leadHistoryList.add(leadHistory);
		return leadHistoryList;
  }
  
  private List<LeadAlliedService> prepareLeadAlliedService(HttpServletRequest request, LeadHeader leadHeader){
	  	logger.info("preparing the LeadAlliedServices Object");
	  	String[] alliedList = request.getParameterValues("allied");
	  	List<LeadAlliedService> leadAlliedServices = new ArrayList<LeadAlliedService>();
	  	if (alliedList != null) {
	  	    for(String allied : alliedList){
	  	    	LeadAlliedService leadAlliedServ = new LeadAlliedService();
	  	    	AlliedServiceComposite alliedServiceComposite = new AlliedServiceComposite();
	  	    	alliedServiceComposite.setLead_header(leadHeader);
	  	    	alliedServiceComposite.setAlliedServicesId(allied);
	  	    	leadAlliedServ.setAlliedServiceComposite(alliedServiceComposite);
	  		    leadAlliedServ.setCreatedStamp(LmsUtils.getTimeStamp());
	  		    leadAlliedServ.setLastUpdatedStamp(LmsUtils.getTimeStamp());
	  			leadAlliedServices.add(leadAlliedServ);
	  	    }
	  	}
		return leadAlliedServices;
  }
  
  private String findAlliedServIdByName(String name) {
	 return userHibDaoImpl.findAlliedServIdByName(name);
}

private List<LeadContactInfo> prepareLeadContactInfo(HttpServletRequest request, LeadHeader leadHeader){
	  logger.info("preparing the LeadHeaderContactInfo Object");
	    LeadContactInfo leadContactInfo = new LeadContactInfo();
//	    leadContactInfo.setItemId(Integer.parseInt(LmsUtils.getRandomId()));
	    leadContactInfo.setClientName(request.getParameter("leadname"));
	    leadContactInfo.setLead_header(leadHeader);
	    leadContactInfo.setEmailId(request.getParameter("email"));
	    leadContactInfo.setPhoneNumber(request.getParameter("phoneno"));
	    leadContactInfo.setAddressInfo(request.getParameter("contactinfo"));
	    leadContactInfo.setCreatedStamp(LmsUtils.getTimeStamp());
	    leadContactInfo.setLastUpdatedStamp(LmsUtils.getTimeStamp());
		List<LeadContactInfo> listLeadContactInfo = new ArrayList<LeadContactInfo>();
		listLeadContactInfo.add(leadContactInfo);
		return listLeadContactInfo;
  }

	@Override
	public Map<String, String> getAllAlliedServices() {
		return userHibDaoImpl.getAllAlliedServices();
	}
}
