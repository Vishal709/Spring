package com.SpringSecurity.Service;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SpringSecurity.DAO.UserDAO;
import com.SpringSecurity.Model.User;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserDAO userDAO;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userObj=userDAO.findUserByUsername(username);
		if(userObj == null) {
			throw new UsernameNotFoundException("User name "+username+"not found in database"); 		
		}
		UserDetails userdetails=new org.springframework.security.core.userdetails.User(userObj.getUsername(),userObj.getPassword(), getAuthorities(userObj));
		return userdetails;
	}
	private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
       String[] userRoles = user.getRoles().stream().map((role) -> role.getRole()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }

}
