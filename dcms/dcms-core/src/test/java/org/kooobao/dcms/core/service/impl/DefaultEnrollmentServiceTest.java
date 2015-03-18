package org.kooobao.dcms.core.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
import org.kooobao.dcms.core.entity.WaitingList;
import org.kooobao.dcms.core.entity.WaitingList.DisplayStatus;
import org.kooobao.dcms.core.entity.WaitingList.Status;
import org.kooobao.dcms.core.service.dto.PrepareEnrollmentDto;
import org.kooobao.dcms.core.service.dto.PrepareEnrollmentResultDto;

public class DefaultEnrollmentServiceTest {

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
		
		// .....
		classroomDao.save(clsrm1);
		

		Child c1 = new Child();
		c1.setId(1);
		c1.setLastName("Ma");
		c1.setFirstName("Yun");
		
		// ....
		childDao.save(c1);

		Child c2 = new Child();
		c2.setId(2);
		c2.setFirstName("Helen");
		c2.setLastName("Gu");
		childDao.save(c2);

		Enrollment e = new Enrollment();
		e.setChild(c1);
		e.setClassroom(clsrm1);
		e.setId(1);
		e.setAcceptDate(new Date());
		e.setStatus(Enrollment.Status.PREPARE);
		//e.setTerm("Spring15");
		// ....
		enrollmentDao.save(e);
		
		//ArrayList<WaitingList> wList = new ArrayList<WaitingList>(); 
		
		
		WaitingList wl_a=new WaitingList();
		wl_a.setChild(c1);
		wl_a.setStatus(Status.NEW);
		wl_a.setDisplayStatus(DisplayStatus.KEEP_ON_LIST);
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
	public void testChangeClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testProjectEnrolChart() {
		fail("Not yet implemented");
	}

	@Test
	public void testGenerateEnrolChart() {
		fail("Not yet implemented");
	}

	@Test
	public void testContractEnded() {
		fail("Not yet implemented");
	}

	@Test
	public void testEnrollmentOfferAccepted() {
		fail("Not yet implemented");
	}

	@Test
	public void testEnrollmentOfferRefused() {
		fail("Not yet implemented");
	}

	@Test
	public void testEnrollmentContractFail() {
		fail("Not yet implemented");
	}

	@Test
	public void testEnrollmentContracted() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrepareEnrollment() {
		// Create DTO
		PrepareEnrollmentDto input = new PrepareEnrollmentDto();
		input.setAcceptDate(new Date());
		input.setWaitingListId(101);
		input.setAcceptDate(new Date());
		input.setAttendingMode(2);
		input.setClassroomName("Infant");;
		input.setContractFrom(new Date());
		input.setTueTime("9-3");
		input.setThuTime("10-4");
		input.setTerm("spring15");
		
		
		// ....

		// Invoke Service Method
		PrepareEnrollmentResultDto result = service.prepareEnrollment(input);

		// Check ResultDto and Dao
		assertTrue(result.isSuccess());

		//Enrollment ae = childDao.findById(2).getActiveEnrollment();
		//assertNotNull(ae);
		
		Enrollment ae = enrollmentDao.findByStatusForChild(Enrollment.Status.PREPARE,childDao.findById(2));
		assertNotNull(ae);
		
		assertEquals(waitingListDao.findById(101).getStatus(),WaitingList.Status.OFFERED);
		
		//assertEquals(Enrollment.Status.PREPARE, ae.getStatus());
	}

}
