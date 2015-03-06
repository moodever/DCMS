package org.kooobao.dcms.core.service;

import org.kooobao.dcms.core.service.dto.ChangeClassDto;
import org.kooobao.dcms.core.service.dto.ChangeClassResultDto;
import org.kooobao.dcms.core.service.dto.ContractEndDto;
import org.kooobao.dcms.core.service.dto.ContractEndResultDto;
import org.kooobao.dcms.core.service.dto.EnrollStatusChangeDto;
import org.kooobao.dcms.core.service.dto.EnrollmentAcceptedResultDto;
import org.kooobao.dcms.core.service.dto.EnrollmentOfferRefusedResultDto;
import org.kooobao.dcms.core.service.dto.GenerateEnrolChartDto;
import org.kooobao.dcms.core.service.dto.GenerateEnrolChartResultDto;
import org.kooobao.dcms.core.service.dto.PrepareEnrollmentDto;
import org.kooobao.dcms.core.service.dto.PrepareEnrollmentResultDto;
import org.kooobao.dcms.core.service.dto.ProjectEnrolChartDto;
import org.kooobao.dcms.core.service.dto.ProjectEnrolChartResultDto;



public interface EnrollmentService {
	
	public PrepareEnrollmentResultDto prepareEnrollment(PrepareEnrollmentDto input);
	
	public ChangeClassResultDto changeClass(ChangeClassDto input);
	
	public ProjectEnrolChartResultDto ProjectEnrolChart(ProjectEnrolChartDto input);
	public GenerateEnrolChartResultDto generateEnrolChart(GenerateEnrolChartDto input);
	
	public ContractEndResultDto contractEnded(ContractEndDto input);
	
	public EnrollmentAcceptedResultDto enrollmentOfferAccepted(EnrollStatusChangeDto input);
	
	public EnrollmentOfferRefusedResultDto enrollmentOfferRefused(
			EnrollStatusChangeDto input);
		 


}
