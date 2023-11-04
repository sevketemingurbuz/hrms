package com.project.hrms.dataAccess.abstracts.cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hrms.entities.concretes.cv.Cv;

public interface CvDao extends JpaRepository<Cv	, Integer>{
	
	List<Cv> getById(int id);
	
	List<Cv> getByJobSeeker_Name(String name);

}
