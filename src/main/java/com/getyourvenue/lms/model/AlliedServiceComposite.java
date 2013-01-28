package com.getyourvenue.lms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class AlliedServiceComposite implements Serializable{
	
	private LeadHeader lead_header;
	private String alliedServicesId;
	@ManyToOne
	@JoinColumn (name = "lead_id")
	public LeadHeader getLead_header() {
		return lead_header;
	}
	public void setLead_header(LeadHeader leadHeader) {
		lead_header = leadHeader;
	}
	
	@Column(name="allied_service_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getAlliedServicesId() {
		return alliedServicesId;
	}
	public void setAlliedServicesId(String alliedServicesId) {
		this.alliedServicesId = alliedServicesId;
	}
}
