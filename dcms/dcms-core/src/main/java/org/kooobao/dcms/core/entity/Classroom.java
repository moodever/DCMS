package org.kooobao.dcms.core.entity;

import java.util.List;

import org.kooobao.common.dao.Entity;

public class Classroom extends Entity {

	private String name;
	private int grade;
	private int studentNum;
	private int compacity;

	private List<Enrollment> enrollments;

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	public int getCompacity() {
		return compacity;
	}

	public void setCompacity(int compacity) {
		this.compacity = compacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

}
