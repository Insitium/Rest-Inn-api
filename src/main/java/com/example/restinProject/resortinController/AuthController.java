package com.example.restinProject.resortinController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restinProject.entity.Users;

@RestController
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/auth")
	public ResponseEntity login(@RequestBody Users users) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUserName(), users.getPassword()));
			return new ResponseEntity("Login Successfull", HttpStatus.OK);
			
		}catch(BadCredentialsException badCredentialsException) {
			return new ResponseEntity("Please try again: Username or password is incorrect",HttpStatus.NOT_FOUND);
		}
	}
}
