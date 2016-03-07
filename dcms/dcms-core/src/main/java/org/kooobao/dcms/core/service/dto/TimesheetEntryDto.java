package org.kooobao.dcms.core.service.dto;

import java.util.Date;

public class TimesheetEntryDto {
	String childName;
	Date dateBirth;
	String dateType;
	Boolean monday[];
	Boolean tuesday[];
	Boolean wednesday[];
	Boolean thursday[];
	Boolean friday[];

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public Boolean[] getMonday() {
		return monday;
	}

	public void setMonday(Boolean[] monday) {
		this.monday = monday;
	}

	public Boolean[] getTuesday() {
		return tuesday;
	}

	public void setTuesday(Boolean[] tuesday) {
		this.tuesday = tuesday;
	}

	public Boolean[] getWednesday() {
		return wednesday;
	}

	public void setWednesday(Boolean[] wednesday) {
		this.wednesday = wednesday;
	}

	public Boolean[] getThursday() {
		return thursday;
	}

	public void setThursday(Boolean[] thursday) {
		this.thursday = thursday;
	}

	public Boolean[] getFriday() {
		return friday;
	}

	public void setFriday(Boolean[] friday) {
		this.friday = friday;
	}

}
