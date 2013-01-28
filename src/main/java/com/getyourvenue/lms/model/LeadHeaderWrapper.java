package com.getyourvenue.lms.model;

public class LeadHeaderWrapper {
	
	private LeadHeader leadHeader;
	private String leadName;
	private String status;
	private String assignTo;
	private String assignFrom;
	public String getAssignFrom() {
		return assignFrom;
	}
	public void setAssignFrom(String assignFrom) {
		this.assignFrom = assignFrom;
	}
	public LeadHeader getLeadHeader() {
		return leadHeader;
	}
	public void setLeadHeader(LeadHeader leadHeader) {
		this.leadHeader = leadHeader;
	}
	public String getLeadName() {
		return leadName;
	}
	public void setLeadName(String leadName) {
		this.leadName = leadName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAssignTo() {
		return assignTo;
	}
	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}
}
