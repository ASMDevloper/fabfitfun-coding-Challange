package com.challenge.fabfitfun.services;

import java.util.List;

import com.challenge.fabfitfun.api.v1.model.UserDTO;

public interface UserService 
{
    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO createNewUser(UserDTO userDTO);
    UserDTO createNewUser(Long id, UserDTO userDTO);

    UserDTO saveUserByDTO(Long id, UserDTO userDTO);

    UserDTO patchUser(Long id, UserDTO userDTO);

    void deleteUserById(Long id);
    
    List<UserDTO> getUserByFirstName(String firstName);
    List<UserDTO> getUserByMiddleName(String middleName);
    List<UserDTO> getUserByLastName(String lastName);
    List<UserDTO> getUserByFirstNameOrMiddleNameOrLastName(String firstName, String middleName, String lastName);
    
}
