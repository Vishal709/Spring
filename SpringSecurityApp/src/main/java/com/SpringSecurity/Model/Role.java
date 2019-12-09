package com.SpringSecurity.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Role {
	@Id
	@GeneratedValue
	int id;
	String role;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	/*
	 * @OneToMany(mappedBy="role") List<UserRoleMapping> userRoles;
	 * 
	 * public List<UserRoleMapping> getUserRoles() { return userRoles; } public void
	 * setUserRoles(List<UserRoleMapping> userRoles) { this.userRoles = userRoles; }
	 */
	@ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
    private List < User > users;

	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
