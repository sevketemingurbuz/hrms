package com.project.hrms.business.concretes.cv;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.hrms.business.abstracts.cv.ImageService;
import com.project.hrms.core.cloud.CloudAdapterService;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.core.utilities.results.SuccessResult;
import com.project.hrms.dataAccess.abstracts.cv.ImageDao;
import com.project.hrms.entities.concretes.cv.Image;

@Service
public class ImageManager implements ImageService{

	ImageDao imageDao;
	CloudAdapterService cloudService;
	
	public ImageManager(ImageDao imageDao, CloudAdapterService cloudService) {
		this.imageDao= imageDao;
		this.cloudService= cloudService;
	}
	
	public Result add(Image image, MultipartFile multipartFile) {
		
		var result = this.cloudService.uploadPhoto(multipartFile).getData();
		
		image.setUrlOfImage(result.get("url"));
		
		this.imageDao.save(image);
		return new SuccessResult("Fotoğraf yüklendi");
	}
	
	
	
	
}
