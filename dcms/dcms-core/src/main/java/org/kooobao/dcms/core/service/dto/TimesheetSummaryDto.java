package org.kooobao.dcms.core.service.dto;

public class TimesheetSummaryDto {

	int monday[];
	int tuesday[];
	int wednesday[];
	int thursday[];
	int friday[];

	public int[] getMonday() {
		return monday;
	}

	public void setMonday(int[] monday) {
		this.monday = monday;
	}

	public int[] getTuesday() {
		return tuesday;
	}

	public void setTuesday(int[] tuesday) {
		this.tuesday = tuesday;
	}

	public int[] getWednesday() {
		return wednesday;
	}

	public void setWednesday(int[] wednesday) {
		this.wednesday = wednesday;
	}

	public int[] getThursday() {
		return thursday;
	}

	public void setThursday(int[] thursday) {
		this.thursday = thursday;
	}

	public int[] getFriday() {
		return friday;
	}

	public void setFriday(int[] friday) {
		this.friday = friday;
	}

}
