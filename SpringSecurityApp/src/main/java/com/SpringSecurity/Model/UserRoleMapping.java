package com.SpringSecurity.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserRoleMapping {
	
	@Id
	@GeneratedValue
	int id;
	int userId;
	int roleId;
}
