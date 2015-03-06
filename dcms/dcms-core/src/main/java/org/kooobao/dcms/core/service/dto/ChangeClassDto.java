package org.kooobao.dcms.core.service.dto;

import org.kooobao.dcms.core.dto.Dto;

public class ChangeClassDto extends Dto{
	
	private int childId;
	
	private int targetClassroomId;

	public int getChildId() {
		return childId;
	}

	public void setChildId(int childId) {
		this.childId = childId;
	}

	public int getTargetClassroomId() {
		return targetClassroomId;
	}

	public void setTargetClassroomId(int targetClassroomId) {
		this.targetClassroomId = targetClassroomId;
	}
	
	
	
	

}
