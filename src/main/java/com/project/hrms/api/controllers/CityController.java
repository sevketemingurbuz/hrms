package com.project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrms.business.abstracts.CityService;
import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.entities.concretes.City;

@CrossOrigin
@RestController
@RequestMapping("/api/city")
public class CityController {

	CityService cityService;
	
	@Autowired
	public CityController(CityService cityService) {
		this.cityService= cityService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<City>> getAll(){
		return this.cityService.getAll();
	}
	
}
