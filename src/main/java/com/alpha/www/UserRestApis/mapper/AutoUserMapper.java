package com.alpha.www.UserRestApis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.alpha.www.UserRestApis.dto.UserDto;
import com.alpha.www.UserRestApis.entity.User;

@Mapper
public interface AutoUserMapper {
	
	AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

//	@Mapping(source = "email", target = "emailAddress")
	UserDto mapToUserDto(User user);
	
	User mapToUser(UserDto userDto);
}
