package org.kooobao.dcms.core.dao;

import java.util.List;

import org.kooobao.common.dao.Dao;
import org.kooobao.dcms.core.entity.WaitingList;

public interface WaitingListDao extends Dao<WaitingList> {

	List<WaitingList> findValid();

}
