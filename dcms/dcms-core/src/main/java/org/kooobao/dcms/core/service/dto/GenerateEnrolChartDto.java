package org.kooobao.dcms.core.service.dto;

import org.kooobao.dcms.core.dto.Dto;

public class GenerateEnrolChartDto extends Dto {

	private int ClassroomId;
	private DateDto termStartDate;

	public DateDto getTermStartDate() {
		return termStartDate;
	}

	public void setTermStartDate(DateDto termStartDate) {
		this.termStartDate = termStartDate;
	}

	public int getClassroomId() {
		return ClassroomId;
	}

	public void setClassroomId(int classroomId) {
		ClassroomId = classroomId;
	}

}
