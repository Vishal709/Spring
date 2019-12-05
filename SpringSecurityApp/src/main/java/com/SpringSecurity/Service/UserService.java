package com.SpringSecurity.Service;

import org.springframework.stereotype.Service;

import com.SpringSecurity.Model.User;

@Service
public interface UserService{
	public User addUser(String username, String password);
}
