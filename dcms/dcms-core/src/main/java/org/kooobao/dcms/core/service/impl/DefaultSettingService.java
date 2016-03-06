package org.kooobao.dcms.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.kooobao.dcms.core.dao.ChildDao;
import org.kooobao.dcms.core.dao.ClassroomDao;
import org.kooobao.dcms.core.dao.EnrollmentDao;
import org.kooobao.dcms.core.dao.WaitingListDao;
import org.kooobao.dcms.core.entity.Classroom;
import org.kooobao.dcms.core.service.SettingService;
import org.kooobao.dcms.core.service.dto.ClassroomDto;
import org.kooobao.dcms.core.service.dto.GenerateClassForTermDto;
import org.kooobao.dcms.core.service.dto.GenerateClassForTermResultDto;

public class DefaultSettingService implements SettingService {

	public GenerateClassForTermResultDto generateClassForTerm(
			GenerateClassForTermDto input) {

		GenerateClassForTermResultDto result = new GenerateClassForTermResultDto();

		String newTerm = Classroom.calculateTerm(input.getDate());

		if (!this.getClassroomDao().findByTerm(newTerm).isEmpty()) {
			result.setSuccess(false);
			result.setErrorMessage("This term already exist");
			return result;
		} else {
			List<Classroom> tempClassroomList = this.getClassroomDao()
					.findByTerm("spring15");
			List<Classroom> targetClassroomList = new ArrayList<Classroom>();
			for (Classroom x : tempClassroomList) {
				Classroom cr = new Classroom();
				cr.setName(x.getName());
				cr.setStudentNum(x.getStudentNum());
				cr.setGrade(x.getGrade());
				cr.setEnrollments(null);
				cr.setCapacity(x.getCapacity());
				cr.setAgeFrom(x.getAgeFrom());
				cr.setAgeTo(x.getAgeTo());
				cr.setTerm(newTerm);

				targetClassroomList.add(cr);

				this.getClassroomDao().save(cr);

			}

			// Classroom[] tempbuffer = new
			// Classroom[targetClassroomList.size()];
			// targetClassroomList.toArray(tempbuffer);

			ClassroomDto[] tempClassroomDto = new ClassroomDto[targetClassroomList
					.size()];

			int count = 0;

			for (Classroom clsx : targetClassroomList) {
				tempClassroomDto[count] = new ClassroomDto();
				tempClassroomDto[count].setId(clsx.getId());
				tempClassroomDto[count].setName(clsx.getName());
				tempClassroomDto[count].setGrade(clsx.getGrade());
				tempClassroomDto[count].setStudentNum(clsx.getStudentNum());
				tempClassroomDto[count].setTerm(clsx.getTerm());
				tempClassroomDto[count].setCapacity(clsx.getCapacity());
				tempClassroomDto[count].setAgeFrom((int) clsx.getAgeFrom());
				tempClassroomDto[count].setAgeTo((int) clsx.getAgeTo());
				count++;
			}

			result.setClassroomNodes(tempClassroomDto);

			result.setSuccess(true);

			return result;

		}

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
