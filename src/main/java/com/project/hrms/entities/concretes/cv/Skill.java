package com.project.hrms.entities.concretes.cv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name= "skills")
@AllArgsConstructor
@NoArgsConstructor
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "skill_id")
	private int skillId;

	@Column(name= "known_technologies")
	private String knownTechnologies;
	
	@Column(name= "cover_letter")
	private String coverLetter;
	
	@OneToOne
	@JsonBackReference
	@JoinColumn(name= "cv_id")
	private Cv cv;
	

}
