package com.project.hrms.entities.concretes.cv;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.hrms.entities.concretes.JobSeeker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name= "cvs")
@AllArgsConstructor
@NoArgsConstructor

public class Cv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "cv_id")
	private int cvId;

	@JsonManagedReference
	@OneToMany(mappedBy = "cv")
	private List<School> schools;

	@OneToMany(mappedBy = "cv")
	@JsonManagedReference
	private List<JobExperience> jobExperiences;

	@OneToMany(mappedBy = "cv")
	@JsonManagedReference
	private List<Language> languages;

	@JsonManagedReference
	@OneToOne(mappedBy = "cv")
	private Image images;

	@JsonManagedReference
	@OneToOne(mappedBy = "cv")
	private Link links;

	@JsonManagedReference
	@OneToOne(mappedBy = "cv")
	private Skill skills;
	
	@OneToOne
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;
	
	
}
