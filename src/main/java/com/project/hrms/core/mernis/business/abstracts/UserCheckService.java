package com.project.hrms.core.mernis.business.abstracts;

import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.entities.concretes.JobSeeker;

public interface UserCheckService {

	public Result checkIfRealPerson (JobSeeker jobSeeker) throws Exception;
}
