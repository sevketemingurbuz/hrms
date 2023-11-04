package com.project.hrms.api.controllers.cv;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrms.business.abstracts.cv.CvService;
import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.entities.concretes.cv.Cv;

@CrossOrigin
@RestController
@RequestMapping("/api/cv")
public class CvController {
	
	CvService cvService;
	
	public CvController(CvService cvService) {
		this.cvService= cvService;
	}
	
	@PostMapping ("/add")
	public Result add (@RequestBody Cv cv) {
		return this.cvService.add(cv);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Cv>> getAll(){
		return this.cvService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<List<Cv>> getById(int id){
		return this.cvService.getById(id);
	}
	
	@GetMapping("/getByName")
	public DataResult<List<Cv>> getByJobSeeker_Name(String name){
		return this.cvService.getByJobSeeker_Name(name);
	}

}
