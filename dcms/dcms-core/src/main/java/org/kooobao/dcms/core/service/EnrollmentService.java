package org.kooobao.dcms.core.service;

import org.kooobao.dcms.core.service.dto.ChangeClassDto;
import org.kooobao.dcms.core.service.dto.ChangeClassResultDto;
import org.kooobao.dcms.core.service.dto.ContractEndResultDto;
import org.kooobao.dcms.core.service.dto.GenerateEnrolChartDto;
import org.kooobao.dcms.core.service.dto.GenerateEnrolChartResultDto;
import org.kooobao.dcms.core.service.dto.PrepareEnrollmentDto;
import org.kooobao.dcms.core.service.dto.PrepareEnrollmentResultDto;



public interface EnrollmentService {
	
	public PrepareEnrollmentResultDto prepareEnrollment(PrepareEnrollmentDto input);
	public ChangeClassResultDto changeClass(ChangeClassDto input);
	public GenerateEnrolChartResultDto generateEnrolChart(GenerateEnrolChartDto input);
	public ContractEndResultDto contractEnded(int childId);
		 


}
