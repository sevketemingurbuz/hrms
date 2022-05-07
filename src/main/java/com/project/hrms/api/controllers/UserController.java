package com.project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.hrms.business.abstracts.UserService;
import com.project.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api")
public class UserController {

	UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService= userService;
	}
	@GetMapping("/users")
	public List<User>getall(){
		return userService.user();
	}
	
	
}
