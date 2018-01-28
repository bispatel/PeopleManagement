package com.as.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "AS_BLOCK")
public class Block {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BLOCK_SEQ")
    @SequenceGenerator(sequenceName = "SEQ_BLOCK_ID", allocationSize = 1, name = "BLOCK_SEQ")
	@Column(name = "BLOCK_ID")
	private int blockId;

	@Column(name = "BLOCK_NAME")
	private String blockName;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "LAST_MODIFIED_BY")
	private String lastModBy;

	@Column(name = "LAST_MODIFIED_DATE")
	private Timestamp lastModDate;

	@Transient
	private long totalVillage;

	@Transient
	private long totalPeople;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISTRICT_ID", nullable = false)
	private District district;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="block")
	private Set<Village> villageList;

	public int getBlockId() {
		return blockId;
	}

	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLastModBy() {
		return lastModBy;
	}

	public void setLastModBy(String lastModBy) {
		this.lastModBy = lastModBy;
	}

	public Timestamp getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
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

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Set<Village> getVillageList() {
		return villageList;
	}

	public void setVillageList(Set<Village> villageList) {
		this.villageList = villageList;
	}	
	
}
