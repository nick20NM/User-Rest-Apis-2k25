package com.alpha.www.UserRestApis.service;

import java.util.List;

import com.alpha.www.UserRestApis.entity.User;

public interface UserService {

	User createUser(User user);
	
	User getUserById(Long userId);
	
	List<User> getAllUsers();
	
	User updateUser(User user);
}
