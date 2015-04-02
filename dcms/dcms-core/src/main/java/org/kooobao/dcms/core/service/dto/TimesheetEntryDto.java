package org.kooobao.dcms.core.service.dto;

import java.util.Date;

public class TimesheetEntryDto {
	String childName;
	Date dateBirth;
	String dateType;
	Boolean mwf[];
	Boolean tt[];

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

	public Boolean[] getMwf() {
		return mwf;
	}

	public void setMwf(Boolean[] mwf) {
		this.mwf = mwf;
	}

	public Boolean[] getTt() {
		return tt;
	}

	public void setTt(Boolean[] tt) {
		this.tt = tt;
	}

}
