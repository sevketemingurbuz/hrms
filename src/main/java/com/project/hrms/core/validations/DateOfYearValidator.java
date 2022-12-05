package com.project.hrms.core.validations;

import com.project.hrms.core.utilities.results.ErrorResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessResult;

public class DateOfYearValidator {

	public static Result valid (String dateOfYear) {
		if (dateOfYear == "") {
			return new ErrorResult("Tarih boş geçilemez!");
		}
		
		return new SuccessResult();
	}
	
	
}
