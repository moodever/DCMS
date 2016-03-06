package org.kooobao.dcms.core.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.kooobao.dcms.core.dao.ChildDao;
import org.kooobao.dcms.core.dao.WaitingListDao;
import org.kooobao.dcms.core.entity.AttendingMode;
import org.kooobao.dcms.core.entity.Child;
import org.kooobao.dcms.core.entity.Contact;
import org.kooobao.dcms.core.entity.WaitingList;
import org.kooobao.dcms.core.entity.WaitingList.DisplayStatus;
import org.kooobao.dcms.core.entity.WaitingList.Status;
import org.kooobao.dcms.core.service.WaitingListService;
import org.kooobao.dcms.core.service.dto.ContactDto;
import org.kooobao.dcms.core.service.dto.DeleteWaitingEntryDto;
import org.kooobao.dcms.core.service.dto.DeleteWaitingEntryResultDto;
import org.kooobao.dcms.core.service.dto.EnrollmentListDto;
import org.kooobao.dcms.core.service.dto.FindEnrollmentListDto;
import org.kooobao.dcms.core.service.dto.FindEnrollmentListResultDto;
import org.kooobao.dcms.core.service.dto.FindWaitingListDto;
import org.kooobao.dcms.core.service.dto.FindWaitingListResultDto;
import org.kooobao.dcms.core.service.dto.NotifyWaitingListDto;
import org.kooobao.dcms.core.service.dto.NotifyWaitingListResultDto;
import org.kooobao.dcms.core.service.dto.SaveWaitingEntryDto;
import org.kooobao.dcms.core.service.dto.SaveWaitingEntryResultDto;
import org.kooobao.dcms.core.service.dto.WaitingListDto;

public class DefaultWaitingListService implements WaitingListService {

	// --------- change waitinglist status method---------------
	// get waiting list id from UI
	// find waiting list entry from
	// Change the entry information
	// save the entry into db

	public NotifyWaitingListResultDto notifyWaitingList(
			NotifyWaitingListDto input) {
		WaitingList waitingList;
		waitingList = this.getWaitingListDao().findById(
				input.getWaitingListID());
		waitingList.setStatus(Status.valueOf((input.getWaitingListStatus())));

		getWaitingListDao().save(waitingList);

		NotifyWaitingListResultDto result = new NotifyWaitingListResultDto();
		result.setSuccess(true);
		return result;

	}

	// ---------- Add a child into waiting list Method--------

	public SaveWaitingEntryResultDto saveWaitingEntry(SaveWaitingEntryDto input) {

		Child child;
		WaitingList waitingList;
		// if the id could be find, then update the waiting list entry.
		// If the id can not be find, then create a new waiting list entry
		if (input.getWaitingListID() != -1) {

			child = this.getChildDao().findById(input.getChildID());
			waitingList = this.getWaitingListDao().findById(
					input.getWaitingListID());
		} else {
			child = new Child();

			waitingList = new WaitingList();
			// Fill the information of waiting list here
		}

		// Fill in the information of child here
		child.setFirstName(input.getChildFirstName());
		child.setMiddleName(input.getChildMiddleName());
		child.setLastName(input.getChildLastName());
		child.setDateBirth(input.getChildDateBirth());

		child.setNote(input.getChildNote());
		child.setPhone(input.getPhone());
		child.setSliblingId(input.getSliblingId());
		child.setActiveEnrollment(null);
		child.setAffliation(input.getAffliation());
		// ? child.setTimeSheet(null);
		// ? child.setEnrollments(null);

		

		List<Contact> contacts = new ArrayList<Contact>();
		for (ContactDto dto : input.getContacts()) {
			Contact contact = new Contact();
			// Fill in the information from DTO
			contact.setAddress(dto.getAddress());
			contact.setEmail(dto.getEmail());
			contact.setFirstName(dto.getFirstName());
			contact.setLastName(dto.getLastName());
			contact.setMiddleName(dto.getMiddleName());
			contact.setNote(dto.getNote());
			contact.setPhone1(dto.getPhone1());
			contact.setPhone2(dto.getPhone2());
			contact.setRole(dto.getRole());
			contact.setStatus(dto.getStatus());

			contacts.add(contact);
		}

		child.setContacts(contacts);
		
		child = getChildDao().save(child);

		waitingList.setApplicationDate(input.getApplicationDate());
		waitingList.setAttendingMode(AttendingMode.values()[input
				.getAttendingMode()]);
		waitingList.setCustomizedSequence(input.getCustomizedSequence());
		waitingList.setDesireDate(input.getDesireDate());
		waitingList.setExpectGrade(input.getExpectGrade());
	
		waitingList.setOfferedDate(input.getOfferedDate());
		waitingList.setStatus(Status.values()[input.getStatus()]);
		waitingList.setDisplayStatus(DisplayStatus.values()[input.getStatus()]);
		waitingList.setNote(input.getNote());

		waitingList.setChild(child);
		getWaitingListDao().save(waitingList);

		SaveWaitingEntryResultDto result = new SaveWaitingEntryResultDto();
		result.setSuccess(true);
		return result;
	}

	// ---------- End--------

	// ---------- Delete a child from waiting list Method--------

	public DeleteWaitingEntryResultDto deleteWaitingEntry(
			DeleteWaitingEntryDto input) {

		int tempWaitingListEntryID = input.getWaitingListID();

		WaitingList targetWaitingList = this.getWaitingListDao().findById(
				tempWaitingListEntryID);

		if (targetWaitingList == null) {

			throw new IllegalArgumentException();

		}
		// delete related enrollment if there is any
		//
		this.getWaitingListDao().delete(targetWaitingList);

		DeleteWaitingEntryResultDto result = new DeleteWaitingEntryResultDto();
		result.setSuccess(true);
		return result;
	}

	@Override
	public FindWaitingListResultDto findWaitingList(FindWaitingListDto input) {
		List<WaitingList> list = getWaitingListDao().findValid();
		WaitingListDto[] wldtos = new WaitingListDto[list.size()];

		int counter = 0;
		for (WaitingList wl : list) {
			wldtos[counter] = new WaitingListDto();
			wldtos[counter].setId(wl.getId());
			wldtos[counter].setName(formatName(wl.getChild()));

			wldtos[counter].setDateOfBirth(wl.getChild().getDateBirth());
			wldtos[counter].setPhone(wl.getChild().getPhone());
			wldtos[counter].setStatus(wl.getStatus().name());
			wldtos[counter].setDisplayStatus(wl.getDisplayStatus().name());
			wldtos[counter].setAffiliation(wl.getChild().getAffliation());

			wldtos[counter].setApplicationDate(wl.getApplicationDate());
			wldtos[counter].setDesireDate(wl.getDesireDate());
			wldtos[counter].setExpectGrade(wl.getExpectGrade());
			wldtos[counter].setAttendingMode(wl.getAttendingMode().toString());
			wldtos[counter].setNote(wl.getNote()); 

			if (wl.getChild().getContacts().isEmpty() == false) {

				wldtos[counter].setFirstParentName(formatName(wl.getChild().getContacts().get(0)));
				wldtos[counter].setFirstParentRole(wl.getChild().getContacts()
						.get(0).getRole());
				wldtos[counter].setFirstParentStatus(wl.getChild()
						.getContacts().get(0).getStatus());
			} else {

				wldtos[counter].setFirstParentName("N/A");
				wldtos[counter].setFirstParentRole("N/A");
				wldtos[counter].setFirstParentStatus("N/A");
			}

			if (wl.getChild().getContacts().size() >= 2) {

				wldtos[counter].setSecondParentName(formatName(wl.getChild().getContacts().get(1)));
				wldtos[counter].setSecondParentRole(wl.getChild().getContacts()
						.get(1).getRole());
				wldtos[counter].setSecondParentStatus(wl.getChild()
						.getContacts().get(1).getStatus());
			}else {

				wldtos[counter].setSecondParentName("N/A");
				wldtos[counter].setSecondParentRole("N/A");
				wldtos[counter].setSecondParentStatus("N/A");
			}	

			counter++;
		}

		FindWaitingListResultDto result = new FindWaitingListResultDto();
		result.setWaitingLists(wldtos);
		return result;
	}

	@Override
	public FindEnrollmentListResultDto findEnrollmentList(
			FindEnrollmentListDto input) {
		List<WaitingList> list = getWaitingListDao().findEnrolledChild();
		EnrollmentListDto[] wldtos = new EnrollmentListDto[list.size()];

		int counter = 0;
		for (WaitingList wl : list) {
			wldtos[counter] = new EnrollmentListDto();
			wldtos[counter].setId(wl.getId());
			wldtos[counter].setName(formatName(wl.getChild()));
			wldtos[counter].setDateOfBirth(wl.getChild().getDateBirth());
			wldtos[counter].setStatus(wl.getStatus().name());
			wldtos[counter].setDisplayStatus(wl.getDisplayStatus().name());
			wldtos[counter].setAffiliation(wl.getChild().getAffliation());
			wldtos[counter].setNote(wl.getChild().getNote()); 
			wldtos[counter].setEnrolledClass(wl.getChild().getActiveEnrollment().getClassroom().getName());
			wldtos[counter].setEnrolledTerm(wl.getChild().getActiveEnrollment().getClassroom().getTerm());
			
			counter++;
		}

		FindEnrollmentListResultDto result = new FindEnrollmentListResultDto();
		result.setEnrollmentLists(wldtos);
		return result;
	}

	private ChildDao childDao;

	private WaitingListDao waitingListDao;

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
	
	
	public static String formatName(Contact input){
		
		String nameResult = new String("");
		
		if(input.getMiddleName() !=null){
			
		nameResult = MessageFormat.format("{0} {1} {2}", input.getFirstName(), input.getMiddleName(),
				input.getLastName());
		
		return nameResult;
		
		} else {
			
			nameResult = MessageFormat.format("{0} {1}", input.getFirstName(), 
					input.getLastName());
		return nameResult;
			
		}
			
	}
	
	public static String formatName(Child input){
		
		String nameResult = new String("");
		
		if(input.getMiddleName() !=null){
			
		nameResult = MessageFormat.format("{0} {1} {2}", input.getFirstName(), input.getMiddleName(),
				input.getLastName());
		
		return nameResult;
		
		} else {
			
			nameResult = MessageFormat.format("{0} {1}", input.getFirstName(), 
					input.getLastName());
		return nameResult;
			
		}
			
	}

}
