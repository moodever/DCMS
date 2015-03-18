package org.kooobao.dcms.core.service.common;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.kooobao.dcms.core.dto.ResultDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorHandler {
	Logger logger = LoggerFactory.getLogger(getClass());

	public Object checkError(ProceedingJoinPoint pjp) throws Throwable {
		try {
			Object result = pjp.proceed();
			return result;
		} catch (Exception e) {
			logger.warn("Error captured in service method", e);
			MethodSignature signature = (MethodSignature) pjp.getSignature();
			Method method = signature.getMethod();
			Object dto = method.getReturnType().newInstance();
			if (dto instanceof ResultDto) {
				((ResultDto) dto).setErrorMessage(e.getMessage());
				((ResultDto) dto).setSuccess(false);
				return dto;
			}
			throw new RuntimeException("Return type is not a ResultDto:"
					+ dto.getClass());
		}
	}
}
