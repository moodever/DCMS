package org.kooobao.dcms.core.entity;

import org.kooobao.common.dao.Entity;

public class TimeSheet extends Entity{

	
	
	private String mondayTime;
	
	private String tuesdayTime;
	
	private String wednesdayTime;
	
	private String thursdayTime;
	
	private String fridayTime;

	public String getMondayTime() {
		return mondayTime;
	}

	public void setMondayTime(String mondayTime) {
		this.mondayTime = mondayTime;
	}

	public String getTuesdayTime() {
		return tuesdayTime;
	}

	public void setTuesdayTime(String tuesdayTime) {
		this.tuesdayTime = tuesdayTime;
	}

	public String getWednesdayTime() {
		return wednesdayTime;
	}

	public void setWednesdayTime(String wednesdayTime) {
		this.wednesdayTime = wednesdayTime;
	}

	public String getThursdayTime() {
		return thursdayTime;
	}

	public void setThursdayTime(String thursdayTime) {
		this.thursdayTime = thursdayTime;
	}

	public String getFridayTime() {
		return fridayTime;
	}

	public void setFridayTime(String fridayTime) {
		this.fridayTime = fridayTime;
	}

}
