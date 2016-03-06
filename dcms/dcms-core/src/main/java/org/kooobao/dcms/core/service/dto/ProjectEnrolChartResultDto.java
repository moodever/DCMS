package org.kooobao.dcms.core.service.dto;

import org.kooobao.dcms.core.dto.ResultDto;

public class ProjectEnrolChartResultDto extends ResultDto {

	private ClassNodeDto[] nodes;

	public ClassNodeDto[] getNodes() {
		return nodes;
	}

	public void setNodes(ClassNodeDto[] nodes) {
		this.nodes = nodes;
	}
	

	
/*	private KidsChartNodeDto[][] nodes;
*
*	public KidsChartNodeDto[][] getNodes() {
*		return nodes;
*	}
*
*	public void setNodes(KidsChartNodeDto[][] nodes) {
*		this.nodes = nodes;
*	}
*/
	
}


