package org.kooobao.dcms.core.service;

import org.kooobao.dcms.core.service.dto.ChangeClassDto;
import org.kooobao.dcms.core.service.dto.ChangeClassResultDto;
import org.kooobao.dcms.core.service.dto.ContractEndDto;
import org.kooobao.dcms.core.service.dto.ContractEndResultDto;
import org.kooobao.dcms.core.service.dto.EnrollContractedResultDto;
import org.kooobao.dcms.core.service.dto.EnrollStatusChangeDto;
import org.kooobao.dcms.core.service.dto.EnrollmentAcceptedResultDto;
import org.kooobao.dcms.core.service.dto.EnrollmentContractFailResultDto;
import org.kooobao.dcms.core.service.dto.EnrollmentOfferRefusedResultDto;
import org.kooobao.dcms.core.service.dto.GenerateEnrolChartDto;
import org.kooobao.dcms.core.service.dto.GenerateEnrolChartResultDto;
import org.kooobao.dcms.core.service.dto.PrepareEnrollmentDto;
import org.kooobao.dcms.core.service.dto.PrepareEnrollmentResultDto;
import org.kooobao.dcms.core.service.dto.ProjectEnrolChartDto;
import org.kooobao.dcms.core.service.dto.ProjectEnrolChartResultDto;
import org.kooobao.dcms.core.service.dto.RemoveWaitingEntryResultDto;
import org.kooobao.dcms.core.service.dto.ReturnToListResultDto;
import org.kooobao.dcms.core.service.dto.SetEnrollStatusResultDto;
import org.kooobao.dcms.core.service.dto.ViewTimesheetDto;
import org.kooobao.dcms.core.service.dto.ViewTimesheetResultDto;



public interface EnrollmentService {
	
	public PrepareEnrollmentResultDto prepareEnrollment(PrepareEnrollmentDto input);
	
	public ChangeClassResultDto changeClass(ChangeClassDto input);
	
	public ProjectEnrolChartResultDto projectEnrolChart(ProjectEnrolChartDto input);
	public GenerateEnrolChartResultDto generateEnrolChart(GenerateEnrolChartDto input);
	
	public ContractEndResultDto contractEnded(ContractEndDto input);
	
	public EnrollmentAcceptedResultDto enrollmentOfferAccepted(EnrollStatusChangeDto input);
	
	public EnrollmentOfferRefusedResultDto enrollmentOfferRefused(
			EnrollStatusChangeDto input);
	
	public EnrollmentContractFailResultDto enrollmentContractFail(
			EnrollStatusChangeDto input);
	
	public EnrollContractedResultDto enrollmentContracted(
			EnrollStatusChangeDto input);
	public RemoveWaitingEntryResultDto removeWaitingEntry(EnrollStatusChangeDto input);
	public SetEnrollStatusResultDto setEnrollStatus(EnrollStatusChangeDto input);
	public ReturnToListResultDto returnToList(EnrollStatusChangeDto input);
	
	public ViewTimesheetResultDto viewTimesheet(ViewTimesheetDto input);
	
		 

}
