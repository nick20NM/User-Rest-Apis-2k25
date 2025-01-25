package com.alpha.www.UserRestApis.service.impl;

import org.springframework.stereotype.Service;

import com.alpha.www.UserRestApis.entity.User;
import com.alpha.www.UserRestApis.repository.UserRepository;
import com.alpha.www.UserRestApis.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

}
