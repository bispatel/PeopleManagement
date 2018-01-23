package com.as.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="AS_DISTRICT")
public class District {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DISTRICT_ID")
	private int districtId;
	@Column(name = "DISTRICT_NAME")
	private String districtName;
	@Column(name="DESCRIPTION")
	private String description;
	@Transient
	private long totalBlocks;
	@Transient
	private long totalVillage;
	@Transient
	private long totalPeople;
	@Transient
	private String stateName;
	@Column(name="LAST_MODIFIED_DATE")
	private Timestamp lastModDate;
	
	@Column(name="LAST_MODIFIED_BY")
	private String lastModBy;

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getTotalBlocks() {
		return totalBlocks;
	}

	public void setTotalBlocks(long totalBlocks) {
		this.totalBlocks = totalBlocks;
	}

	public long getTotalVillage() {
		return totalVillage;
	}

	public void setTotalVillage(long totalVillage) {
		this.totalVillage = totalVillage;
	}

	public long getTotalPeople() {
		return totalPeople;
	}

	public void setTotalPeople(long totalPeople) {
		this.totalPeople = totalPeople;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Timestamp getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}

	public String getLastModBy() {
		return lastModBy;
	}

	public void setLastModBy(String lastModBy) {
		this.lastModBy = lastModBy;
	}

	public District(int districtId, String districtName, String description, long totalBlocks, long totalVillage,
			long totalPeople, String stateName, String lastModBy) {
		this.districtId = districtId;
		this.districtName = districtName;
		this.description = description;
		this.totalBlocks = totalBlocks;
		this.totalVillage = totalVillage;
		this.totalPeople = totalPeople;
		this.stateName = stateName;
		this.lastModBy = lastModBy;
	}

	public District() {
	}

}
