package org.kooobao.dcms.core.service.dto;

import org.kooobao.dcms.core.dto.ResultDto;
import org.kooobao.dcms.core.entity.Classroom;

public class GenerateClassForTermResultDto extends ResultDto{

	private ClassroomDto[] classroomNodes;

	public ClassroomDto[] getClassroomNodes() {
		return classroomNodes;
	}

	public void setClassroomNodes(ClassroomDto[] classroomNodes) {
		this.classroomNodes = classroomNodes;
	} 
	
	
	
}
