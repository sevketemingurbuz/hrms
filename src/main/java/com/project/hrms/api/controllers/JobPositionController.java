package com.project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrms.business.abstracts.JobPositionService;
import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.entities.concretes.JobPosition;

@CrossOrigin
@RestController
@RequestMapping("/api/jopPosition")
public class JobPositionController {

	private JobPositionService jobPositionService;
	
	@Autowired
	public JobPositionController (JobPositionService jobPositionService){
		super();
		this.jobPositionService= jobPositionService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobPosition>> getAll (){
		return this.jobPositionService.getAll();
	}
	
	@PostMapping("/add")
	public Result add (@RequestBody JobPosition jobPosition) throws Exception {
		return this.jobPositionService.add(jobPosition);
	}
	
	
}
