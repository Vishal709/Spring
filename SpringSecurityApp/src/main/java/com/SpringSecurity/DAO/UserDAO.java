package com.SpringSecurity.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringSecurity.Model.User;

public interface UserDAO extends JpaRepository<User, Integer> {
	User findUserByUsername(String username);
}
