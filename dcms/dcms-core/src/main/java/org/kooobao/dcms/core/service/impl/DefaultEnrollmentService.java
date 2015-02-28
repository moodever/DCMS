package org.kooobao.dcms.core.service.impl;

import java.util.List;

import org.kooobao.dcms.core.dao.ChildDao;
import org.kooobao.dcms.core.dao.ClassroomDao;
import org.kooobao.dcms.core.dao.EnrollmentDao;
import org.kooobao.dcms.core.dao.WaitingListDao;
import org.kooobao.dcms.core.entity.Child;
import org.kooobao.dcms.core.entity.Enrollment;
import org.kooobao.dcms.core.entity.TimeSheet;
import org.kooobao.dcms.core.entity.WaitingList;
import org.kooobao.dcms.core.entity.WaitingList.Status;
import org.kooobao.dcms.core.service.EnrollmentService;
import org.kooobao.dcms.core.service.dto.ContractEndResultDto;
import org.kooobao.dcms.core.service.dto.GenerateEnrolChartDto;
import org.kooobao.dcms.core.service.dto.GenerateEnrolChartResultDto;
import org.kooobao.dcms.core.service.dto.KidsChartNodeDto;
import org.kooobao.dcms.core.service.dto.PrepareEnrollmentDto;
import org.kooobao.dcms.core.service.dto.PrepareEnrollmentResultDto;

public class DefaultEnrollmentService implements EnrollmentService {

	// contract ended
	// child adjust class
	// generate enrollment chart
	// generate projection chart

	// public ChangeClassResultDto changeClass(int childId) {
	// }

	public GenerateEnrolChartResultDto generateEnrolChart(
			GenerateEnrolChartDto input) {

		int classroomId = input.getClassroomId();
		List<Enrollment> currentEnrollments = this.getClassroomDao()
				.findById(input.getClassroomId()).getEnrollments();

		KidsChartNodeDto[] kidsNodes = new KidsChartNodeDto[currentEnrollments
				.size()];
		int counter = 0;
		for (Enrollment enrollment : currentEnrollments) {
			kidsNodes[counter] = new KidsChartNodeDto();
			
			Child currentChild=enrollment.getChild();
			TimeSheet tSheet =enrollment.getTimeSheet();
			
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

		currentEnrollment.setStatus(Enrollment.STATUS_VOID);

		int num = currentEnrollment.getClassroom().getStudentNum();

		currentEnrollment.getClassroom().setStudentNum(num - 1);

		currentEnrollment.setClassroom(null);

		currentChild.setActiveEnrollment(null);

		ContractEndResultDto result = new ContractEndResultDto();
		result.setSuccess(true);
		return result;

	}

	public void enrollmentOfferAccepted(int waitingEntryId) {

		Child currentChild;
		currentChild = this.getWaitingListDao().findById(waitingEntryId)
				.getChild();

		Enrollment currentEnrollment;
		currentEnrollment = currentChild.getActiveEnrollment();

		currentEnrollment.setStatus(Enrollment.STATUS_WAITCONTRACT);

	}

	public void enrollmentOfferRefulsed(int waitingEntryId) {

		WaitingList waitingList = this.getWaitingListDao().findById(
				waitingEntryId);

		Child currentChild = waitingList.getChild();

		Enrollment currentEnrollment = currentChild.getActiveEnrollment();

		currentEnrollment.setStatus(Enrollment.STATUS_VOID);
		currentChild.setActiveEnrollment(null);

		// GET Enrollment Dao?
		// save enrollment?

		int num = currentEnrollment.getClassroom().getStudentNum();

		currentEnrollment.getClassroom().setStudentNum(num - 1);

		currentEnrollment.setClassroom(null);

		waitingList.setStatus(Status.RETURNED);

		this.getWaitingListDao().save(waitingList);

		this.getChildDao().save(currentChild);

	}

	public void enrollmentContracted(int waitingEntryId) {
		// set enrollment status as effective
		// remove child from waitingList

		Child currentChild;

		currentChild = this.getWaitingListDao().findById(waitingEntryId)
				.getChild();

		currentChild.getActiveEnrollment().setStatus(
				Enrollment.STATUS_EFFECTIVE);

		this.getWaitingListDao().delete(
				this.getWaitingListDao().findById(waitingEntryId));

	}

	public PrepareEnrollmentResultDto prepareEnrollment(
			PrepareEnrollmentDto input) {

		// 1. get the child information from UI
		// 2. create Enrollment information , add attending mode, add time sheet
		// 3. assign classroom
		// 4. change waitinglist status

		Child child;
		WaitingList waitingList;

		waitingList = this.getWaitingListDao().findById(
				input.getWaitingListId());

		child = waitingList.getChild();

		Enrollment enrollment = new Enrollment();

		enrollment.setChild(child);
		child.setActiveEnrollment(enrollment);

		// add child into Enrollments's Enrollment List
		// child.setEnrollments(enrollments);;

		enrollment.setTerm(input.getTerm());
		enrollment.setStatus(Enrollment.STATUS_WAITCONFIRM);
		enrollment.setAttendingMode(input.getAttendingMode());

		if (enrollment.getClassroom().getStudentNum() < enrollment
				.getClassroom().getCompacity()) {
			enrollment.setClassroom(input.getClassroom());
			enrollment.getClassroom().setStudentNum(
					enrollment.getClassroom().getStudentNum() + 1);

		}

		else {

			// ??? ??? ask the user choose another classroom
		}

		getEnrollmentDao().save(enrollment);

		waitingList.setStatus(Status.OFFERED);

		PrepareEnrollmentResultDto result = new PrepareEnrollmentResultDto();
		result.setSuccess(true);
		return result;
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
