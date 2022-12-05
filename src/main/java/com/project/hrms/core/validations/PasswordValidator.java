package com.project.hrms.core.validations;

import com.project.hrms.core.utilities.results.ErrorResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessResult;

public class PasswordValidator {

	public static Result valid (String password) {
		if (password == "") {
			return new ErrorResult("Şİfre boş geçilemez!");
		}
		return new SuccessResult();
	}
}
