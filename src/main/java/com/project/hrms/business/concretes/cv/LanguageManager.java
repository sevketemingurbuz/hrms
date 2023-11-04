package com.project.hrms.business.concretes.cv;

import org.springframework.stereotype.Service;

import com.project.hrms.business.abstracts.cv.LanguageService;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessResult;
import com.project.hrms.dataAccess.abstracts.cv.LanguageDao;
import com.project.hrms.entities.concretes.cv.Language;

@Service
public class LanguageManager implements LanguageService{
	
	LanguageDao languageDao;
	
	public LanguageManager(LanguageDao languageDao) {
		this.languageDao= languageDao;
	}
	
	public Result add (Language language) {
		this.languageDao.save(language);
		return new SuccessResult("Yabancı dil eklendi");
	}

}
