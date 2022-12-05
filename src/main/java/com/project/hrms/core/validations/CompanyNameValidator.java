package com.project.hrms.core.validations;

import com.project.hrms.core.utilities.results.ErrorResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessResult;

public class CompanyNameValidator {

	public static Result valid (String name) {
		if (name == "") {
			return new ErrorResult("Şirket ismi boş geçilemez!");
		}
		return new SuccessResult();
	}
	
	public static Result jobAdvertisementValid (String name) {
		if (name == "")
		return new ErrorResult("Şirket ismiyle uyuşan bir ilan bulunamadı");
		return new SuccessResult();
	}
	
}
