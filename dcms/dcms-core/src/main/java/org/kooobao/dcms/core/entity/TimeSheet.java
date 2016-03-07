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

	public Boolean[] getMonday() {
		return parse(mondayTime);
	}

	public Boolean[] getTuesday() {
		return parse(tuesdayTime);
	}

	public Boolean[] getWednesday() {
		return parse(tuesdayTime);
	}

	public Boolean[] getThursday() {
		return parse(tuesdayTime);
	}

	public Boolean[] getFriday() {
		return parse(tuesdayTime);
	}

	/**
	 * 
	 * @param timesheet
	 * @return Boolean data from 7:30 to 17:00, 18 entries
	 */
	protected static Boolean[] parse(String timesheet) {
		Boolean[] items = new Boolean[20];
		for (int i = 0; i < items.length; i++)
			items[i] = false;

		String[] sections = timesheet.split(",");
		for (String section : sections) {
			section = section.trim();
			if (section.contains("-")) {
				String[] parts = section.split("-");
				int from = timeIndex(parts[0]);
				int to = timeIndex(parts[1]);
				for (int i = from; i < to; i++) {
					items[i] = true;
				}
			} else {
				items[timeIndex(section)] = true;
			}
		}
		return items;
	}

	protected static int timeIndex(String time) {
		time = time.trim();
		if (time.contains(":")) {
			String[] parts = time.split(":");
			int first = timeIndex(parts[0]);
			int second = "00".equals(parts[1]) ? 0 : 1;
			return first + second;
		} else {
			int data = Integer.parseInt(time);
			return (data - 8) * 2 + 1;
		}
	}
}
