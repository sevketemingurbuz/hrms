package com.project.hrms.business.abstracts.cv;

import java.util.List;

import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.entities.concretes.cv.School;

public interface SchoolService {
	
	Result add(School school);
	DataResult<List<School>> getAll();
	DataResult<List<School>> getByCvId(int id);
	

}
