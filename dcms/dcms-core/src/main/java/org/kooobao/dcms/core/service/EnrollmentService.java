package org.kooobao.dcms.core.service;

import org.kooobao.dcms.core.service.dto.PrepareEnrollmentDto;
import org.kooobao.dcms.core.service.dto.PrepareEnrollmentResultDto;



public interface EnrollmentService {
	
	public PrepareEnrollmentResultDto prepareEnrollment(PrepareEnrollmentDto input);


}
