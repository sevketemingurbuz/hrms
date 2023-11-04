package com.project.hrms.dataAccess.abstracts.cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hrms.entities.concretes.cv.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer>{
	
	List<JobExperience> getByCv_CvIdOrderByEndYearDesc(int id);
	

}
