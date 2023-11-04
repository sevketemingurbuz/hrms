package com.project.hrms.business.abstracts;

import java.util.List;

import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.entities.concretes.JobAdvertisement;
import com.project.hrms.entities.dtos.JobAdvertisementWithEmployerDto;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>>  getAll();
	Result add(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisementWithEmployerDto>> getAllDto();
	DataResult<List<JobAdvertisementWithEmployerDto>> getByEmployer_CompanyNameAndIsActiveTrue(String companName);
	DataResult<JobAdvertisementWithEmployerDto> getByJobAdvertisement_JobAdvertisementId(int  jobAdvertisementId);
	DataResult<List<JobAdvertisement>> getByJobAdvertisementName(String jobAdvertisementName);
	DataResult<List<JobAdvertisementWithEmployerDto>> getByWebsite(String website);
	DataResult<List<JobAdvertisement>> getAllSorted();
	DataResult<List<JobAdvertisementWithEmployerDto>> findByIsActiveAndOrderByDeadline(boolean isActive);
	Result updateIsActiveByJobAdventisementName (boolean isActive, String jobAdventisementName);
	
	
}
