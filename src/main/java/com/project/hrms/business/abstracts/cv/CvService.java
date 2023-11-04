package com.project.hrms.business.abstracts.cv;

import java.util.List;

import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.entities.concretes.cv.Cv;

public interface CvService {
	
	Result add(Cv cv);
	DataResult<List<Cv>> getAll();
	DataResult<List<Cv>> getById(int id);
	public DataResult<List<Cv>> getByJobSeeker_Name(String name);
	

}
