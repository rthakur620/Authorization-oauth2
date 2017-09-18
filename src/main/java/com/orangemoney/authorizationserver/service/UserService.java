package com.orangemoney.authorizationserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.orangemoney.authorizationserver.dao.UserRepository;
import com.orangemoney.authorizationserver.model.User;

@Service("userDetailService")
public class UserService implements UserDetailsService{

	@Autowired
	User user;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		/*User user = new User();
		user.setUserName("Rahul");
		user.setPassword("1234");*/
		
		Iterable<User> listOfUsers = userRepository.findAll();
		User user = userRepository.findOne(userName);
		System.out.println("Username: "+user.getUsername()+", Password: "+user.getPassword());
		return user;
	}
}
