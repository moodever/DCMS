package org.kooobao.dcms.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.kooobao.common.dao.Entity;

@javax.persistence.Entity
@Table(name = "dcms_teacher")
public class Teacher extends Entity {

	@Column
	private String name;

	@Embedded
	private TimeSheet timeSheet;

	@ManyToMany
	@JoinTable(name = "dcms_classroom_teacher", inverseJoinColumns = { @JoinColumn(name = "classroom_id", referencedColumnName = "id") }, joinColumns = { @JoinColumn(name = "teacher_id", referencedColumnName = "id") })
	private List<Classroom> classrooms;

	public List<Classroom> getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(List<Classroom> classrooms) {
		this.classrooms = classrooms;
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
