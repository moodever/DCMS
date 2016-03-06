package org.kooobao.dcms.core.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeSheetTest {

	@Test
	public void testParse() {
		assertArrayEquals(new Boolean[] { true, true, true, false, false,
				false, false, false, false, false, false, false, false, false,
				false, false, false, false, false, false },
				TimeSheet.parse("7:30 - 9:00"));

		assertArrayEquals(new Boolean[] { true, true, true, false, false,
				false, true, true, true, false, false, false, false, false,
				false, false, false, false, false, false },
				TimeSheet.parse("7:30-9:00, 10:30 - 12:00"));

		assertArrayEquals(new Boolean[] { false, false, false, false, false,
				false, false, false, false, false, false, false, false, false,
				false, false, false, false, false, true },
				TimeSheet.parse("17:00 - 17:30"));
	}

	@Test
	public void testTimeIndex() {
		assertEquals(0, TimeSheet.timeIndex("7:30"));

		assertEquals(1, TimeSheet.timeIndex("8"));
		assertEquals(1, TimeSheet.timeIndex("8:00"));

		assertEquals(2, TimeSheet.timeIndex("8:30"));

		assertEquals(3, TimeSheet.timeIndex("9"));
		assertEquals(3, TimeSheet.timeIndex("9:00"));

		assertEquals(4, TimeSheet.timeIndex("9:30"));

		assertEquals(5, TimeSheet.timeIndex("10"));
		assertEquals(5, TimeSheet.timeIndex("10:00"));

		assertEquals(6, TimeSheet.timeIndex("10:30"));

		assertEquals(7, TimeSheet.timeIndex("11"));
		assertEquals(7, TimeSheet.timeIndex("11:00"));

		assertEquals(8, TimeSheet.timeIndex("11:30"));

		assertEquals(9, TimeSheet.timeIndex("12"));
		assertEquals(9, TimeSheet.timeIndex("12:00"));
	}

}
