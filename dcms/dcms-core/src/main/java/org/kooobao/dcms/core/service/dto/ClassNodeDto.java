package org.kooobao.dcms.core.service.dto;

public class ClassNodeDto {

	String className;

	int capacity;

	private KidsChartNodeDto[] nodes;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public KidsChartNodeDto[] getNodes() {
		return nodes;
	}

	public void setNodes(KidsChartNodeDto[] nodes) {
		this.nodes = nodes;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}