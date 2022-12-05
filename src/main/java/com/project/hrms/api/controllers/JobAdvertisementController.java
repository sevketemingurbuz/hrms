package com.project.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrms.business.abstracts.JobAdvertisementService;
import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.entities.concretes.JobAdvertisement;
import com.project.hrms.entities.dtos.JobAdvertisementWithEmployerDto;

@RestController
@RequestMapping("/api/jobAdvertisement")
public class JobAdvertisementController {

	JobAdvertisementService jobAdvertisementService;
	
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService= jobAdvertisementService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>>getAll(){
		return jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getAllDto")
	public DataResult<List<JobAdvertisementWithEmployerDto>> getAllDto(){
		return jobAdvertisementService.getAllDto();
	}
	
	@GetMapping("/getByCompanyName")
	public DataResult<List<JobAdvertisementWithEmployerDto>> getByEmployer_CompanyNameAndIsActiveTrue(String companyName){
		return this.jobAdvertisementService.getByEmployer_CompanyNameAndIsActiveTrue(companyName);
	}
	
	@GetMapping("/findByOrderByDeadlineDesc")      //Çalışmıyor
	public DataResult<List<JobAdvertisementWithEmployerDto>> findByOrderByDeadlineDesc(){
		return jobAdvertisementService.findByOrderByJobAdvertisementNameDesc();
	}
	
	@PostMapping("/updateIsActive")
	public Result updateIsActiveByJobAdventisementName(boolean isActive, String jobAdvertisementName) {
		return jobAdvertisementService.updateIsActiveByJobAdventisementName(isActive, jobAdvertisementName);
	}
	
	@GetMapping("/getAllSorted")
	public DataResult<List<JobAdvertisement>> getAllSorted() {
		return this.jobAdvertisementService.getAllSorted();
	}
	
}
