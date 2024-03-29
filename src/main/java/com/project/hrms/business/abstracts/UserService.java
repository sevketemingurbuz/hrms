package com.project.hrms.business.abstracts;

import java.util.List;

import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.entities.concretes.User;

public interface UserService {

	DataResult<List<User>> getAll();
	Result checkIfEmailAlreadyExists (String email);
	
}
