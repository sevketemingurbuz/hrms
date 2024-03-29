package com.project.hrms.entities.dtos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	private String webSite;
	private int jobAdvertisementId;
	private String jobAdvertisementName;
	//private String jobDefinition;
	private int openPosition;
	//private int minSalary;
	//private int maxSalary;
	
	public String getReleaseDateTime( ) {
		return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(releaseDateTime);
	}
	public String getDeadline( ) {
		if (deadline == null) {
	        return "Bilinmiyor";
	    }
		return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(deadline);
	}
	
	
	//private boolean isActive;	
	
	
	
	//@Nullable(message= "must be null")
	private LocalDateTime releaseDateTime = LocalDateTime.now();
	private LocalDateTime deadline;

	
}
