package org.kooobao.dcms.core.service.impl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.kooobao.dcms.core.dao.MemoryChildDao;
import org.kooobao.dcms.core.dao.MemoryClassroomDao;
import org.kooobao.dcms.core.dao.MemoryEnrollmentDao;
import org.kooobao.dcms.core.dao.MemoryWaitingListDao;
import org.kooobao.dcms.core.entity.Child;
import org.kooobao.dcms.core.entity.Classroom;
import org.kooobao.dcms.core.entity.Enrollment;
import org.kooobao.dcms.core.entity.TimeSheet;
import org.kooobao.dcms.core.entity.WaitingList;
import org.kooobao.dcms.core.entity.WaitingList.DisplayStatus;
import org.kooobao.dcms.core.entity.WaitingList.Status;

public class DefaultSettingServiceTest {
	
	private DefaultEnrollmentService service;

	private MemoryEnrollmentDao enrollmentDao;
	private MemoryClassroomDao classroomDao;
	private MemoryChildDao childDao;
	private MemoryWaitingListDao waitingListDao;

	
	@Before
	public void prepareData() {
		service = new DefaultEnrollmentService();

		enrollmentDao = new MemoryEnrollmentDao();
		service.setEnrollmentDao(enrollmentDao);
		
		classroomDao = new MemoryClassroomDao();
		service.setClassroomDao(classroomDao);
		
		childDao = new MemoryChildDao();
		service.setChildDao(childDao);
		
		waitingListDao = new MemoryWaitingListDao();
		service.setWaitingListDao(waitingListDao);

		// Prepare Data
		Classroom clsrm1 = new Classroom();
		clsrm1.setId(1);
		clsrm1.setName("Infant");
		clsrm1.setCapacity(8);
		clsrm1.setStudentNum(1);
		clsrm1.setTerm("spring15");
		
		Classroom clsrm2 = new Classroom();
		
		
		// Child 1
		
		Child c1 = new Child();
		c1.setId(1);
		c1.setLastName("Ma");
		c1.setFirstName("Yun");
		c1.setDateBirth(new Date());
		c1.setAffliation(1);
		c1.setNote("Good Kids");
		childDao.save(c1);

		// Child 2 
		Child c2 = new Child();
		c2.setId(2);
		c2.setFirstName("Helen");
		c2.setLastName("Gu");
		c2.setDateBirth(new Date());
		c2.setAffliation(2);;
		c2.setNote("Bad kids");
		childDao.save(c2);

		Enrollment e = new Enrollment();
		e.setChild(c1);
		e.setClassroom(clsrm1);
		e.setId(1);
		e.setAcceptDate(new Date());
		e.setStatus(Enrollment.Status.EFFECTIVE);
		
		
		TimeSheet timeSheet = new TimeSheet();
		timeSheet.setMondayTime("9:00-3:00");
		timeSheet.setTuesdayTime("10:00-4:00");
		timeSheet.setWednesdayTime("9:00-3:00");
		timeSheet.setThursdayTime("10:00-4:00");
		timeSheet.setFridayTime("11:00-5:00");
		e.setTimeSheet(timeSheet);
		
		
		c1.setActiveEnrollment(e);
		c1.getEnrollments().add(e);
		clsrm1.addEnrollment(e);
		
		c1.setActiveEnrollment(e);
		c1.getEnrollments().add(e);
		clsrm1.addEnrollment(e);
		
		
		// creat another enrollment for c2
		
		Enrollment e2 = new Enrollment();
		e2.setChild(c2);
		e2.setClassroom(clsrm1);
		e2.setId(2);
		e2.setAcceptDate(new Date());
		e2.setStatus(Enrollment.Status.EFFECTIVE);
		
		
		TimeSheet timeSheet2 = new TimeSheet();
		timeSheet.setMondayTime("7:00-1:00");
		timeSheet.setTuesdayTime("8:00-2:00");
		timeSheet.setWednesdayTime("7:00-1:00");
		timeSheet.setThursdayTime("8:00-2:00");
		timeSheet.setFridayTime("7:00-1:00");
		e2.setTimeSheet(timeSheet2);
		

		c2.setActiveEnrollment(e2);
		c2.getEnrollments().add(e2);
		clsrm1.addEnrollment(e2);
		
		enrollmentDao.save(e);
		enrollmentDao.save(e2);
		childDao.save(c1);
		childDao.save(c2);
		classroomDao.save(clsrm1);
		
		//ArrayList<WaitingList> wList = new ArrayList<WaitingList>(); 
		
		WaitingList wl_a=new WaitingList();
		wl_a.setChild(c1);
		wl_a.setStatus(Status.OFFERED);
		wl_a.setDisplayStatus(DisplayStatus.OFFERED);
		wl_a.setId(100);
		//wList.add(wl_a);
		
		
		WaitingList wl_b=new WaitingList();
		wl_b.setChild(c2);
		wl_b.setStatus(Status.NEW);
		wl_b.setDisplayStatus(DisplayStatus.RETURNED_TO_LIST);
		wl_b.setId(101);
		//wList.add(wl_b);
		
		waitingListDao.save(wl_a);
		waitingListDao.save(wl_b);
		
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
