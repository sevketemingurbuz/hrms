package com.project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hrms.business.abstracts.UserService;
import com.project.hrms.dataAccess.concretes.UserDao;
import com.project.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{
	
	UserDao userDao;;
	
	@Autowired
	public UserManager (UserDao userDao) {
		this.userDao= userDao;
	}

	@Override
	public List<User> user() {
		return userDao.findAll();	}

}
