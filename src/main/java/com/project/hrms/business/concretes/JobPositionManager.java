package com.project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hrms.business.abstracts.JobPositionService;
import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.ErrorResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessDataResult;
import com.project.hrms.core.utilities.results.SuccessResult;
import com.project.hrms.core.validations.JobPositionValidator;
import com.project.hrms.dataAccess.abstracts.JobPositionDao;
import com.project.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager (JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao= jobPositionDao;
	}
	
	@Override
	public DataResult<List<JobPosition>> getAll () {
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(), "İş pozisyonları listelendi");
	}
	
	@Override
	public Result add (JobPosition jobPosition) throws Exception{
		
		Result name = JobPositionValidator.valid(jobPosition.getJobPositionName());
		Result nameCheck = valid(jobPosition.getJobPositionName());
		
		if (!name.isSuccess()) return new ErrorResult(name.getMessage());
		if (!nameCheck.isSuccess()) return new ErrorResult(nameCheck.getMessage());
		
		
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("İş pozisyonu eklendi");
		
	}
	
	  public Result valid (String name) { 
		  JobPosition findByJobPositionName = this.jobPositionDao.findByJobPositionName(name);
	  
		  if (findByJobPositionName == null) {
			  return new SuccessResult();
		  } 
		  return new ErrorResult("İş posizyonu sistemde kayıtlı!");
	  }
	 
	
	
}
