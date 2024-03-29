package com.project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.hrms.business.abstracts.JobAdvertisementService;
import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.ErrorResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessDataResult;
import com.project.hrms.core.utilities.results.SuccessResult;
import com.project.hrms.core.validations.DeadlineValidator;
import com.project.hrms.core.validations.JobAdvertisementNameValidator;
import com.project.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.project.hrms.entities.concretes.JobAdvertisement;
import com.project.hrms.entities.dtos.JobAdvertisementWithEmployerDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao= jobAdvertisementDao;
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getAll(){
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(), "İş ilanları başarıyla listelendi");
	}
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		
		Result name = JobAdvertisementNameValidator.valid(jobAdvertisement.getJobAdvertisementName());
		Result deadline = DeadlineValidator.valid(jobAdvertisement.getDeadline());
		
		if (!name.isSuccess()) return new ErrorResult(name.getMessage());
		if (!deadline.isSuccess()) return new ErrorResult(deadline.getMessage());
		
		
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı başarıyla eklendi");	
	}
	
	@Override
	public DataResult<List<JobAdvertisementWithEmployerDto>> getAllDto(){
			return new SuccessDataResult<List<JobAdvertisementWithEmployerDto>>(jobAdvertisementDao.getAllWithDto(), 
				"İş ilanları başarıyla listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisementWithEmployerDto>> getByEmployer_CompanyNameAndIsActiveTrue(String companyName) {
		return new SuccessDataResult<List<JobAdvertisementWithEmployerDto>> (
				this.jobAdvertisementDao.getByEmployer_CompanyNameAndIsActiveTrue(companyName), 
				companyName + " firmasına ait tüm iş ilanları başarıyla listelendi");
	}
	
	@Override
	public DataResult <JobAdvertisementWithEmployerDto> getByJobAdvertisement_JobAdvertisementId(int  jobAdvertisementId){
		return new SuccessDataResult <JobAdvertisementWithEmployerDto>(
				this.jobAdvertisementDao.getByJobAdvertisement_JobAdvertisementId(jobAdvertisementId),
				jobAdvertisementId + " id ye ait tüm iş ilanları başarıyla listelendi");
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getByJobAdvertisementName(String jobAdvertisementName){
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByJobAdvertisementName(jobAdvertisementName), "İş ilanları isme göre getirildi");
	}
	
	
	
	@Override
	public DataResult<List<JobAdvertisementWithEmployerDto>> getByWebsite(String webSite){
		return new SuccessDataResult<List<JobAdvertisementWithEmployerDto>>(
				this.jobAdvertisementDao.getByEmployer_WebSite(webSite),
				webSite + " sitesine ait tüm iş ilanları başarıyla listelendi");
	}
	
	@Override 
	public DataResult<List<JobAdvertisementWithEmployerDto>> findByIsActiveAndOrderByDeadline(boolean isActive) { 
		Sort sort = Sort.by(Sort.Direction.DESC, "j.deadline");
		return new SuccessDataResult<List<JobAdvertisementWithEmployerDto>> (
				this.jobAdvertisementDao.findByIsActiveAndOrderByDeadline(sort, isActive), "İş ilanları tarihe göre başarıyla listelendi");
	}

	@Override
	public Result updateIsActiveByJobAdventisementName(boolean isActive, String jobAdventisementName) {
		this.jobAdvertisementDao.updateIsActiveByJobAdvertisementName(isActive, jobAdventisementName);
		return new SuccessResult("Etkinlik durumu başarıyla değiştirildi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.ASC, "deadline");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort), "Ürünler tarihe göre listelendi");
	}


	
}
