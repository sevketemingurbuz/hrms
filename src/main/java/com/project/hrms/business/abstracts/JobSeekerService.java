package com.project.hrms.business.abstracts;

import java.util.List;

import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {

	public DataResult<List<JobSeeker>> getAll();
	public DataResult<JobSeeker> getById(int id);
	public Result add(JobSeeker jobSeeker) throws Exception;
	public Result deleteById(int id);
	public Result updateAll(int id,  JobSeeker jobSeeker, String name, String identification);
	public DataResult<JobSeeker> getByJobSeekerName(String name);
	
}
