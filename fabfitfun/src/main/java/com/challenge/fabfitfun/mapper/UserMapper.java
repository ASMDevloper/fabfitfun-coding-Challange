package com.challenge.fabfitfun.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.challenge.fabfitfun.api.v1.model.UserDTO;
import com.challenge.fabfitfun.domain.User;

/**
 * @author Ali Sohaib Malik
 * 
 *
 */
@Mapper
public interface UserMapper 
{
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	UserDTO userToUserDTO(User user);
	
	User userDTOToUser(UserDTO userDTO);
	
}
