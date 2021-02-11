package com.graph.redis.lp.object;
 
import com.graph.redis.core.object.BaseGraphPart;

public class Facility extends BaseGraphPart{


	private String number;
	private String abbrv;
	private String name;
	private String type;
	private String network;
	private String pHub;
	private String district;
	private String regn;
	private String coloc;
	private String state;
	private String gateway;
	

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAbbrv() {
		return abbrv;
	}
	public void setAbbrv(String abbrv) {
		this.abbrv = abbrv;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getpHub() {
		return pHub;
	}
	public void setpHub(String pHub) {
		this.pHub = pHub;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getRegn() {
		return regn;
	}
	public void setRegn(String regn) {
		this.regn = regn;
	}
	public String getColoc() {
		return coloc;
	}
	public void setColoc(String coloc) {
		this.coloc = coloc;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getGateway() {
		return gateway;
	}
	public void setGateway(String gateway) {
		this.gateway = gateway;
	}
}
