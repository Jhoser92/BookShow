package com.jsBinary.BookShow.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jsBinary.BookShow.entity.User;
import com.jsBinary.BookShow.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = repository.findByUsername(username);
		org.springframework.security.core.userdetails.User.UserBuilder builder = null;
		if (user.isPresent()) {
			User currentUser = user.get();
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(currentUser.getPassword());
			builder.roles(currentUser.getRole());
		}else {
			throw new UsernameNotFoundException("User not found");
		}
		return builder.build();
	}

}
