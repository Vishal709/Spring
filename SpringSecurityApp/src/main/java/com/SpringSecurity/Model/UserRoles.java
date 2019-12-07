package com.SpringSecurity.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserRoles {
	@Id
	@GeneratedValue
	int id;
	String role;
	
}
