package com.SpringSecurity.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class User {
//$2a$10$JFZ1nW6GaciRRA5c.d94K.kPqsoBrR5.CN3CVG1UECfcIolMjveGO
	@Id
	@GeneratedValue
	private int id;
	private String username;
	// private String  address;
	private String contactNo;
	private String gender;
	private String password;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@ManyToMany(cascade=CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(
       name="user_role_mapping",
       joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
       inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")})
    private List<Role> roles;
	/*
	 * @OneToMany(mappedBy="user") List<UserRoleMapping> userRoles;
	 * 
	 * 
	 * public List<UserRoleMapping> getUserRoles() { return userRoles; } public void
	 * setUserRoles(List<UserRoleMapping> userRoles) { this.userRoles = userRoles; }
	 */


	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
