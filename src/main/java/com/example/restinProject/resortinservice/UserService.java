package com.example.restinProject.resortinservice;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.restinProject.entity.Users;
import com.example.restinProject.repository.UserDao;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Users addUsers(Users user) {
		String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		
		return userDao.insert(user);
	}
	public Users getUser(String userId) {
		Optional<Users> user = userDao.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}else {
			return null;
		}
	}
	
	public List<Users> getUsers(){
		return userDao.findAll();
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user = userDao.findByUserName(username);
		String name = user.getUserName();
		String password = user.getPassword();
		
		return new User(name, password, new ArrayList<>());
	
	}
		
}
