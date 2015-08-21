package com.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ActionProperty {
	
	private int id;
	private String orderItemStatus;
	private String ffmClassId;
	private int siteId;
	private String nextControllerCommandName;

	public ActionProperty() {
	}
	
	public ActionProperty(int id,String orderStatus, String ffmClassId, int siteId, String commandName){
		this.setId(id);
		this.orderItemStatus = orderStatus;
		this.ffmClassId = ffmClassId;
		this.siteId = siteId;
		this.nextControllerCommandName = commandName;
	}
	
	public String getOrderItemStatus() {
		return orderItemStatus;
	}

	public void setOrderItemStatus(String orderItemStatus) {
		this.orderItemStatus = orderItemStatus;
	}

	public String getFfmClassId() {
		return ffmClassId;
	}

	public void setFfmClassId(String ffmClassId) {
		this.ffmClassId = ffmClassId;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public String getNextControllerCommandName() {
		return nextControllerCommandName;
	}

	public void setNextControllerCommandName(String nextControllerCommandName) {
		this.nextControllerCommandName = nextControllerCommandName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "ActionProperty [id=" + id + ", orderItemStatus="
				+ orderItemStatus + ", ffmClassId=" + ffmClassId + ", siteId="
				+ siteId + ", nextControllerCommandName="
				+ nextControllerCommandName + "]";
	}
}
