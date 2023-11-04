package com.project.hrms.entities.concretes.cv;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name= "job_experiences")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class JobExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "job_experience_id")
	private int jobExperienceId;
	
	@Column(name= "workplace_name")
	private String workplaceName;
	
	@Column(name= "job_position")
	private String jobPosition;
	
	@Column(name= "start_date")
	private LocalDate startDate;
	
	@Column(name= "end_date")
	private LocalDate endYear;
	
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name= "cv_id")
	private Cv cv;
	
	public String getEndYear() {
		if (this.endYear == null) {
			return "Devam ediyor...";
		}
		return this.endYear.toString();
	}
	
	
}
