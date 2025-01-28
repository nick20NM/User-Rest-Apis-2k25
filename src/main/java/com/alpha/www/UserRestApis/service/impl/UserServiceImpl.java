package com.alpha.www.UserRestApis.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.alpha.www.UserRestApis.dto.UserDto;
import com.alpha.www.UserRestApis.entity.User;
import com.alpha.www.UserRestApis.exception.ResourceNotFoundException;
import com.alpha.www.UserRestApis.mapper.AutoUserMapper;
import com.alpha.www.UserRestApis.mapper.UserMapper;
import com.alpha.www.UserRestApis.repository.UserRepository;
import com.alpha.www.UserRestApis.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
//	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		// convert UserDto into User JPA entity
//		User user = UserMapper.mapToUser(userDto);
//		User user = modelMapper.map(userDto, User.class);
		User user = AutoUserMapper.MAPPER.mapToUser(userDto);
		
		// save user object to the DB
		User savedUser = userRepository.save(user);
		
		// convert User JPA entity into UserDto
//		UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
//		UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
		UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
		
		return savedUserDto;
	}

	@Override
	public UserDto getUserById(Long userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(
				() -> new ResourceNotFoundException("User", "id", userId)
				);
//		return UserMapper.mapToUserDto(user);
//		return modelMapper.map(user, UserDto.class);
		return AutoUserMapper.MAPPER.mapToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
//		return users.stream()
//				.map(UserMapper::mapToUserDto)
//				.collect(Collectors.toList());
//		return users.stream()
//				.map(user -> modelMapper.map(user, UserDto.class))
//				.collect(Collectors.toList());
		return users.stream()
				.map(user -> AutoUserMapper.MAPPER.mapToUserDto(user))
				.collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(UserDto user) {
		User existingUser = userRepository.findById(user.getId())
				.orElseThrow(
						() -> new ResourceNotFoundException("User", "id", user.getId())
						);
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		
		// save to DB
		User updatedUser = userRepository.save(existingUser);
		
//		return UserMapper.mapToUserDto(updatedUser);
//		return modelMapper.map(updatedUser, UserDto.class);
		return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
	}

	@Override
	public void deleteUser(Long userId) {
		User existingUser = userRepository.findById(userId).
				orElseThrow(
						() -> new ResourceNotFoundException("User", "id", userId)
						);
		userRepository.deleteById(userId);
	}

}
