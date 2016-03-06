package org.kooobao.dcms.core.entity;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

	@Column(name = "term")
	private String term;

	@Column(name = "student_num")
	private Integer studentNum;

	@Column(name = "capacity")
	private int capacity;

	@Column(name = "age_from")
	private double ageFrom;

	@Column(name = "age_to")
	private double ageTo;

	@OneToMany(mappedBy = "classroom")
	private List<Enrollment> enrollments;

	public Classroom() {
		super();
		enrollments = new ArrayList<Enrollment>();
	}

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

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public void addEnrollment(Enrollment e) {
		this.enrollments.add(e);
		setStudentNum(getStudentNum() + 1);
	}

	protected void removeEnrollment(Enrollment e) {
		getEnrollments().remove(e);
		int currentNum = getStudentNum();
		setStudentNum(currentNum - 1);
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Integer getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(Integer studentNum) {
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

	public static String calculateTerm(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		String term = "unknown";
		year -= 2000;
		if (month >= Calendar.JANUARY && month <= Calendar.MAY) {
			term = "spring";
		} else if (month >= Calendar.SEPTEMBER && month <= Calendar.DECEMBER) {
			term = "fall";
		}
		return MessageFormat.format("{0}{1}", term, year);
	}
	
	
	
}
