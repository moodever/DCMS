package org.kooobao.dcms.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.kooobao.common.dao.Entity;

@javax.persistence.Entity
@Table(name = "dcms_classroom")
public class Classroom extends Entity {

	@Column(name = "name")
	private String name;

	@Column(name = "grade")
	private int grade;

	@Column(name = "student_num")
	private int studentNum;

	@Column(name = "capacity")
	private int capacity;
	
	@Column(name = "ageFrom")
	private double ageFrom;
	
	@Column(name = "ageTo")
	private double ageTo;	

	public double getAgeFrom() {
		return ageFrom;
	}

	public void setAgeFrom(double ageFrom) {
		this.ageFrom = ageFrom;
	}

	public double getAgeTo() {
		return ageTo;
	}

	public void setAgeTo(double ageTo) {
		this.ageTo = ageTo;
	}

	@OneToMany(mappedBy = "classroom")
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
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
