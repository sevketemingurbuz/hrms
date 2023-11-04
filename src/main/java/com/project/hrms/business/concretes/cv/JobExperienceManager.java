package com.project.hrms.business.concretes.cv;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.hrms.business.abstracts.cv.JobExperienceService;
import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessDataResult;
import com.project.hrms.core.utilities.results.SuccessResult;
import com.project.hrms.dataAccess.abstracts.cv.JobExperienceDao;
import com.project.hrms.entities.concretes.cv.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService{

	JobExperienceDao jobExperienceDao;
	
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		this.jobExperienceDao= jobExperienceDao;
	}
	
	public Result add(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("İş tecrübeleri eklendi");
	}
	
	public DataResult<List<JobExperience>> getAll(){
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll()) ;
	}
	
	public DataResult<List<JobExperience>> getByCvId(int id){
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.getByCv_CvIdOrderByEndYearDesc(id), 
				"Geçmiş iş tecrübeleri tarihe göre listelendi");
	}
	
	
}
