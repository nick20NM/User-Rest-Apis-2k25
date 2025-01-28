package com.alpha.www.UserRestApis.mapper;

import com.alpha.www.UserRestApis.dto.UserDto;
import com.alpha.www.UserRestApis.entity.User;

public class UserMapper {

	// convert User JPA entity into UserDto
	public static UserDto mapToUserDto(User user) {
		UserDto userDto = new UserDto(
				user.getId(), 
				user.getFirstName(), 
				user.getLastName(), 
				user.getEmail()
				);
		return userDto;
	}
	
	// convert UserDto into User JPA entity
	public static User mapToUser(UserDto userDto) {
		User user = new User(
				userDto.getId(), 
				userDto.getFirstName(), 
				userDto.getLastName(), 
				userDto.getEmail()
				);
		return user;
		
	}
}
