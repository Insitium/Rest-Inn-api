package com.example.restinProject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.restinProject.resortinservice.UserService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserService userService;
	
	@Override
	//allowing authentication
	protected void configure(AuthenticationManagerBuilder authent) throws Exception{
		authent.userDetailsService(userService);
	}
	
	@Override
	//configuration authentication
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests().antMatchers("/users/**").permitAll().antMatchers("/auth").permitAll().antMatchers("/properties/**").permitAll()
        .anyRequest().authenticated();
	}
	
	@Bean
	public AuthenticationManager authenticationManager() throws Exception{
		return super.authenticationManager();
	}
}
