package org.kooobao.common.dao;

import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.converters.Converter;
import org.eclipse.persistence.sessions.Session;
import org.kooobao.dcms.core.entity.WaitingList.Status;

public class StatusEnumConverter implements Converter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1153230153328582797L;

	@Override
	public Object convertObjectValueToDataValue(Object objectValue,
			Session session) {
		Status status = (Status) objectValue;
		return status.ordinal();
	}

	@Override
	public Object convertDataValueToObjectValue(Object dataValue,
			Session session) {
		Integer value = (Integer) dataValue;
		return Status.values()[value];
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public void initialize(DatabaseMapping mapping, Session session) {

	}

}
