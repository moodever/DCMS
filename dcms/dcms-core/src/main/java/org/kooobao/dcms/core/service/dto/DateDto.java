package org.kooobao.dcms.core.service.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDto {

	private String date;

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public Date toDate() {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
