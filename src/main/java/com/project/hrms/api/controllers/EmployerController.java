package com.project.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrms.business.abstracts.EmployerService;
import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employer")
public class EmployerController {

	private EmployerService employerService;
	
	public EmployerController (EmployerService employerService){
		super();
		this.employerService= employerService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<Employer>> getAll(){
		return employerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add (@RequestBody Employer employer) {
		return employerService.add(employer);
	}
	
}
