package com.user.login.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Login {
	
	@Id
	@GeneratedValue
	private Long id;
	private String email;
	private String password;
	
	

}
