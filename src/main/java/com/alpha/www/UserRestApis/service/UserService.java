package com.alpha.www.UserRestApis.service;

import java.util.List;

import com.alpha.www.UserRestApis.dto.UserDto;
import com.alpha.www.UserRestApis.entity.User;

public interface UserService {

	UserDto createUser(UserDto userDto);
	
	UserDto getUserById(Long userId);
	
	List<User> getAllUsers();
	
	User updateUser(User user);
	
	void deleteUser(Long userId);
}
