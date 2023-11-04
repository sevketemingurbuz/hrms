package com.project.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.hrms.entities.concretes.cv.Cv;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_seekers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class JobSeeker extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name= "name", nullable = false)
	private String name;
	
	@Column(name= "last_name", nullable = false)
	private String lastName;
	
	@Column(name= "date_of_year", nullable = false)
	private String dateOfYear;
	
	@Column(name= "identification", nullable = false)
	private String identification;		
	
	@OneToOne(mappedBy = "jobSeeker")
	private Cv cv;
	
	
}
