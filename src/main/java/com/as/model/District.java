package com.as.model;

import java.sql.Timestamp;

public class District {

	private int districtId;
	private String districtName;
	private String description;
	private long totalBlocks;
	private long totalVillage;
	private long totalPeople;
	private String stateName;
	private Timestamp lastModDate;
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
	
	
}
