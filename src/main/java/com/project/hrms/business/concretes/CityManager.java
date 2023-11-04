package com.project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hrms.business.abstracts.CityService;
import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.SuccessDataResult;
import com.project.hrms.dataAccess.abstracts.CityDao;
import com.project.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{
	
	CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		this.cityDao= cityDao;
	}
	
	@Override
	public DataResult<List<City>> getAll(){
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(), "Şehir listesi getirildi");
	}

}
