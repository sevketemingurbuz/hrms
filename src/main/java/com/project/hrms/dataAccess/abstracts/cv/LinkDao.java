package com.project.hrms.dataAccess.abstracts.cv;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hrms.entities.concretes.cv.Link;

public interface LinkDao extends JpaRepository<Link, Integer>{
	
	

}
