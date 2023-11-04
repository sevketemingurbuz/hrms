package com.project.hrms.api.controllers.cv;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.hrms.business.abstracts.cv.ImageService;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.entities.concretes.cv.Image;

@RestController
@RequestMapping("/api/image")
public class ImageController {
	
	ImageService imageService;
	
	public ImageController(ImageService imageService) {
		this.imageService= imageService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody Image image, MultipartFile multipartFile) {
		return this.imageService.add(image, multipartFile);
	}

}
