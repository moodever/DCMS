package org.kooobao.dcms.core.service.dto;

import org.kooobao.dcms.core.dto.ResultDto;

public class ViewTimesheetResultDto extends ResultDto {

	TimesheetEntryDto[] entries;

	TimesheetSummaryDto summary;

	public TimesheetEntryDto[] getEntries() {
		return entries;
	}

	public void setEntries(TimesheetEntryDto[] entries) {
		this.entries = entries;
	}

	public TimesheetSummaryDto getSummary() {
		return summary;
	}

	public void setSummary(TimesheetSummaryDto summary) {
		this.summary = summary;
	}

}
