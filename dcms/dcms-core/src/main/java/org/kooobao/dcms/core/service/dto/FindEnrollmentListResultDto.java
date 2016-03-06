package org.kooobao.dcms.core.service.dto;

import org.kooobao.dcms.core.dto.ResultDto;

public class FindEnrollmentListResultDto extends ResultDto {

	private EnrollmentListDto[] enrollmentLists;

	public EnrollmentListDto[] getEnrollmentLists() {
		return enrollmentLists;
	}

	public void setEnrollmentLists(EnrollmentListDto[] enrollmentLists) {
		this.enrollmentLists = enrollmentLists;
	}


}
