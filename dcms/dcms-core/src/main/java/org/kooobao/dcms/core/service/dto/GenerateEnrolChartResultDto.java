package org.kooobao.dcms.core.service.dto;

import org.kooobao.dcms.core.dto.ResultDto;

public class GenerateEnrolChartResultDto extends ResultDto{

	
	private KidsChartNodeDto[] kidsChartNodes;

	public KidsChartNodeDto[] getKidsChartNodes() {
		return kidsChartNodes;
	}

	public void setKidsChartNodeDto(KidsChartNodeDto[] kidsChartNodes) {
		this.kidsChartNodes = kidsChartNodes;
	}
	
	
	
}
