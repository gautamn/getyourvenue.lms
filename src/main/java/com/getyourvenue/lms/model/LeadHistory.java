package com.getyourvenue.lms.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lead_history")

public class LeadHistory implements Serializable {
	private static final long serialVersionUID = 3423706926624583998L;
	
	private int historyId;
	private LeadHeader lead_header;
	private String statusId;
	private String assignedFrom;
	private String assignedTo;
	private Timestamp statusDateTime;
	private Timestamp createdStamp;
	private Timestamp lastUpdatedStamp;
	
	
	@Id
	@Column(name = "history_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getHistoryId() {
		return historyId;
	}
	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}
	
	@ManyToOne
	@JoinColumn (name = "lead_id")
	public LeadHeader getLead_header() {
		return lead_header;
	}
	public void setLead_header(LeadHeader leadHeader) {
		lead_header = leadHeader;
	}
	
	@Column(name = "status_id", nullable = false)
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	
	@Column(name = "assigned_from", nullable = true)
	public String getAssignedFrom() {
		return assignedFrom;
	}
	public void setAssignedFrom(String assignedFrom) {
		this.assignedFrom = assignedFrom;
	}
	
	@Column(name = "assigned_to", nullable = true)
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	
	@Column(name = "status_date_time", nullable = false)
	public Timestamp getStatusDateTime() {
		return statusDateTime;
	}
	public void setStatusDateTime(Timestamp statusDateTime) {
		this.statusDateTime = statusDateTime;
	}
	
	@Column(name = "created_stamp", nullable = false)
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
	

	



	
	

}
