package org.kooobao.dcms.core.entity;

import java.util.Date;

import org.kooobao.common.dao.Entity;

public class EventLog extends Entity{

	private Child child;
	private String note;
	private String event;
	private Date eventDate;

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

}
