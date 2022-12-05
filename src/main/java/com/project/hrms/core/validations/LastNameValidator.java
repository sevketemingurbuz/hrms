package com.project.hrms.core.validations;

import com.project.hrms.core.utilities.results.ErrorResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessResult;

public class LastNameValidator {

	public static Result valid (String lastName) {
		if (lastName == "") {
			return new ErrorResult("Soyad boş geçilemez!");
		}
		return new SuccessResult();
	}
	
	
}
