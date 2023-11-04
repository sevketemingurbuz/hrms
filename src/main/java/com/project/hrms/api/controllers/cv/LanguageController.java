package com.project.hrms.api.controllers.cv;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrms.business.abstracts.cv.LanguageService;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.entities.concretes.cv.Language;

@RestController
@RequestMapping("/api/language")
public class LanguageController {
	
	LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService= languageService;
	}
	
	@PostMapping("/add")
	public Result add (@RequestBody Language language) {
		return this.languageService.add(language);
	}
	

}
