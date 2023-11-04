package com.project.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrms.business.abstracts.JobSeekerService;
import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.ErrorDataResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.entities.concretes.JobSeeker;

@CrossOrigin
@RestController
@RequestMapping("/api/jobSeeker")
public class JobSeekerController {

	private JobSeekerService jobSeekerService;
	
	JobSeekerController(JobSeekerService jobSeekerService){
		super();
		this.jobSeekerService= jobSeekerService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobSeeker>> getAll(){
		try {
			return jobSeekerService.getAll();
		}catch (Exception e) {
			return new ErrorDataResult<List<JobSeeker>>();
		}
	
	}
	
	@GetMapping("/getById")
	public DataResult<JobSeeker> getById(int id) {
		return this.jobSeekerService.getById(id);
	}
	
	@GetMapping("/getByName")
	public DataResult<JobSeeker> getByJobSeekerName(String name){
		return this.jobSeekerService.getByJobSeekerName(name);
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobSeeker jobSeeker) throws Exception{
		return this.jobSeekerService.add(jobSeeker);
	}
	
	@DeleteMapping("/delete")
	public Result deleteById(int id) {
		return jobSeekerService.deleteById(id);
	}
	
	@PostMapping("/update")
	public Result updateAll(int id, String email, String password, @RequestBody JobSeeker jobSeeker) {
		return this.jobSeekerService.updateAll(id, email, password, jobSeeker);
	}

	
}
