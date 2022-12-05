package com.project.hrms.core.validations;

import com.project.hrms.core.utilities.results.ErrorResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessResult;

public class TelNoValidator {

	public static Result valid (String telNo) {
		if (telNo == "") {
			return new ErrorResult("Telefon numarası boş geçilemez!");
		}
		return new SuccessResult();
	}
}
