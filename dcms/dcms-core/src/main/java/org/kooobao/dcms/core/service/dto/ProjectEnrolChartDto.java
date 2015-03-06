package org.kooobao.dcms.core.service.dto;

import org.kooobao.dcms.core.dto.Dto;

public class ProjectEnrolChartDto extends Dto{
	
	private int ClassroomId;
	private String term; 
	

	public int getClassroomId() {
		return ClassroomId;
	}

	public void setClassroomId(int classroomId) {
		ClassroomId = classroomId;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}
	
	

}
