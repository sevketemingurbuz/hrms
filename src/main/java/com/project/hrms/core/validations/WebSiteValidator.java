package com.project.hrms.core.validations;

import com.project.hrms.core.utilities.results.ErrorResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessResult;

public class WebSiteValidator {

	public static Result valid (String webSite) {
		if (webSite == "") {
			return new ErrorResult("Web site boş geçilemez!");
		}
		return new SuccessResult();
	}
}
