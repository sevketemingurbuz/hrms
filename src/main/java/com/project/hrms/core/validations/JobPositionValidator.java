package com.project.hrms.core.validations;

import com.project.hrms.core.utilities.results.ErrorResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessResult;

public class JobPositionValidator {

	public static Result valid (String jobPosition) {
		
		if (jobPosition == "") {
			return new ErrorResult("İş pozisyonu boş geçilemez!");
		}
		
		return new SuccessResult();
	}
	
}
