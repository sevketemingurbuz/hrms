package com.project.hrms.business.abstracts;

import java.util.List;

import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.entities.concretes.JobAdvertisement;
import com.project.hrms.entities.dtos.JobAdvertisementWithEmployerDto;

public interface JobAdvertisementService {

	public DataResult<List<JobAdvertisement>>  getAll();
	public Result add(JobAdvertisement jobAdvertisement);
	public DataResult<List<JobAdvertisementWithEmployerDto>> getAllDto();
	public DataResult<List<JobAdvertisementWithEmployerDto>> getByEmployer_CompanyNameAndIsActiveTrue(String companName);
	public DataResult<List<JobAdvertisement>> getAllSorted();
	public DataResult<List<JobAdvertisementWithEmployerDto>> findByOrderByJobAdvertisementNameDesc();
	public Result updateIsActiveByJobAdventisementName (boolean isActive, String jobAdventisementName);
	
}
