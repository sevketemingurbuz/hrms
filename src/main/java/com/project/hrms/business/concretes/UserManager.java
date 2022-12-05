package com.project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hrms.business.abstracts.UserService;
import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.ErrorResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessDataResult;
import com.project.hrms.core.utilities.results.SuccessResult;
import com.project.hrms.dataAccess.abstracts.UserDao;
import com.project.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{
	
	private UserDao userDao;
	
	@Autowired
	public UserManager (UserDao userDao) {
		super();
		this.userDao= userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Veri listelendi"); 
	}
	
	@Override
	public Result checkIfEmailAlreadyExists (String email) {
		User user = userDao.findByEmail(email);
		
		if (user == null) {
			return new SuccessResult();
		}
		return new ErrorResult("Bu email sistemde kayıtlı");
	}


}
