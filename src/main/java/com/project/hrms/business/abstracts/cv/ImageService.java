package com.project.hrms.business.abstracts.cv;

import org.springframework.web.multipart.MultipartFile;

import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.entities.concretes.cv.Image;

public interface ImageService {
	
	Result add(Image image, MultipartFile multipartFile);

}
