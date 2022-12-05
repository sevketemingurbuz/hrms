package com.project.hrms.entities.dtos;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementWithEmployerDto {

	/*
	 * private int jobAdvertisementId; private int JobPositionId; private int
	 * employerId; private int cityId;
	 */
	private String companyName;
	private String jobAdvertisementName;
	//private String jobDefinition;
	private int openPosition;
	//private int minSalary;
	//private int maxSalary;
	
	//private boolean isActive;
	
	
	
	//@Nullable(message= "must be null")
	private LocalDateTime releaseDateTime = LocalDateTime.now();
	private Date deadline;
	
	
}
