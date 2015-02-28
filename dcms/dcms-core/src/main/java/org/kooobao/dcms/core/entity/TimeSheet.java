package org.kooobao.dcms.core.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TimeSheet {

	@Column(name = "mon_time")
	private String mondayTime;

	@Column(name = "tue_time")
	private String tuesdayTime;

	@Column(name = "wed_time")
	private String wednesdayTime;

	@Column(name = "thu_time")
	private String thursdayTime;

	@Column(name = "fri_time")
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
