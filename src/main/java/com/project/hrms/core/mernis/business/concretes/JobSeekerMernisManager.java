package com.project.hrms.core.mernis.business.concretes;

import com.project.hrms.core.mernis.business.abstracts.JobSeekerMernisService;
import com.project.hrms.dataAccess.abstracts.JobSeekerDao;
import com.project.hrms.entities.concretes.JobSeeker;

public class JobSeekerMernisManager implements JobSeekerMernisService{
	
	JobSeekerDao jobSeekerDao;

	
	public JobSeekerMernisManager(JobSeekerDao jobSeekerDao) {
		this.jobSeekerDao= jobSeekerDao;
	}
	
	@Override
	public void save(JobSeeker jobSeeker) {
	
		
		
		}
	

}
