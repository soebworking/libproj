package com.library.library.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.library.library.model.User;
import com.library.library.web.dto.UserRegistrationDto;



public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
