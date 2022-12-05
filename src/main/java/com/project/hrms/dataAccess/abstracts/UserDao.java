package com.project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByEmail (String email);
	
}
