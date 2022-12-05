package com.project.hrms.dataAccess.abstracts;

import org.springframework.data.repository.CrudRepository;

import com.project.hrms.entities.concretes.JobSeeker;

public interface JobSeekerCrudDao extends CrudRepository<JobSeeker, Integer>{

	
	
}
