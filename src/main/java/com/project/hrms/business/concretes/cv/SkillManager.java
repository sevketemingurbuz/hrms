package com.project.hrms.business.concretes.cv;

import org.springframework.stereotype.Service;

import com.project.hrms.business.abstracts.cv.SkillService;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessResult;
import com.project.hrms.dataAccess.abstracts.cv.SkillDao;
import com.project.hrms.entities.concretes.cv.Skill;

@Service
public class SkillManager implements SkillService{

	SkillDao skillDao;
	
	public SkillManager(SkillDao skillDao) {
		this.skillDao= skillDao;
	}
	
	public Result add (Skill skill) {
		this.skillDao.save(skill);
		return new SuccessResult("Yetenekler eklendi");
	}
	
	
}
