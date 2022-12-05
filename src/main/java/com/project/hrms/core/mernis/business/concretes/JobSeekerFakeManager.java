package com.project.hrms.core.mernis.business.concretes;

import org.springframework.stereotype.Service;

import com.project.hrms.core.mernis.business.abstracts.JobSeekersFakeService;

@Service
public class JobSeekerFakeManager implements JobSeekersFakeService{

	public boolean verifyIdentification () {
		return true;
	}
	
	
}
