package org.kooobao.dcms.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.kooobao.common.dao.Entity;

@javax.persistence.Entity
@Table(name = "dcms_event_log")
public class EventLog extends Entity {

	@OneToOne
	@JoinColumn(name = "child_id")
	private Child child;

	@Column
	private String note;

	@Column
	private String event;

	@Column
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
