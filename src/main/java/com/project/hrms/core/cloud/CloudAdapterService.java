package com.project.hrms.core.cloud;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.project.hrms.core.utilities.results.DataResult;

public interface CloudAdapterService {

	DataResult<Map<String, String>> uploadPhoto(MultipartFile multipartFile);
	
}
