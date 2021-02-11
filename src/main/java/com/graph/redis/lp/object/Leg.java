package com.graph.redis.lp.object;

import com.graph.redis.core.object.BaseGraphPart;

public class Leg  extends BaseGraphPart{
	
	private String loadplan;
	private String calculatesDOW;
	private String targetedDOW;
	private String splitType;

	
	public String getCalculatesDOW() {
		return calculatesDOW;	
	}
	public void setCalculatesDOW(String calculatesDOW) {
		this.calculatesDOW = calculatesDOW;
	}
	public String getTargetedDOW() {
		return targetedDOW;
	}
	public void setTargetedDOW(String targetedDOW) {
		this.targetedDOW = targetedDOW;
	}
	public String getSplitType() {
		return splitType;
	}
	public void setSplitType(String splitType) {
		this.splitType = splitType;
	}
	public String getLoadplan() {
		return loadplan;
	}
	public void setLoadplan(String loadplan) {
		this.loadplan = loadplan;
	}
}
