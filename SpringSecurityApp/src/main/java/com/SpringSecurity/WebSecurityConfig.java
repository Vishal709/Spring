package com.SpringSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoderMethod() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		 .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
		.antMatchers("/welcome").permitAll()
		.antMatchers("/errorPage").permitAll()
		.antMatchers("/addUser").permitAll()
		.antMatchers("/login").permitAll()
		.anyRequest().authenticated()
		.and()
		.csrf().disable()
		.formLogin().loginPage("/login")
		.loginProcessingUrl("/j_spring_security_check")
		.successHandler((req, res, auth) -> { // Success handler invoked after successful authentication
					res.sendRedirect("/welcome");
				})
		.failureHandler((req, res, auth) -> {
					res.sendRedirect("/errorPage");
				})
		.usernameParameter("name")//
		.passwordParameter("password");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		// authenticationManagerBuilder.inMemoryAuthentication().withUser("user").password("{noop}pass").roles("USER");
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoderMethod());
	}
}
