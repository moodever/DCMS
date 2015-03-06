package org.kooobao.dcms.core.service.dto;

import org.kooobao.dcms.core.dto.Dto;

public class ProjectEnrolChartDto extends Dto {

	private int classroomId;
	private DateDto term;

	public int getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(int classroomId) {
		this.classroomId = classroomId;
	}

	public DateDto getTerm() {
		return term;
	}

	public void setTerm(DateDto term) {
		this.term = term;
	}

}
