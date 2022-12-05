package com.project.hrms.core.validations;

import com.project.hrms.core.utilities.results.ErrorResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessResult;

public class EmailValidator {

	public static Result valid (String mail) {
		if (mail == "") {
			return new ErrorResult("Mail boş geçilemez");
		}
		return new SuccessResult();
	}
}
