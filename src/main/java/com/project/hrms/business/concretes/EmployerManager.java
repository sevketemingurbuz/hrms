package com.project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hrms.business.abstracts.EmployerService;
import com.project.hrms.business.abstracts.UserService;
import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.ErrorResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessDataResult;
import com.project.hrms.core.utilities.results.SuccessResult;
import com.project.hrms.core.validations.CompanyNameValidator;
import com.project.hrms.core.validations.EmailPersonelCheckValidator;
import com.project.hrms.core.validations.EmailValidator;
import com.project.hrms.core.validations.TelNoValidator;
import com.project.hrms.core.validations.WebSiteValidator;
import com.project.hrms.dataAccess.abstracts.EmployerDao;
import com.project.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private UserService userService;

	@Autowired
	public EmployerManager (EmployerDao employerDao, UserService userService) {
		super();
		this.employerDao= employerDao;
		this.userService = userService;
	}
	
	public DataResult<List<Employer>> getAll(){
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "İşverenler listelendi");
	}
	
	@Override
	public Result add (Employer employer) {
		
		Result name = CompanyNameValidator.valid(employer.getCompanyName());
		Result webSite = WebSiteValidator.valid(employer.getWebSite());
		Result telNo = TelNoValidator.valid(employer.getTelNo());
		Result email = EmailValidator.valid(employer.getEmail());
		Result emailCheck = userService.checkIfEmailAlreadyExists(employer.getEmail());
		Result emailPersonelCheck = EmailPersonelCheckValidator.valid(employer.getEmail());
		
		if (!name.isSuccess()) return new ErrorResult(name.getMessage());
		if (!webSite.isSuccess()) return new ErrorResult(webSite.getMessage());
		if (!telNo.isSuccess()) return new ErrorResult(telNo.getMessage());
		if (!email.isSuccess()) return new ErrorResult(email.getMessage());
		if (!emailCheck.isSuccess()) return new ErrorResult(emailCheck.getMessage());
		if (!emailPersonelCheck.isSuccess()) return new ErrorResult("Personel onayından geçemedi");
		
		employerDao.save(employer);
		return new SuccessResult("İş veren eklendi");
	}
 
	
}
