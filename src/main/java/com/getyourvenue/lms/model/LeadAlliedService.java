package com.getyourvenue.lms.model;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="lead_allied_services")
public final class LeadAlliedService implements Serializable {

	private static final long serialVersionUID = 74286357670429267L;
	
	private Timestamp createdStamp;
	private Timestamp lastUpdatedStamp;
	private AlliedServiceComposite alliedServiceComposite;
    @EmbeddedId
	public AlliedServiceComposite getAlliedServiceComposite() {
		return alliedServiceComposite;
	}
	public void setAlliedServiceComposite(
			AlliedServiceComposite alliedServiceComposite) {
		this.alliedServiceComposite = alliedServiceComposite;
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
