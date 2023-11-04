package com.project.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrms.business.abstracts.JobAdvertisementService;
import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.entities.concretes.JobAdvertisement;
import com.project.hrms.entities.dtos.JobAdvertisementWithEmployerDto;

import com.project.hrms.core.utilities.results.ErrorDataResult;

@CrossOrigin
@RestController
@RequestMapping("/api/jobAdvertisement")
public class JobAdvertisementController {

	JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService= jobAdvertisementService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>>getAll(){
		return jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisement jobAdvertisement) {
		return ResponseEntity.ok(jobAdvertisementService.add(jobAdvertisement));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		
		Map<String, String> validationErrors= new HashMap<String, String>();
		
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları");
		return errors;
	}
	
	@GetMapping("/getByAllWithDto")
	public DataResult<List<JobAdvertisementWithEmployerDto>> getAllDto(){
		return jobAdvertisementService.getAllDto();
	}
	
	@GetMapping("/getByCompanyName")
	public DataResult<List<JobAdvertisementWithEmployerDto>> getByEmployer_CompanyNameAndIsActiveTrue(String companyName){
		return this.jobAdvertisementService.getByEmployer_CompanyNameAndIsActiveTrue(companyName);
	}
	
	@GetMapping("/getByJobAdvertisement_JobAdvertisementId")
	public DataResult<JobAdvertisementWithEmployerDto> getByJobAdvertisement_JobAdvertisementId(int  jobAdvertisementId){
		return this.jobAdvertisementService.getByJobAdvertisement_JobAdvertisementId(jobAdvertisementId);
	}
	
	@GetMapping("/getByJobAdvertisementName")
	public DataResult<List<JobAdvertisement>> getByJobAdvertisementName(String jobAdvertisementName){
		return this.jobAdvertisementService.getByJobAdvertisementName(jobAdvertisementName);
	} 
	
	@GetMapping("/getByWebSite")
	public DataResult<List<JobAdvertisementWithEmployerDto>> getByWebsite(String webSite){
		return this.jobAdvertisementService.getByWebsite(webSite);
	}
	
	@GetMapping("/findByIsActiveAndOrderByDeadline")    
	public DataResult<List<JobAdvertisementWithEmployerDto>> findByIsActiveAndOrderByDeadline(boolean isActive){
		return jobAdvertisementService.findByIsActiveAndOrderByDeadline(isActive);
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
