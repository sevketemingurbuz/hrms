package com.project.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.project.hrms.entities.concretes.JobAdvertisement;
import com.project.hrms.entities.dtos.JobAdvertisementWithEmployerDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	public final String queryString = "Select new com.project.hrms.entities.dtos.JobAdvertisementWithEmployerDto("
			+ "e.companyName, e.webSite, j.jobAdvertisementId, j.jobAdvertisementName, j.openPosition, j.releaseDateTime, j.deadline) "
			+ "From Employer e Inner Join e.jobAdvertisement j";

	@Query(queryString)
	List<JobAdvertisementWithEmployerDto> getAllWithDto();

	@Query(queryString + " where j.isActive=:isActive")
	List<JobAdvertisementWithEmployerDto> findByIsActiveAndOrderByDeadline(Sort sort, boolean isActive);
	
	@Query(queryString + " WHERE j.isActive = true AND e.companyName LIKE %:companyName%")
	List<JobAdvertisementWithEmployerDto> getByEmployer_CompanyNameAndIsActiveTrue(String companyName);
	
	@Query(queryString + " where j.jobAdvertisementId=:jobAdvertisementId")
	JobAdvertisementWithEmployerDto getByJobAdvertisement_JobAdvertisementId(int jobAdvertisementId);
	
	List<JobAdvertisement>  getByJobAdvertisementName(String jobAdvertisementName);
	
	@Query(queryString + " where e.webSite=:webSite")
	List<JobAdvertisementWithEmployerDto> getByEmployer_WebSite(String webSite);
	
	
	@Transactional
	@Modifying
	@Query("Update JobAdvertisement set isActive=:isActive where jobAdvertisementName=:jobAdvertisementName")
	void updateIsActiveByJobAdvertisementName(boolean isActive,String jobAdvertisementName);
	
}
