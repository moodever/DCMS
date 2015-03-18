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
import org.kooobao.dcms.core.entity.WaitingList.Status;
import org.kooobao.dcms.core.service.WaitingListService;
import org.kooobao.dcms.core.service.dto.ContactDto;
import org.kooobao.dcms.core.service.dto.DeleteWaitingEntryDto;
import org.kooobao.dcms.core.service.dto.DeleteWaitingEntryResultDto;
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
		child.setActiveEnrollment(null);

		child.setAffliation(input.getAffliation());

		child.setLastName(input.getChildLastName());

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

		child.setDateBirth(input.getChildDateBirth());
		// ? child.setEnrollments(null);
		child.setMiddleName(input.getChildMiddleName());
		child.setNote(input.getNote());
		child.setSliblingId(input.getSliblingId());
		// ?child.setTimeSheet(null);

		child = getChildDao().save(child);

		waitingList.setApplicationDate(input.getApplicationDate());
		waitingList.setAttendingMode(AttendingMode.values()[input.getAttendingMode()]);
		waitingList.setCustomizedSequence(input.getCustomizedSequence());
		waitingList.setDesireDate(input.getDesireDate());
		waitingList.setExpectGrade(input.getExpectGrade());
		waitingList.setNote(input.getNote());
		waitingList.setOfferedDate(input.getOfferedDate());
		waitingList.setStatus(Status.values()[input.getStatus()]);

		waitingList.setChild(child);
		getWaitingListDao().save(waitingList);

		SaveWaitingEntryResultDto result = new SaveWaitingEntryResultDto();
		result.setSuccess(true);
		return result;
	}

	// ---------- End--------

	// ---------- Delete a child fr waiting list Method--------

	public DeleteWaitingEntryResultDto deleteWaitingEntry(
			DeleteWaitingEntryDto input) {

		int tempWaitingListEntryID = input.getWaitingListID();

		WaitingList targetWaitingList = this.getWaitingListDao().findById(
				tempWaitingListEntryID);

		if (targetWaitingList == null) {

			throw new IllegalArgumentException();

		}
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
			wldtos[counter].setName(MessageFormat.format("{0} {1} {2}", wl
					.getChild().getFirstName(), wl.getChild().getMiddleName(),
					wl.getChild().getLastName()));
			wldtos[counter].setDateOfBirth(wl.getChild().getDateBirth());
			wldtos[counter].setStatus(wl.getStatus().name());
			wldtos[counter].setDisplayStatus(wl.getDisplayStatus().name());
			wldtos[counter].setAffiliation(wl.getChild().getAffliation());
			counter++;
		}

		FindWaitingListResultDto result = new FindWaitingListResultDto();
		result.setWaitingLists(wldtos);
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

}
