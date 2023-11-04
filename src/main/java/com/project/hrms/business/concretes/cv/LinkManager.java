package com.project.hrms.business.concretes.cv;

import org.springframework.stereotype.Service;

import com.project.hrms.business.abstracts.cv.LinkService;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessResult;
import com.project.hrms.dataAccess.abstracts.cv.LinkDao;
import com.project.hrms.entities.concretes.cv.Link;

@Service
public class LinkManager implements LinkService{
	
	LinkDao linkDao;
	
	public LinkManager(LinkDao linkDao) {
		this.linkDao= linkDao;
	}
	
	public Result add (Link link) {
		this.linkDao.save(link);
		return new SuccessResult("Link eklendi");
	}

}
