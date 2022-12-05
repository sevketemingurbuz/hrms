package com.project.hrms.entities.concretes;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name= "job_advertisements")
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisement {

	@Id
	@GeneratedValue
	@Column(name= "job_advertisement_id")
	private int jobAdvertisementId;
	
	@Column(name= "job_advertisement_name")
	private String jobAdvertisementName;
	
	@Column(name= "job_definition")
	private String jobDefinition;
	
	@Column(name= "min_salary")
	private int minSalary;
	
	@Column(name= "max_salary")
	private int maxSalary;
	
	@Column(name= "open_position")
	private int openPosition;
	
	@Column(name= "deadline")
	private Date deadline;
	
	@Column(name= "release_date_time")
	private LocalDateTime releaseDateTime = LocalDateTime.now();
	
	@Column(name= "is_active")
	private boolean isActive;
	
	@ManyToOne
	@JoinColumn(name= "job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne
	@JoinColumn(name= "employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name= "city_id")
	private City city;
	
}
