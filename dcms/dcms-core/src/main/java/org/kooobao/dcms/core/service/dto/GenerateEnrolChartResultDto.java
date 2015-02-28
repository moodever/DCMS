package org.kooobao.dcms.core.service.dto;

import org.kooobao.dcms.core.dto.ResultDto;

public class GenerateEnrolChartResultDto extends ResultDto{

	
	KidsChartNodeDto[] kidsChartNodeDto;

	public KidsChartNodeDto[] getKidsChartNodeDto() {
		return kidsChartNodeDto;
	}

	public void setKidsChartNodeDto(KidsChartNodeDto[] kidsChartNodeDto) {
		this.kidsChartNodeDto = kidsChartNodeDto;
	}
	
	
	
}
