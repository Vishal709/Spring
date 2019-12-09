package com.SpringSecurity.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


//@Entity
public class UserRoleMapping {
	
	/*
	 * @Id
	 * 
	 * @GeneratedValue int id; int userId; int roleId;
	 * 
	 * public int getId() { return id; } public void setId(int id) { this.id = id; }
	 * public int getUserId() { return userId; } public void setUserId(int userId) {
	 * this.userId = userId; } public int getRoleId() { return roleId; } public void
	 * setRoleId(int roleId) { this.roleId = roleId;
	 * 
	 * }
	 */
	
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "userId",insertable = false, updatable = false) User user;
	 * 
	 * public User getUser() { return user; } public void setUser(User user) {
	 * this.user = user; } public Role getRole() { return role; } public void
	 * setRole(Role role) { this.role = role; }
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "roleId",insertable = false, updatable = false) Role role;
	 */
}
