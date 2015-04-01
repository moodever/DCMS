package org.kooobao.dcms.core.service.dto;


public class ClassroomDto {

	private int id;

	private String name;
	
	private int grade;

	private String term;

	private Integer studentNum;

	private int capacity;

	private int ageFrom;

	private int ageTo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getAgeFrom() {
		return ageFrom;
	}

	public void setAgeFrom(int ageFrom) {
		this.ageFrom = ageFrom;
	}

	public double getAgeTo() {
		return ageTo;
	}

	public void setAgeTo(int ageTo) {
		this.ageTo = ageTo;
	}


}
