package com.project.hrms.dataAccess.abstracts.cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hrms.entities.concretes.cv.School;

public interface SchoolDao extends JpaRepository<School	, Integer>{
	
	
	List<School> getByCv_CvIdOrderByEndYearDesc(int id) ;
	

}
