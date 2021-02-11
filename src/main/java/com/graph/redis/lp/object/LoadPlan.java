package com.graph.redis.lp.object;

import com.graph.redis.core.object.BaseGraphPart;

public class LoadPlan extends BaseGraphPart{

	private String name;
	private String description;
	private String userCreated;
	private String startDate;
	private String endDate;
	private String active;
	private String packageType;
	private String dow;
	private String calculatedDOW;
	private String lpVersion;
	private String createdTimeStamp;
	private String lastModeifiedTimeStamp;	
	
	
	public String getCreatedTimeStamp() {
		return createdTimeStamp;
	}
	public void setCreatedTimeStamp(String createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}
	public String getLastModeifiedTimeStamp() {
		return lastModeifiedTimeStamp;
	}
	public void setLastModeifiedTimeStamp(String lastModeifiedTimeStamp) {
		this.lastModeifiedTimeStamp = lastModeifiedTimeStamp;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUserCreated() {
		return userCreated;
	}
	public void setUserCreated(String userCreated) {
		this.userCreated = userCreated;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	public String getPackageType() {
		return packageType;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	public String getDow() {
		return dow;
	}
	public void setDow(String dow) {
		this.dow = dow;
	}

	public String getLpVersion() {
		return lpVersion;
	}
	public void setLpVersion(String lpVersion) {
		this.lpVersion = lpVersion;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCalculatedDOW() {
		return calculatedDOW;
	}
	public void setCalculatedDOW(String calculatedDOW) {
		this.calculatedDOW = calculatedDOW;
	}
}
