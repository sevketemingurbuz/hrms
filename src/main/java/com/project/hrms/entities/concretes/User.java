package com.project.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue
	@Column(name= "id")
	private int id;
	
	@Column(name= "log_id")
	private int log_id;
	
	@Column(name= "email")
	private String email;
	
	@Column(name= "password")
	private String password;
	
	@Column(name= "retry_password")
	private  String retry_password;

	public User() {}
	
	public User(int id, int log_id, String email, String password, String retry_password) {
		super();
		this.id = id;
		this.log_id = log_id;
		this.email = email;
		this.password = password;
		this.retry_password = retry_password;
	}
	
}
