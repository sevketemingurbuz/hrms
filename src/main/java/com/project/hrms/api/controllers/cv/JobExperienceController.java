package com.project.hrms.api.controllers.cv;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrms.business.abstracts.cv.JobExperienceService;
import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.entities.concretes.cv.JobExperience;

@RestController
@RequestMapping("api/jobExperience")
public class JobExperienceController {

	JobExperienceService jobExperienceService;
	
	public JobExperienceController(JobExperienceService jobExperienceService) {
		this.jobExperienceService= jobExperienceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobExperience jobExperience) {
		return this.jobExperienceService.add(jobExperience);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobExperience>> getAll(){
		return this.jobExperienceService.getAll();
	}
	
	@GetMapping("/getByCvId")
	public DataResult<List<JobExperience>> getByCvId(int id){
		return this.jobExperienceService.getByCvId(id);
	}
	
	
}
