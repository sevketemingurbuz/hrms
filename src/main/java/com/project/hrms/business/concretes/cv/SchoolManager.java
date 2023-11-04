package com.project.hrms.business.concretes.cv;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.hrms.business.abstracts.cv.SchoolService;
import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessDataResult;
import com.project.hrms.core.utilities.results.SuccessResult;
import com.project.hrms.dataAccess.abstracts.cv.SchoolDao;
import com.project.hrms.entities.concretes.cv.School;

@Service
public class SchoolManager implements SchoolService{
	
	SchoolDao schoolDao;

	public SchoolManager(SchoolDao schoolDao) {
		this.schoolDao= schoolDao;
	}
	
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("Okul bilgileri eklendi");
	}
	
	public DataResult<List<School>> getAll(){
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(), "Okul bilgileri listelendi");
	}
	
	public DataResult<List<School>> getByCvId(int id){
		return new SuccessDataResult<List<School>>(this.schoolDao.getByCv_CvIdOrderByEndYearDesc(id), "Okul bilgileri tarihe göre listelendi");
	}

	
}
