package com.SpringSecurity.Controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class InitialPasswordGen {

	
	 public static void main(String[] args) { BCryptPasswordEncoder
	  encryptPassword=new BCryptPasswordEncoder();
	 
	 System.out.println(encryptPassword.encode("test")); }
	 
}
