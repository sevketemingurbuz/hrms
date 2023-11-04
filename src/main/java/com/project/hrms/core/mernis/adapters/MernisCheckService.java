package com.project.hrms.core.mernis.adapters;

import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.entities.concretes.JobSeeker;

public interface MernisCheckService {
	
	public Result checkIfRealPerson (JobSeeker jobSeeker) throws Exception;

}
