package org.kooobao.dcms.core.entity;

import java.util.Calendar;
import java.util.Date;

public class DateUtility {

	public static int getWeekSpan(Date datePast, Date dateNow) {
		if (datePast.after(dateNow) || datePast.equals(dateNow))
			return 0;
		Calendar c = Calendar.getInstance();
		c.setTime(datePast);
		int week = 0;
		while (c.getTime().before(dateNow)) {
			c.add(Calendar.WEEK_OF_YEAR, 1);
			week++;
		}
		return week;
	}

}
