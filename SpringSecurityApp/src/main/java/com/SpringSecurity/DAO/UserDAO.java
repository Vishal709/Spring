package com.SpringSecurity.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringSecurity.Model.User;

public interface UserDAO extends JpaRepository<User, Integer> {
	User findUserByUsername(String username);

	List<User> findAll();
	
	void deleteById(int id);
}
