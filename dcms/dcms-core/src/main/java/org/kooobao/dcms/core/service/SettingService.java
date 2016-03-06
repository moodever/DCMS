package org.kooobao.dcms.core.service;

import org.kooobao.dcms.core.service.dto.GenerateClassForTermDto;
import org.kooobao.dcms.core.service.dto.GenerateClassForTermResultDto;

public interface SettingService {

	public GenerateClassForTermResultDto generateClassForTerm(
			GenerateClassForTermDto input);

}
