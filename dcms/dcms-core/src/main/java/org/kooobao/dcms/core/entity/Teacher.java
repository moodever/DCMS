package org.kooobao.dcms.core.entity;

import java.util.List;

import org.kooobao.common.dao.Entity;

public class Teacher extends Entity {
	private String name;
	private TimeSheet timeSheet;
	private List<Classroom> classroom;
	

	public List<Classroom> getClassroom() {
		return classroom;
	}
	public void setClassroom(List<Classroom> classroom) {
		this.classroom = classroom;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TimeSheet getTimeSheet() {
		return timeSheet;
	}
	public void setTimeSheet(TimeSheet timeSheet) {
		this.timeSheet = timeSheet;
	}
	

}
