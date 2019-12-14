package com.cognizant.menuitemservice.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.menuitemservice.exception.UserAlreadyExistsException;
import com.cognizant.menuitemservice.model.User;
import com.cognizant.menuitemservice.security.AppUserDetailsService;


@RestController
@RequestMapping("/users") 
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	AppUserDetailsService appUserDetailsService;

	
	
	@PostMapping
	public void signup(@RequestBody @Valid User user) throws UserAlreadyExistsException {
		appUserDetailsService.signup(user);
		
		/*	if(inMemoryUserDetailsManager.userExists(user.getUsername())){
				throw new UserAlreadyExistsException();
			}
			else{
				
				inMemoryUserDetailsManager.createUser(
						org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
						.password(new BCryptPasswordEncoder().encode(user.getPassword()))
						.roles("USER").build());
				return true;
			}*/

	}



}
