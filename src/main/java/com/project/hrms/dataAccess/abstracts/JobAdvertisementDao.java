package com.project.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.project.hrms.entities.concretes.JobAdvertisement;
import com.project.hrms.entities.dtos.JobAdvertisementWithEmployerDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	public final String queryString = "Select new com.project.hrms.entities.dtos.JobAdvertisementWithEmployerDto("
			+ "e.companyName, j.jobAdvertisementName, j.openPosition, j.releaseDateTime, j.deadline) "
			+ "From Employer e Inner Join e.jobAdvertisement j";

	@Query(queryString)
	List<JobAdvertisementWithEmployerDto> getAllDto();

	@Query(queryString)
	List<JobAdvertisementWithEmployerDto> findByOrderByJobAdvertisementNameDesc(); //Çalışmıyor
	
	@Query(queryString)
	List<JobAdvertisementWithEmployerDto> getByEmployer_CompanyNameAndIsActiveTrue(String companyName);
	
	
	
	@Transactional
	@Modifying
	@Query("Update JobAdvertisement set isActive=:isActive where jobAdvertisementName=:jobAdvertisementName")
	void updateIsActiveByJobAdvertisementName(
													/* @Param("isActive") */ 
			boolean isActive,			 /* @Param("jobAdvertisementId") */ 
			String jobAdvertisementName);
	
}
