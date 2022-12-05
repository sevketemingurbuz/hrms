package com.project.hrms.business.abstracts;

import java.util.List;

import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.entities.concretes.JobPosition;

public interface JobPositionService {

	public DataResult<List<JobPosition>> getAll (); 
	public Result add (JobPosition jobPosition) throws Exception;
}
