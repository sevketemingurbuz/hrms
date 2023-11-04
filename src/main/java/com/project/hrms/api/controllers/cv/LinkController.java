package com.project.hrms.api.controllers.cv;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrms.business.abstracts.cv.LinkService;
import com.project.hrms.core.utilities.results.Result;
import com.project.hrms.entities.concretes.cv.Link;

@RestController
@RequestMapping("/api/link")
public class LinkController {
	
	LinkService linkService;
	
	public LinkController(LinkService linkService) {
		this.linkService= linkService;
	}
	
	@PostMapping("/add")
	public Result add (@RequestBody Link link) {
		return this.linkService.add(link);
	}

}
