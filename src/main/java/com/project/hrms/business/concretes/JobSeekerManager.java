package com.project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hrms.business.abstracts.JobSeekerService;
import com.project.hrms.business.abstracts.UserService;
import com.project.hrms.core.mernis.business.abstracts.JobSeekersFakeService;
import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.ErrorResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessDataResult;
import com.project.hrms.core.utilities.results.SuccessResult;
import com.project.hrms.core.validations.DateOfYearValidator;
import com.project.hrms.core.validations.IdentificationValidator;
import com.project.hrms.core.validations.LastNameValidator;
import com.project.hrms.core.validations.EmailValidator;
import com.project.hrms.core.validations.NameValidator;
import com.project.hrms.core.validations.PasswordValidator;
import com.project.hrms.core.validations.RetryPasswordValidator;
import com.project.hrms.dataAccess.abstracts.JobSeekerDao;
import com.project.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;
	private JobSeekersFakeService jobSeekersFakeService;
	private UserService userService;
	//private UserCheckService userCheckService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, JobSeekersFakeService jobSeekersFakeService, UserService userService) {
		super();
		this.jobSeekerDao= jobSeekerDao; 
		this.jobSeekersFakeService= jobSeekersFakeService;
		this.userService= userService;
		//this.userCheckService= userCheckService;
	}
	
	@Override
	public DataResult<List<JobSeeker>> getAll(){
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll(), "İş arayanlar listelendi");
	}
	
	@Override
	public DataResult<JobSeeker> getById(int id) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getById(id), "İş arayan eklendi");
	}
	
	public DataResult<JobSeeker> getByJobSeekerName(String name){
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getByName(name));
	}
	
	
	@Override
	public Result add(JobSeeker jobSeeker) throws Exception {
		/*
		 * if (!userCheckService.checkIfRealPerson(jobSeeker).isSuccess()) { return new
		 * ErrorResult("Böyle bir kişi yaşamıyor"); }
		 */
		/*
		 * Result mernisCheck = userCheckService.checkIfRealPerson(jobSeeker); if
		 * (!mernisCheck.isSuccess()) return new ErrorResult(mernisCheck.getMessage());
		 */
		
		Result name = NameValidator.valid(jobSeeker.getName());
		Result lastName = LastNameValidator.valid(jobSeeker.getLastName());
		Result identification = IdentificationValidator.valid(jobSeeker.getIdentification());
		Result date = DateOfYearValidator.valid(jobSeeker.getDateOfYear());
		Result mail = EmailValidator.valid(jobSeeker.getEmail());	
		Result password = PasswordValidator.valid(jobSeeker.getPassword());
		Result retryPassword = RetryPasswordValidator.valid(jobSeeker.getRetry_password());
		Result emailCheck = userService.checkIfEmailAlreadyExists(jobSeeker.getEmail());
		Result identificationCheck = checkIfIdentificationAlreadyExists(jobSeeker.getIdentification());
		
		if (!name.isSuccess()) return new ErrorResult(name.getMessage());
		if (!lastName.isSuccess()) return new ErrorResult(lastName.getMessage());
		if (!identification.isSuccess()) return new ErrorResult(identification.getMessage());
		if (!date.isSuccess()) return new ErrorResult(date.getMessage());
		if (!mail.isSuccess()) return new ErrorResult(mail.getMessage());
		if (!password.isSuccess()) return new ErrorResult(password.getMessage());
		if (!retryPassword.isSuccess()) return new ErrorResult(retryPassword.getMessage());
		if (!emailCheck.isSuccess()) return new ErrorResult(emailCheck.getMessage()); 
		if (!identificationCheck.isSuccess()) return new ErrorResult(identificationCheck.getMessage());
		if (!jobSeekersFakeService.verifyIdentification()) return new ErrorResult("Böyle bir kişi yaşamıyor");

			this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("İş arayan eklendi");
		
	}
	
	public Result checkIfIdentificationAlreadyExists (String identification) {
		JobSeeker findByIdentification = jobSeekerDao.findByIdentification(identification);
		
		if (findByIdentification == null) {
			return new SuccessResult();
		}
		return new ErrorResult("Bu kimlikli bir kişi sistemde kayıtlı");
	}

	@Override
	public Result deleteById(int id) {
			this.jobSeekerDao.deleteById(id);
		return new SuccessResult("İş arayan silindi!");
	}
	
	public Result updateAll(int id, JobSeeker jobSeeker, String name, String identification) {

			jobSeeker = jobSeekerDao.getById(id);
			jobSeeker.setName(name);
			jobSeeker.setIdentification(identification);
			this.jobSeekerDao.save(jobSeeker);
		
		return new SuccessResult("İş arayan güncellendi");
	}
	
	/*
	 * public Result updateAll(int id, JobSeeker jobSeeker) { JobSeeker jobSeeker =
	 * jobSeekerDao.getById(id); jobSeeker. }
	 */
	
	
}