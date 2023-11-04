package com.project.hrms.business.concretes.cv;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.hrms.business.abstracts.cv.CvService;
import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessDataResult;
import com.project.hrms.core.utilities.results.SuccessResult;
import com.project.hrms.dataAccess.abstracts.cv.CvDao;
import com.project.hrms.entities.concretes.cv.Cv;

@Service
public class CvManager implements CvService{
	
	CvDao cvDao;

	public CvManager(CvDao cvDao) {
		this.cvDao= cvDao;
	}
	
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult("Özgeçmiş eklendi");
	}
	
	public DataResult<List<Cv>> getAll(){
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(), "Tüm özgeçmişler listelendi");
	}
	
	public DataResult<List<Cv>> getById(int id) {
		return new SuccessDataResult<List<Cv>>(this.cvDao.getById(id), id + " numaranın özgeçmiş bilgileri görüntülendi");
	}
	
	public DataResult<List<Cv>> getByJobSeeker_Name(String name){
		return new SuccessDataResult<List<Cv>>(this.cvDao.getByJobSeeker_Name(name));
	}

	
}
