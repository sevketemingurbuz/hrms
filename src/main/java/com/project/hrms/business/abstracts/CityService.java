package com.project.hrms.business.abstracts;

import java.util.List;

import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.entities.concretes.City;

public interface CityService {
	
	DataResult<List<City>> getAll();

}
