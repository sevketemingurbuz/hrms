package com.project.hrms.core.validations;

import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessResult;

public class EmailPersonelCheckValidator {

	public static Result valid (String email) {
		return new SuccessResult();
	}
}
