package com.project.hrms.api.controllers.cv;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrms.business.abstracts.cv.SchoolService;
import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.entities.concretes.cv.School;

@CrossOrigin
@RestController
@RequestMapping("/api/school")
public class SchoolController {
	
    SchoolService schoolService;
	
	public SchoolController(SchoolService schoolService) {
		this.schoolService=schoolService;
	}
	
	@PostMapping ("/add")
	public Result add (@RequestBody School school) {
		return this.schoolService.add(school);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<School>> getAll(){
		return this.schoolService.getAll();
	}
	
	@GetMapping("/getByCvId")
	public DataResult<List<School>> getByCvId(int id){
		return this.schoolService.getByCvId(id);
	}
	

}
