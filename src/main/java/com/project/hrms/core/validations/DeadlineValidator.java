package com.project.hrms.core.validations;

import java.util.Date;

import com.project.hrms.core.utilities.results.ErrorResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessResult;

public class DeadlineValidator {

	public static Result valid (Date date) {
		if (date == null) {
			return new ErrorResult("Son başvuru tarihi boş geçilemez");
		}
		return new SuccessResult();
	}
	
}
