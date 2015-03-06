package org.kooobao.dcms.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.kooobao.dcms.core.dao.ChildDao;
import org.kooobao.dcms.core.dao.ClassroomDao;
import org.kooobao.dcms.core.dao.EnrollmentDao;
import org.kooobao.dcms.core.dao.WaitingListDao;
import org.kooobao.dcms.core.entity.Child;
import org.kooobao.dcms.core.entity.Classroom;
import org.kooobao.dcms.core.entity.DateUtility;
import org.kooobao.dcms.core.entity.Enrollment;
import org.kooobao.dcms.core.entity.Enrollment.Status;
import org.kooobao.dcms.core.entity.TimeSheet;
import org.kooobao.dcms.core.entity.WaitingList;
import org.kooobao.dcms.core.service.EnrollmentService;
import org.kooobao.dcms.core.service.ErrorCode;
import org.kooobao.dcms.core.service.dto.ChangeClassDto;
import org.kooobao.dcms.core.service.dto.ChangeClassResultDto;
import org.kooobao.dcms.core.service.dto.ContractEndResultDto;
import org.kooobao.dcms.core.service.dto.EnrollContractedResultDto;
import org.kooobao.dcms.core.service.dto.EnrollmentAcceptedResultDto;
import org.kooobao.dcms.core.service.dto.EnrollmentContractFailResultDto;
import org.kooobao.dcms.core.service.dto.EnrollmentOfferRefusedResultDto;
import org.kooobao.dcms.core.service.dto.GenerateEnrolChartDto;
import org.kooobao.dcms.core.service.dto.GenerateEnrolChartResultDto;
import org.kooobao.dcms.core.service.dto.KidsChartNodeDto;
import org.kooobao.dcms.core.service.dto.PrepareEnrollmentDto;
import org.kooobao.dcms.core.service.dto.PrepareEnrollmentResultDto;
import org.kooobao.dcms.core.service.dto.ProjectEnrolChartResultDto;

public class DefaultEnrollmentService implements EnrollmentService {

	// Function Left!
	// generate projection chart

	public ChangeClassResultDto changeClass(ChangeClassDto input) {

		Enrollment currentEnrollment = this.getChildDao()
				.findById(input.getChildId()).getActiveEnrollment();

		Classroom targetClassroom = this.getClassroomDao().findById(
				input.getTargetClassroomId());

		currentEnrollment.setClassroom(targetClassroom);

		this.getEnrollmentDao().save(currentEnrollment);

		ChangeClassResultDto result = new ChangeClassResultDto();

		result.setSuccess(true);

		return result;

	}

	public ProjectEnrolChartResultDto ProjectEnrolChart(GenerateEnrolChartDto input) {

			List<List<KidsChartNodeDto>> classArray = new ArrayList<List<KidsChartNodeDto>>(10); 
			

	//		 (1) find active enrollment		
			
			// infant class 6 weeks - 1 years (6 weeks - 52 weeks)
			// toddler1  1year -2yearc(53  - 104) 
			// toddler2  2year -3year (105 - 156)
			// preschool3 3year-4year(157-208)
			// preschool4 4-5 year (209-260)
			// prograssive class DOB's  (12/14/11-6/14/12 )>???
			// kindergarden 5-7 years (261 - 365)???
			
			// school age 5-10 year (afterschool program)???
			
			int classCount = 8;
			for(int i = 0 ; i < classCount;i++) {
				classArray.add(new ArrayList<KidsChartNodeDto>());
			}
			
			List<Enrollment> activeEnrollmentList=this.getEnrollmentDao().findByStatus(Enrollment.Status.EFFECTIVE);
			
			List<Child> enrolledChildList= new ArrayList<Child>(100);
			
			
			for(Enrollment x : activeEnrollmentList){
				enrolledChildList.add(x.getChild());
			}
			Date currentDate = input.getTermStartDate().toDate();
			for (Child x: enrolledChildList){
			    int kidsWeekAge = DateUtility.getWeekSpan(x.getDateBirth(), currentDate);
			    
			    KidsChartNodeDto dto = new KidsChartNodeDto();
				if (kidsWeekAge < 52) {
					classArray.get(0).add(dto);
				}
			    if (kidsWeekAge <  104){
					classArray.get(1).add(dto);
				}
			    
			    if(kidsWeekAge < 156){
			    	classArray.get(2).add(dto);
			    }
			    if(kidsWeekAge < 208){
			    	classArray.get(3).add(dto);
			    }
			    if(kidsWeekAge < 260){
			    	classArray.get(4).add(dto);
			    }
			    
			   // ....
			    TimeSheet tSheet = x.getActiveEnrollment().getTimeSheet();
				dto.setFirstName(x.getFirstName());
				dto.setLastName(x.getLastName()); 
				dto.setAffiliation(x.getAffliation());
				dto.setNotes(x.getNote());
				
				dto.setMonday(tSheet.getMondayTime());
				dto.setTuesday(tSheet.getTuesdayTime());
				dto.setWednesday(tSheet.getWednesdayTime());
				dto.setThursday(tSheet.getThursdayTime());
				dto.setFriday(tSheet.getFridayTime());
		    	    
			    
			}
					
			GenerateEnrolChartResultDto result = new GenerateEnrolChartResultDto();
			result.setKidsChartNodeDto(kidsNodes);
			result.setSuccess(true);
			return result;

		}

	public GenerateEnrolChartResultDto generateEnrolChart(
			GenerateEnrolChartDto input) {

		List<Enrollment> currentEnrollments = this.getClassroomDao()
				.findById(input.getClassroomId()).getEnrollments();

		KidsChartNodeDto[] kidsNodes = new KidsChartNodeDto[currentEnrollments
				.size()];
		int counter = 0;
		for (Enrollment enrollment : currentEnrollments) {
			kidsNodes[counter] = new KidsChartNodeDto();

			Child currentChild = enrollment.getChild();
			TimeSheet tSheet = enrollment.getTimeSheet();

			kidsNodes[counter].setFirstName(currentChild.getFirstName());
			kidsNodes[counter].setLastName(currentChild.getLastName());
			kidsNodes[counter].setMonday(tSheet.getMondayTime());
			kidsNodes[counter].setTuesday(tSheet.getTuesdayTime());
			kidsNodes[counter].setWednesday(tSheet.getWednesdayTime());
			kidsNodes[counter].setThursday(tSheet.getThursdayTime());
			kidsNodes[counter].setFriday(tSheet.getFridayTime());
			kidsNodes[counter].setAffiliation(currentChild.getAffliation());
			kidsNodes[counter].setNotes(currentChild.getNote());

			counter++;
		}

		GenerateEnrolChartResultDto result = new GenerateEnrolChartResultDto();
		result.setKidsChartNodeDto(kidsNodes);
		result.setSuccess(true);
		return result;

	}

	public ContractEndResultDto contractEnded(int childId) {
		// set enrollment status as void
		// remove kids from class (class number minus 1, and child.class set to
		// null)
		// child.enrollment set to null

		Child currentChild = this.getChildDao().findById(childId);

		Enrollment currentEnrollment = currentChild.getActiveEnrollment();

		currentEnrollment.setStatus(Enrollment.Status.OLD);

		int num = currentEnrollment.getClassroom().getStudentNum();

		currentEnrollment.getClassroom().setStudentNum(num - 1);

		currentEnrollment.setClassroom(null);

		currentEnrollment.getClassroom().getEnrollments()
				.remove(currentEnrollment);

		currentChild.setActiveEnrollment(null);

		ContractEndResultDto result = new ContractEndResultDto();
		result.setSuccess(true);
		return result;

	}

	public EnrollmentAcceptedResultDto enrollmentOfferAccepted(
			int waitingEntryId) {

		Child currentChild;
		currentChild = this.getWaitingListDao().findById(waitingEntryId)
				.getChild();

		Enrollment currentEnrollment;

		currentEnrollment = currentChild
				.getEnrollment(Enrollment.Status.WAITCONFIRM);

		currentEnrollment.setStatus(Enrollment.Status.WAITCONTRACT);

		EnrollmentAcceptedResultDto result = new EnrollmentAcceptedResultDto();
		result.setSuccess(true);
		return result;

	}

	public EnrollmentOfferRefusedResultDto enrollmentOfferRefused(
			int waitingEntryId) {

		WaitingList waitingList = this.getWaitingListDao().findById(
				waitingEntryId);

		Child currentChild = waitingList.getChild();

		Enrollment currentEnrollment = this.getEnrollmentDao().findByStatus(
				Enrollment.Status.WAITCONFIRM, currentChild.getId());

		// update classroom
		// classroom number -1

		int num = currentEnrollment.getClassroom().getStudentNum();

		currentEnrollment.getClassroom().setStudentNum(num - 1);
		currentEnrollment.getClassroom().getEnrollments()
				.remove(currentEnrollment);

		// get the newest enrollment
		// delete the newest enrollment

		currentEnrollment.setClassroom(null);
		currentEnrollment.setStatus(Enrollment.Status.REFUSED);

		currentChild.getEnrollments().remove(currentEnrollment);

		waitingList.setStatus(Status.REMOVED);

		this.getWaitingListDao().save(waitingList);

		this.getChildDao().save(currentChild);

		EnrollmentOfferRefusedResultDto result = new EnrollmentOfferRefusedResultDto();
		result.setSuccess(true);
		return result;

	}

	public EnrollmentContractFailResultDto enrollmentContractFail(
			int waitingEntryId) {

		WaitingList waitingList = this.getWaitingListDao().findById(
				waitingEntryId);

		Child currentChild = waitingList.getChild();

		// Enrollment currentEnrollment =
		// this.getEnrollmentDao().findByStatus(Enrollment.Status.WAITCONTRACT,
		// currentChild.getId());

		Enrollment currentEnrollment = currentChild
				.getEnrollment(Enrollment.Status.WAITCONTRACT);

		// update classroom
		// classroom number -1

		int num = currentEnrollment.getClassroom().getStudentNum();

		currentEnrollment.getClassroom().setStudentNum(num - 1);
		currentEnrollment.getClassroom().getEnrollments()
				.remove(currentEnrollment);

		// get the newest enrollment
		// delete the newest enrollment

		currentEnrollment.setClassroom(null);
		currentEnrollment.setStatus(Enrollment.Status.REFUSED);

		currentChild.getEnrollments().remove(currentEnrollment);

		waitingList.setStatus(Status.REMOVED);

		this.getWaitingListDao().save(waitingList);

		this.getChildDao().save(currentChild);

		EnrollmentContractFailResultDto result = new EnrollmentContractFailResultDto();
		result.setSuccess(true);
		return result;

	}

	public EnrollContractedResultDto enrollmentContracted(int waitingEntryId) {
		// set enrollment status as effective
		// remove child from waitingList

		Child currentChild;
		Enrollment currentEnrollment;

		currentChild = this.getWaitingListDao().findById(waitingEntryId)
				.getChild();

		currentChild.getEnrollment(Enrollment.Status.WAITCONTRACT).setStatus(
				Enrollment.Status.EFFECTIVE);

		currentEnrollment = currentChild
				.getEnrollment(Enrollment.Status.EFFECTIVE);

		currentChild.setActiveEnrollment(currentEnrollment);

		// How to set the Date to current time????
		currentEnrollment.setAcceptDate(Date.Today);

		this.getWaitingListDao().findById(waitingEntryId)
				.setStatus(Status.REMOVED);

		EnrollContractedResultDto result = new EnrollContractedResultDto();
		result.setSuccess(true);
		return result;

	}

	public PrepareEnrollmentResultDto prepareEnrollment(
			PrepareEnrollmentDto input) {

		// 1. get the child information from UI
		// 2. create Enrollment information , add attending mode, add time sheet
		// 3. assign classroom
		// 4. change waitinglist status

		Child child;
		WaitingList waitingList;
		PrepareEnrollmentResultDto result = new PrepareEnrollmentResultDto();

		waitingList = this.getWaitingListDao().findById(
				input.getWaitingListId());

		child = waitingList.getChild();

		Enrollment enrollment = new Enrollment();

		enrollment.setChild(child);
		enrollment.setContractTo(input.getContractTo());
		enrollment.setContractFrom(input.getContractFrom());
		enrollment.setTimeSheet(input.getTimeSheet());

		enrollment.setTerm(input.getTerm());
		enrollment.setStatus(Enrollment.Status.WAITCONFIRM);
		enrollment.setAttendingMode(input.getAttendingMode());

		child.getEnrollments().add(enrollment);

		if (enrollment.getClassroom().getStudentNum() < enrollment
				.getClassroom().getCapacity()) {
			enrollment.setClassroom(input.getClassroom());
			enrollment.getClassroom().setStudentNum(
					enrollment.getClassroom().getStudentNum() + 1);

			getEnrollmentDao().save(enrollment);

			waitingList.setStatus(Status.OFFERED);

			result.setSuccess(true);
			return result;

		}

		else {

			result.setErrorCode(ErrorCode.ClassroomFull);
			result.setSuccess(false);
			return result;

		}

	};

	private ChildDao childDao;

	private WaitingListDao waitingListDao;

	private EnrollmentDao enrollmentDao;

	private ClassroomDao classroomDao;

	public ChildDao getChildDao() {
		return childDao;
	}

	public void setChildDao(ChildDao childDao) {
		this.childDao = childDao;
	}

	public WaitingListDao getWaitingListDao() {
		return waitingListDao;
	}

	public void setWaitingListDao(WaitingListDao waitingListDao) {
		this.waitingListDao = waitingListDao;
	}

	public EnrollmentDao getEnrollmentDao() {
		return enrollmentDao;
	}

	public void setEnrollmentDao(EnrollmentDao enrollmentDao) {
		this.enrollmentDao = enrollmentDao;
	}

	public ClassroomDao getClassroomDao() {
		return classroomDao;
	}

	public void setClassroomDao(ClassroomDao classroomDao) {
		this.classroomDao = classroomDao;
	}

}
