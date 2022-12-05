package com.project.hrms.core.validations;

import com.project.hrms.core.utilities.results.ErrorResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessResult;

public class IdentificationValidator {

	public static Result valid (String identification) {
		if (identification == "") {
			return new ErrorResult("Kimlik no boş bırakılmaz");
		}
		return new SuccessResult();
	}
}
