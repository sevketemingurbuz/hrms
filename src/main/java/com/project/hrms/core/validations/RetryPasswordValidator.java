package com.project.hrms.core.validations;

import com.project.hrms.core.utilities.results.ErrorResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessResult;

public class RetryPasswordValidator {

	public static Result valid (String retryPassword) {
		if (retryPassword ==  "") {
			return new ErrorResult("Şifre tekrarı boş geçirilemez!");
		}
		return new SuccessResult();
	}
}
