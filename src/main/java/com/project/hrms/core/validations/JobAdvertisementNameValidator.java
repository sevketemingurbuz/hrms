package com.project.hrms.core.validations;

import com.project.hrms.core.utilities.results.ErrorResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessResult;

public class JobAdvertisementNameValidator {

	public static Result valid(String name) {
		if(name == "") {
			return new ErrorResult("İş ilanı ismi boş geçilemez");
		}
		return new SuccessResult();
	}
}
