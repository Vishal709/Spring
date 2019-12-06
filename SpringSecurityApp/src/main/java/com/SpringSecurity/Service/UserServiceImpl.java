package com.SpringSecurity.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.SpringSecurity.DAO.UserDAO;
import com.SpringSecurity.Model.User;
@Service
public class UserServiceImpl implements UserService {
@Autowired
UserDAO userDAO;

	
	@Override
	public User addUser(String username, String password) {
		User user = new User();
		BCryptPasswordEncoder encryptPassword = new BCryptPasswordEncoder();
		user.setUsername(username);
		user.setPassword(encryptPassword.encode(password));
		return userDAO.save(user);
	}
	
}
