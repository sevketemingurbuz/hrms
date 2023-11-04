package com.project.hrms.entities.concretes.cv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name= "schools")
@AllArgsConstructor
@NoArgsConstructor

public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "school_id")
	private int schoolId;
	
	@Column(name= "school_name")
	private String schoolName;
	
	@Column(name= "education_degree")
	private String educationDegree;
	
	@Column(name= "department")
	private String department;
	
	@Column(name= "start_year")
	private int startYear;
	
	@Column(name= "end_year")
	private Integer endYear;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name= "cv_id")
	private Cv cv;
	
	public String getEndYear() {
		if (this.endYear == null) {
			return "Devam ediyor";
		}
		return this.endYear.toString();
	}
	
	
}
