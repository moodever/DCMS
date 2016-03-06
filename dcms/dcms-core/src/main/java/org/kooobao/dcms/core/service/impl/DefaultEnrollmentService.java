package org.kooobao.dcms.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.kooobao.dcms.core.dao.ChildDao;
import org.kooobao.dcms.core.dao.ClassroomDao;
import org.kooobao.dcms.core.dao.EnrollmentDao;
import org.kooobao.dcms.core.dao.WaitingListDao;
import org.kooobao.dcms.core.entity.AttendingMode;
import org.kooobao.dcms.core.entity.Child;
import org.kooobao.dcms.core.entity.Classroom;
import org.kooobao.dcms.core.entity.DateUtility;
import org.kooobao.dcms.core.entity.Enrollment;
import org.kooobao.dcms.core.entity.TimeSheet;
import org.kooobao.dcms.core.entity.WaitingList;
import org.kooobao.dcms.core.entity.WaitingList.DisplayStatus;
import org.kooobao.dcms.core.entity.WaitingList.Status;
import org.kooobao.dcms.core.service.EnrollmentService;
import org.kooobao.dcms.core.service.dto.ChangeClassDto;
import org.kooobao.dcms.core.service.dto.ChangeClassResultDto;
import org.kooobao.dcms.core.service.dto.ClassNodeDto;
import org.kooobao.dcms.core.service.dto.ContractEndDto;
import org.kooobao.dcms.core.service.dto.ContractEndResultDto;
import org.kooobao.dcms.core.service.dto.ContractExpireDto;
import org.kooobao.dcms.core.service.dto.ContractExpireResultDto;
import org.kooobao.dcms.core.service.dto.EnrollContractedResultDto;
import org.kooobao.dcms.core.service.dto.EnrollStatusChangeDto;
import org.kooobao.dcms.core.service.dto.EnrollmentAcceptedResultDto;
import org.kooobao.dcms.core.service.dto.EnrollmentContractFailResultDto;
import org.kooobao.dcms.core.service.dto.EnrollmentOfferRefusedResultDto;
import org.kooobao.dcms.core.service.dto.GenerateEnrolChartDto;
import org.kooobao.dcms.core.service.dto.GenerateEnrolChartResultDto;
import org.kooobao.dcms.core.service.dto.KidsChartNodeDto;
import org.kooobao.dcms.core.service.dto.PrepareEnrollmentDto;
import org.kooobao.dcms.core.service.dto.PrepareEnrollmentResultDto;
import org.kooobao.dcms.core.service.dto.ProjectEnrolChartDto;
import org.kooobao.dcms.core.service.dto.ProjectEnrolChartResultDto;
import org.kooobao.dcms.core.service.dto.RemoveWaitingEntryResultDto;
import org.kooobao.dcms.core.service.dto.ReturnToListResultDto;
import org.kooobao.dcms.core.service.dto.SetEnrollStatusResultDto;
import org.kooobao.dcms.core.service.dto.TimesheetEntryDto;
import org.kooobao.dcms.core.service.dto.TimesheetSummaryDto;
import org.kooobao.dcms.core.service.dto.ViewTimesheetDto;
import org.kooobao.dcms.core.service.dto.ViewTimesheetResultDto;

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

	public ProjectEnrolChartResultDto projectEnrolChart(
			ProjectEnrolChartDto input) {

		int classCount = 8;
		// ArrayList<ClassNodeDto> classnodes = new ArrayList<ClassNodeDto>(10);

		ClassNodeDto[] classNodes = new ClassNodeDto[classCount];
		for (int i = 0; i < classCount; i++) {
			classNodes[i] = new ClassNodeDto();
			classNodes[i].setCapacity(10);
		}
		classNodes[0].setClassName("Infant");
		classNodes[1].setClassName("Toddler1");
		classNodes[2].setClassName("Toddler2");
		classNodes[3].setClassName("Preschool3");
		classNodes[4].setClassName("Preschool4");
		classNodes[5].setClassName("Prograssive Room");
		classNodes[6].setClassName("Kindergarden after school");
		classNodes[7].setClassName("After School Room");

		List<List<KidsChartNodeDto>> classArray = new ArrayList<List<KidsChartNodeDto>>(
				10);

		// (1) find active enrollment

		// infant class 6 weeks - 1 years (6 weeks - 52 weeks)
		// toddler1 1year -2yearc(53 - 104)
		// toddler2 2year -3year (105 - 156)
		// preschool3 3year-4year(157-208)
		// preschool4 4-5 year (209-260)
		// prograssive class DOB's (12/14/11-6/14/12 )>???
		// kindergarden 5-6 years (261 - 365)???
		// school age 5-10 year (afterschool program)???

		for (int i = 0; i < classCount; i++) {
			classArray.add(new ArrayList<KidsChartNodeDto>());
		}

		List<Enrollment> activeEnrollmentList = this.getEnrollmentDao()
				.findByStatus(Enrollment.Status.EFFECTIVE);

		Date currentDate = input.getTargetDate();

		for (Enrollment xe : activeEnrollmentList) {
			Child x = xe.getChild();

			int kidsWeekAge = DateUtility.getWeekSpan(x.getDateBirth(),
					currentDate);

			KidsChartNodeDto dto = new KidsChartNodeDto();

			// x.getDateBirth().after()

			if (kidsWeekAge < 52) { // infant
				classArray.get(0).add(dto);

			} else if (kidsWeekAge < 104) { // toddler1
				classArray.get(1).add(dto);
			} else if (kidsWeekAge < 156) { // toddler2
				classArray.get(2).add(dto);
			} else if (kidsWeekAge < 208) { // preschool3
				classArray.get(3).add(dto);
			} else if (kidsWeekAge < 260) { // preschool4
				classArray.get(4).add(dto);
			} else if (kidsWeekAge < 522) { // School age class
				classArray.get(7).add(dto);
			}

			// ....
			TimeSheet tSheet = x.getActiveEnrollment().getTimeSheet();
			dto.setAttendingMode(xe.getAttendingMode().name());
			dto.setFirstName(x.getFirstName());
			dto.setLastName(x.getLastName());
			dto.setDateOfBirth(x.getDateBirth());
			dto.setAffiliation(x.getAffliation());
			dto.setNotes(x.getNote());
			dto.setMonday(tSheet.getMondayTime());
			dto.setTuesday(tSheet.getTuesdayTime());
			dto.setWednesday(tSheet.getWednesdayTime());
			dto.setThursday(tSheet.getThursdayTime());
			dto.setFriday(tSheet.getFridayTime());
		}

		int counter = 0;

		for (List<KidsChartNodeDto> clazz : classArray) {
			KidsChartNodeDto[] tempbuffer = new KidsChartNodeDto[clazz.size()];
			clazz.toArray(tempbuffer);
			classNodes[counter++].setNodes(tempbuffer);
		}

		ProjectEnrolChartResultDto result = new ProjectEnrolChartResultDto();
		result.setNodes(classNodes);
		result.setSuccess(true);
		return result;

	}

	public GenerateEnrolChartResultDto generateEnrolChart(
			GenerateEnrolChartDto input) {

		String term = Classroom.calculateTerm(new Date());

		Classroom classroom = this.getClassroomDao().findByNameTerm(
				input.getClassroomName(), term);
		if (classroom == null) {
			GenerateEnrolChartResultDto result = new GenerateEnrolChartResultDto();
			result.setSuccess(false);
			result.setErrorMessage("No classroom found");
			return result;
		}
		List<Enrollment> currentEnrollments = classroom.getEnrollments();

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
			kidsNodes[counter].setDateOfBirth(currentChild.getDateBirth());
			kidsNodes[counter].setSequenceNum(counter + 1);

			counter++;
		}

		GenerateEnrolChartResultDto result = new GenerateEnrolChartResultDto();
		result.setKidsChartNodeDto(kidsNodes);
		result.setSuccess(true);
		return result;

	}

	public ContractEndResultDto contractEnded(ContractEndDto input) {
		// set enrollment status as void
		// remove kids from class (class number minus 1, and child.class set to
		// null)
		// child.enrollment set to null

		int childId = input.getChildId();

		Child currentChild = this.getChildDao().findById(childId);

		Enrollment currentEnrollment = currentChild.getActiveEnrollment();

		currentEnrollment.setStatus(Enrollment.Status.INVALID);

		currentChild.setActiveEnrollment(null);

		this.getWaitingListDao()
				.findByNameDob(currentChild.getFirstName(),
						currentChild.getLastName(), currentChild.getDateBirth())
				.setStatus(WaitingList.Status.REMOVED);

		// this.getChildDao().save(currentChild);

		// this.getEnrollmentDao().save(currentEnrollment);

		ContractEndResultDto result = new ContractEndResultDto();
		result.setSuccess(true);
		return result;

	}

	public ContractExpireResultDto contractExpire(ContractExpireDto input) {
		// set enrollment status as void
		// remove kids from class (class number minus 1, and child.class set to
		// null)
		// child.enrollment set to null

		int childId = input.getChildId();

		Child currentChild = this.getChildDao().findById(childId);

		Enrollment currentEnrollment = currentChild.getActiveEnrollment();

		currentEnrollment.setStatus(Enrollment.Status.EXPIRED);

		currentChild.setActiveEnrollment(null);

		this.getWaitingListDao()
				.findByNameDob(currentChild.getFirstName(),
						currentChild.getLastName(), currentChild.getDateBirth())
				.setStatus(WaitingList.Status.REMOVED);

		// this.getChildDao().save(currentChild);

		// this.getEnrollmentDao().save(currentEnrollment);

		ContractExpireResultDto result = new ContractExpireResultDto();
		result.setSuccess(true);
		return result;

	}

	public ReturnToListResultDto returnToList(EnrollStatusChangeDto input) {

		ReturnToListResultDto result = new ReturnToListResultDto();
		WaitingList wl;
		wl = this.getWaitingListDao().findById(input.getWaitingListId());

		// only the following status are allowed to return to list
		// WaitingList.Status.DECLINE, WaitingList.Status.REMOVED

		wl.setStatus(WaitingList.Status.NEW);
		wl.setDisplayStatus(WaitingList.DisplayStatus.RETURNED_TO_LIST);
		result.setSuccess(true);
		return result;

	}

	public RemoveWaitingEntryResultDto removeWaitingEntry(
			EnrollStatusChangeDto input) {

		RemoveWaitingEntryResultDto result = new RemoveWaitingEntryResultDto();
		WaitingList wl;
		wl = this.getWaitingListDao().findById(input.getWaitingListId());
		// Enrollment enroll =
		// wl.getChild().getEnrollment(Enrollment.Status.PREPARE);

		if (wl.getStatus() == WaitingList.Status.NEW) {
			wl.setStatus(Status.REMOVED);
			wl.setDisplayStatus(DisplayStatus.REMOVED);

			result.setSuccess(true);
			return result;

		}

		else if (wl.getStatus() == WaitingList.Status.OFFERED
				|| wl.getStatus() == WaitingList.Status.ACCEPTED) {

			Enrollment enroll = wl.getChild().getEnrollment(
					Enrollment.Status.PREPARE);
			wl.getChild().removeEnrollment(enroll);
			wl.setStatus(Status.REMOVED);
			wl.setDisplayStatus(DisplayStatus.REMOVED);

			result.setSuccess(true);
			return result;
		}

		else if (wl.getStatus() == WaitingList.Status.DECLINED) {
			wl.setStatus(Status.REMOVED);
			wl.setDisplayStatus(DisplayStatus.REMOVED);

			result.setSuccess(true);
			return result;

		}

		else if (wl.getStatus() == WaitingList.Status.CONTRACT_CONFIRMED
				|| wl.getStatus() == WaitingList.Status.ENROLLED) {

			Enrollment e = wl.getChild().getActiveEnrollment();

			// in case contract confirmed
			if (e != null && e.getStatus() == Enrollment.Status.EFFECTIVE) {

				e.setStatus(Enrollment.Status.INVALID);
				wl.getChild().setActiveEnrollment(null);

				wl.setStatus(Status.REMOVED);
				wl.setDisplayStatus(DisplayStatus.REMOVED);

				result.setSuccess(true);
				return result;

			} else {

				result.setSuccess(false);
				result.setErrorMessage("Enrolled, can not handle the status");
				return result;

			}

		} else {

			result.setSuccess(false);
			result.setErrorMessage("WaitingList Status is not correct");
			return result;

		}

	}

	public EnrollmentAcceptedResultDto enrollmentOfferAccepted(
			EnrollStatusChangeDto input) {

		WaitingList wl;

		wl = this.getWaitingListDao().findById(input.getWaitingListId());

		wl.setStatus(Status.ACCEPTED);
		wl.setDisplayStatus(DisplayStatus.ACCEPTED);

		EnrollmentAcceptedResultDto result = new EnrollmentAcceptedResultDto();
		result.setSuccess(true);
		return result;

	}

	public EnrollmentOfferRefusedResultDto enrollmentOfferRefused(
			EnrollStatusChangeDto input) {

		WaitingList waitingList = this.getWaitingListDao().findById(
				input.getWaitingListId());

		EnrollmentOfferRefusedResultDto result = new EnrollmentOfferRefusedResultDto();

		Child currentChild = waitingList.getChild();

		if (waitingList.getStatus() == WaitingList.Status.OFFERED) {

			Enrollment currentEnrollment = this.getEnrollmentDao()
					.findByStatusForChild(Enrollment.Status.PREPARE,
							currentChild);

			currentChild.removeEnrollment(currentEnrollment);

			waitingList.setStatus(Status.DECLINED);

			waitingList.setDisplayStatus(DisplayStatus.DECLINED);

			// this.getWaitingListDao().save(waitingList);

			result.setSuccess(true);
			return result;

		} else {

			result.setSuccess(false);
			result.setErrorMessage("WaitingList Status is not correct");
			return result;

		}

	}

	public EnrollmentContractFailResultDto enrollmentContractFail(
			EnrollStatusChangeDto input) {

		WaitingList waitingList = this.getWaitingListDao().findById(
				input.getWaitingListId());

		EnrollmentContractFailResultDto result = new EnrollmentContractFailResultDto();

		if (waitingList.getStatus() == WaitingList.Status.ACCEPTED
				|| waitingList.getStatus() == WaitingList.Status.OFFERED) {

			Child currentChild = waitingList.getChild();

			Enrollment currentEnrollment = this.getEnrollmentDao()
					.findByStatusForChild(Enrollment.Status.PREPARE,
							currentChild);

			currentChild.removeEnrollment(currentEnrollment);

			waitingList.setStatus(WaitingList.Status.DECLINED);
			waitingList.setDisplayStatus(WaitingList.DisplayStatus.DECLINED);

			// this.getWaitingListDao().save(waitingList);

			result.setSuccess(true);
			return result;

		} else {

			result.setSuccess(false);
			result.setErrorMessage("WaitingList Status is not correct");
			return result;

		}

	}

	public EnrollContractedResultDto enrollmentContracted(
			EnrollStatusChangeDto input) {
		// set enrollment status as effective
		// remove child from waitingList

		EnrollContractedResultDto result = new EnrollContractedResultDto();

		Child currentChild;
		Enrollment currentEnrollment;
		int waitingEntryId = input.getWaitingListId();
		WaitingList wl = this.getWaitingListDao().findById(waitingEntryId);

		if (wl.getStatus() == WaitingList.Status.ACCEPTED
				|| wl.getStatus() == WaitingList.Status.OFFERED) {

			currentChild = wl.getChild();

			currentEnrollment = currentChild
					.getEnrollment(Enrollment.Status.PREPARE);

			currentEnrollment.setStatus(Enrollment.Status.EFFECTIVE);

			currentChild.setActiveEnrollment(currentEnrollment);

			wl.setStatus(WaitingList.Status.CONTRACT_CONFIRMED);
			wl.setDisplayStatus(WaitingList.DisplayStatus.CONTRACT_CONFIRMED);

			result.setSuccess(true);
			return result;

		} else {

			result.setSuccess(false);
			result.setErrorMessage("WaitingList Status is not correct");
			return result;

		}

	}

	public SetEnrollStatusResultDto setEnrollStatus(EnrollStatusChangeDto input) {

		SetEnrollStatusResultDto result = new SetEnrollStatusResultDto();

		// only WaitingList.Status.ContractConfirmed could be set to enrolled

		int waitingEntryId = input.getWaitingListId();
		WaitingList wl = this.getWaitingListDao().findById(waitingEntryId);

		wl.setStatus(WaitingList.Status.ENROLLED);
		wl.setDisplayStatus(WaitingList.DisplayStatus.ENROLLED);

		result.setSuccess(true);
		return result;

	}

	public PrepareEnrollmentResultDto prepareEnrollment(
			PrepareEnrollmentDto input) {

		// 1. get the child information from UI
		// 2. create Enrollment information , add attending mode, add time sheet
		// 3. assign classroom
		// 4. change waitingList status

		Child child;
		Classroom classroom;
		TimeSheet timeSheet = new TimeSheet();
		WaitingList waitingList;

		timeSheet.setMondayTime(input.getMonTime());
		timeSheet.setTuesdayTime(input.getTueTime());
		timeSheet.setWednesdayTime(input.getWedTime());
		timeSheet.setThursdayTime(input.getThuTime());
		timeSheet.setFridayTime(input.getFriTime());

		PrepareEnrollmentResultDto result = new PrepareEnrollmentResultDto();

		waitingList = this.getWaitingListDao().findById(
				input.getWaitingListId());

		child = waitingList.getChild();
		classroom = this.getClassroomDao().findByNameTerm(
				input.getClassroomName(), input.getTerm());
		if (classroom == null) {
			result.setSuccess(false);
			result.setErrorMessage("No classroom found");
			return result;
		}

		if (waitingList.getStatus() != WaitingList.Status.OFFERED
				&& waitingList.getStatus() != WaitingList.Status.NEW) {
			result.setSuccess(false);
			result.setErrorMessage("WaitingList Status is not New or Offered");
			return result;

		} else {

			if (waitingList.getStatus() == WaitingList.Status.OFFERED) {

				Enrollment enrollment = child
						.getEnrollment(Enrollment.Status.PREPARE);

				enrollment.setContractTo(input.getContractTo());
				enrollment.setContractFrom(input.getContractFrom());
				enrollment.setTimeSheet(timeSheet);
				enrollment.setAttendingMode(AttendingMode.values()[input
						.getAttendingMode()]);
				waitingList.setAttendingMode(AttendingMode.values()[input
						.getAttendingMode()]);

				enrollment.setAcceptDate(input.getAcceptDate());

				enrollment.setClassroom(classroom);

				classroom.addEnrollment(enrollment);
				classroom.setStudentNum(classroom.getStudentNum() + 1);

				// waitingList.setStatus(WaitingList.Status.OFFERED);
				// waitingList.setDisplayStatus(WaitingList.DisplayStatus.OFFERED);
				waitingList.setOfferedDate(input.getAcceptDate());
				enrollment.setStatus(Enrollment.Status.PREPARE);

				getClassroomDao().save(classroom);
				getEnrollmentDao().save(enrollment);
				getWaitingListDao().save(waitingList);

				result.setSuccess(true);
				return result;

			}

			// if (waitingList.getStatus()== WaitingList.Status.NEW)
			else {

				Enrollment enrollment = new Enrollment();

				enrollment.setChild(child);
				enrollment.setContractTo(input.getContractTo());
				enrollment.setContractFrom(input.getContractFrom());
				enrollment.setTimeSheet(timeSheet);
				enrollment.setAttendingMode(AttendingMode.values()[input
						.getAttendingMode()]);
				waitingList.setAttendingMode(AttendingMode.values()[input
						.getAttendingMode()]);

				enrollment.setAcceptDate(input.getAcceptDate());

				enrollment.setClassroom(classroom);

				classroom.addEnrollment(enrollment);
				classroom.setStudentNum(classroom.getStudentNum() + 1);

				waitingList.setStatus(WaitingList.Status.OFFERED);
				waitingList.setDisplayStatus(WaitingList.DisplayStatus.OFFERED);
				waitingList.setOfferedDate(input.getAcceptDate());
				enrollment.setStatus(Enrollment.Status.PREPARE);

				getClassroomDao().save(classroom);
				getEnrollmentDao().save(enrollment);
				getWaitingListDao().save(waitingList);

				result.setSuccess(true);
				return result;

				/*
				 * check if the enrollment term = current term ,then check ...
				 * if (classroom.getStudentNum() < classroom.getCapacity()) {
				 * 
				 * }
				 * 
				 * else {
				 * 
				 * result.setErrorCode(ErrorCode.ClassroomFull);
				 * result.setSuccess(false); return result; }
				 */

			}
		}

	}

	@Override
	public ViewTimesheetResultDto viewTimesheet(ViewTimesheetDto input) {
		ViewTimesheetResultDto result = new ViewTimesheetResultDto();

		String term = Classroom.calculateTerm(new Date());
		String clsrmName = input.getClassroomName();

		Classroom clsrm = getClassroomDao().findByNameTerm(clsrmName, term);
		if (clsrm == null) {
			result.setSuccess(false);
			result.setErrorMessage("No such classroom");
			return result;
		}
		List<Enrollment> enrollments = getEnrollmentDao()
				.findActiveInClassroom(clsrm);
		TimesheetEntryDto[] entryDtos = new TimesheetEntryDto[enrollments
				.size()];
		int counter = 0;

		for (Enrollment el : enrollments) {
			TimeSheet ts = el.getTimeSheet();

			entryDtos[counter] = new TimesheetEntryDto();
			entryDtos[counter].setChildName(el.getChild().getName());
			entryDtos[counter].setDateBirth(el.getChild().getDateBirth());
			entryDtos[counter].setDateType(el.getAttendingMode().name());
			entryDtos[counter].setMwf(ts.getMwf());
			entryDtos[counter].setTt(ts.getTt());
			counter++;
		}

		TimesheetSummaryDto summary = new TimesheetSummaryDto();

		int mwf[] = new int[20];
		int tt[] = new int[20];
		summary.setMwf(mwf);
		summary.setTt(tt);
		for (int i = 0; i < mwf.length; i++) {
			mwf[i] = 0;
			tt[i] = 0;
		}
		for (TimesheetEntryDto entry : entryDtos) {
			for (int i = 0; i < entry.getMwf().length; i++) {
				mwf[i] += entry.getMwf()[i] ? 1 : 0;
			}
			for (int i = 0; i < entry.getTt().length; i++) {
				tt[i] += entry.getTt()[i] ? 1 : 0;
			}
		}

		result.setEntries(entryDtos);
		result.setSummary(summary);

		return result;
	}

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
