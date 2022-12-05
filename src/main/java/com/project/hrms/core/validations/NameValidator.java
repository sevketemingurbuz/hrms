package com.project.hrms.core.validations;

import com.project.hrms.core.utilities.results.ErrorResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessResult;

public class NameValidator {

	public static Result valid (String name) {
		if (name == "") {
			return new ErrorResult("İsim boş geçilemez");
		}
		return new SuccessResult();
	}
	
	
}
