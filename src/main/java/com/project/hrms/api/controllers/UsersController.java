package com.project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.hrms.business.abstracts.UserService;
import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService= userService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<User>> getall(){
		return userService.getAll();
	}
	
	
}
