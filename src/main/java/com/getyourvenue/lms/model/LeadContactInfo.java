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
@Table(name = "lead_contact_info")
public class LeadContactInfo implements Serializable{

	private static final long serialVersionUID = 225891628202862568L;
	
	private int itemId;
	private String clientName;
	private LeadHeader lead_header;
	private String emailId;
	private String phoneNumber;
	private String addressInfo;
	private Timestamp createdStamp;
	private Timestamp lastUpdatedStamp;
	
	@Id
	@Column(name="item_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	@Column(name="client_name")
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	@ManyToOne
	@JoinColumn (name = "lead_id")
	public LeadHeader getLead_header() {
		return lead_header;
	}
	public void setLead_header(LeadHeader leadHeader) {
		lead_header = leadHeader;
	}
	@Column(name="email_id")
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Column(name="phone_number")
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Column(name="address_info")
	public String getAddressInfo() {
		return addressInfo;
	}
	public void setAddressInfo(String addressInfo) {
		this.addressInfo = addressInfo;
	}
	
	@Column(name="created_stamp")
	public Timestamp getCreatedStamp() {
		return createdStamp;
	}
	public void setCreatedStamp(Timestamp createdStamp) {
		this.createdStamp = createdStamp;
	}
	
	@Column(name="last_updated_stamp")
	public Timestamp getLastUpdatedStamp() {
		return lastUpdatedStamp;
	}
	public void setLastUpdatedStamp(Timestamp lastUpdatedStamp) {
		this.lastUpdatedStamp = lastUpdatedStamp;
	}
}
