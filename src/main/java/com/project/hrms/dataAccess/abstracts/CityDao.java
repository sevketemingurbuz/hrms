package com.project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{

}
