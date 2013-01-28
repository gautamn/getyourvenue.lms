package com.getyourvenue.lms.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name = "lead_header")
public class LeadHeader implements Serializable {

	private static final long serialVersionUID = 1178542150873921319L;
	private String leadId;
	private String eventType;
	private Double budget;
	private String assignTo;
	private String approverLogin;
	private String uploaderLogin;
	private int pre_no_of_guest;
	private String preferDate;
	private String statusId;
	private String leadInfo;
	private String fromChannel;
	private Timestamp createdStamp;
	private Timestamp lastUpdatedStamp;
	private List<LeadHistory> leadHistory;
	private List<LeadContactInfo> contactInfo;
	private List<LeadAlliedService> alliedService;
	
	
	@Id
	@Column(name = "lead_id")
	public String getLeadId() {
		return leadId;
	}
	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}
	@Column(name = "lead_info", nullable = true)
	public String getLeadInfo() {
		return leadInfo;
	}
	public void setLeadInfo(String leadInfo) {
		this.leadInfo = leadInfo;
	}
	
	@Column(name = "preferred_date", nullable = true)
	public String getPreferDate() {
		return preferDate;
	}
	public void setPreferDate(String preferDate) {
		this.preferDate = preferDate;
	}
	@Column(name = "preferred_no_of_guest", nullable = true)
	public int getPre_no_of_guest() {
		return pre_no_of_guest;
	}
	public void setPre_no_of_guest(int preNoOfGuest) {
		pre_no_of_guest = preNoOfGuest;
	}

	@Column(name = "event_type", nullable = false)
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	@Column(name = "budget", nullable = false)
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	
	@Column(name = "assign_to", nullable = true)
	public String getAssignTo() {
		return assignTo;
	}
	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}
	
	@Column(name = "approver_login", nullable = true)
	public String getApproverLogin() {
		return approverLogin;
	}
	public void setApproverLogin(String approverLogin) {
		this.approverLogin = approverLogin;
	}
	
	@Column(name = "uploader_login", nullable = true)
	public String getUploaderLogin() {
		return uploaderLogin;
	}
	public void setUploaderLogin(String uploaderLogin) {
		this.uploaderLogin = uploaderLogin;
	}
	
	@Column(name = "status_id", nullable = true)
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	
	@Column(name = "from_channel", nullable = true)
	public String getFromChannel() {
		return fromChannel;
	}
	public void setFromChannel(String fromChannel) {
		this.fromChannel = fromChannel;
	}
	
	@Column(name = "created_stamp", nullable = true)
	public Timestamp getCreatedStamp() {
		return createdStamp;
	}
	public void setCreatedStamp(Timestamp createdStamp) {
		this.createdStamp = createdStamp;
	}
	
	@Column(name = "last_updated_stamp", nullable = true)
	public Timestamp getLastUpdatedStamp() {
		return lastUpdatedStamp;
	}
	public void setLastUpdatedStamp(Timestamp lastUpdatedStamp) {
		this.lastUpdatedStamp = lastUpdatedStamp;
	}
	@OneToMany (mappedBy = "lead_header",cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<LeadHistory> getLeadHistory() {
		return leadHistory;
	}
	public void setLeadHistory(List<LeadHistory> leadHistory) {
		this.leadHistory = leadHistory;
	}
	
	@OneToMany(mappedBy="lead_header",cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<LeadContactInfo> getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(List<LeadContactInfo> contactInfo) {
		this.contactInfo = contactInfo;
	}
	@OneToMany (mappedBy = "alliedServiceComposite.lead_header",cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<LeadAlliedService> getAlliedService() {
		return alliedService;
	}
	public void setAlliedService(List<LeadAlliedService> alliedService) {
		this.alliedService = alliedService;
	}
}
