package com.getyourvenue.lms.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="enumeration")
public class Enumeration implements Serializable {

	private static final long serialVersionUID = -8283955581521963805L;
	
	private String enum_id;
	private String enum_type_id;
	private String description;
	private Timestamp createdStamp;
	private Timestamp lastUpdatedStamp;
	
	@Id
	@Column(name="enum_id")
	public String getEnum_id() {
		return enum_id;
	}
	public void setEnum_id(String enumId) {
		enum_id = enumId;
	}
	
	@Column(name="enum_type_id")
	public String getEnum_type_id() {
		return enum_type_id;
	}
	public void setEnum_type_id(String enumTypeId) {
		enum_type_id = enumTypeId;
	}
	
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name ="created_stamp")
	public Timestamp getCreatedStamp() {
		return createdStamp;
	}
	public void setCreatedStamp(Timestamp createdStamp) {
		this.createdStamp = createdStamp;
	}
	
	@Column(name = "last_updated_stamp")
	public Timestamp getLastUpdatedStamp() {
		return lastUpdatedStamp;
	}
	public void setLastUpdatedStamp(Timestamp lastUpdatedStamp) {
		this.lastUpdatedStamp = lastUpdatedStamp;
	}
	
}	
	