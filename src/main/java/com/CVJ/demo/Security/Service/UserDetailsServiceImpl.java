package com.CVJ.demo.Security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.CVJ.demo.Repository.UserRepository;
import com.CVJ.demo.models.Users;

import jakarta.transaction.Transactional;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	 @Transactional
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    Users user = userRepository.findByUsername(username)
	        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

	    return UserDetailsImpl.build(user);
	  }
	
	
		 

}
