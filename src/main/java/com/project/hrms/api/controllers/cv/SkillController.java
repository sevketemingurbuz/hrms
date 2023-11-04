package com.project.hrms.api.controllers.cv;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrms.business.abstracts.cv.SkillService;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.entities.concretes.cv.Skill;

@RestController
@RequestMapping("api/skill")
public class SkillController {
	
	SkillService skillService;
	
	public SkillController(SkillService skillService) {
		this.skillService= skillService;
	}
	
	@PostMapping("/add")
	public Result add (@RequestBody Skill skill) {
		return this.skillService.add(skill);
	}
	

}
