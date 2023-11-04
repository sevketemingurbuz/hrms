package com.project.hrms.core.validations;

import java.time.LocalDateTime;

import com.project.hrms.core.utilities.results.ErrorResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessResult;

public class DeadlineValidator {

	public static Result valid (String string) {
		if (string == null) {
			return new ErrorResult("Son başvuru tarihi boş geçilemez");
		}
		return new SuccessResult();
	}
	
}
