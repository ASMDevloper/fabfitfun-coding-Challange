package com.challenge.fabfitfun.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.challenge.fabfitfun.api.v1.model.UserDTO;
import com.challenge.fabfitfun.domain.User;
import com.challenge.fabfitfun.mapper.UserMapper;
import com.challenge.fabfitfun.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	private final UserMapper userMapper;
	private final UserRepository userRepository;
	
	public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
		super();
		this.userMapper = userMapper;
		this.userRepository = userRepository;
	}

	@Override
	public List<UserDTO> getAllUsers() 
	{
		return userRepository
                .findAll()
                .stream()
                .map(user -> {
                   UserDTO userDTO = userMapper.userToUserDTO(user);
                   userDTO.setUserUrl(getUserUrl(user.getId()));
                   return userDTO;
                })
                .collect(Collectors.toList());
	}

	@Override
	public UserDTO getUserById(Long id) 
	{
        return userRepository.findById(id)
                .map(userMapper::userToUserDTO)
                .map(userDTO -> {
                    //set API URL
                    userDTO.setUserUrl(getUserUrl(id));
                    return userDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public UserDTO createNewUser(UserDTO userDTO) 
	{
        return saveAndReturnDTO(userMapper.userDTOToUser(userDTO));
	}

	@Override
	public UserDTO createNewUser(Long id, UserDTO userDTO) 
	{
		Optional<User> postingUser = userRepository.findById(id);
		
		if(postingUser.isPresent() && postingUser.get().getRole().equals("ADMIN"))
		{
	        return saveAndReturnDTO(userMapper.userDTOToUser(userDTO));
		}
		throw new AdminOnlyException();
		
	}
	
	private UserDTO saveAndReturnDTO(User user)
	{
        User savedUser = userRepository.save(user);

        UserDTO returnDto = userMapper.userToUserDTO(savedUser);

        returnDto.setUserUrl(getUserUrl(savedUser.getId()));

        return returnDto;
    }

	@Override
	public UserDTO saveUserByDTO(Long id, UserDTO userDTO) 
	{
		User user = userMapper.userDTOToUser(userDTO);
	    user.setId(id);
	        
        return saveAndReturnDTO(user);
	}

	@Override
	public UserDTO patchUser(Long id, UserDTO userDTO) 
	{
		return userRepository.findById(id).map(user -> {

            if(userDTO.getFirstName() != null){
                user.setFirstName(userDTO.getFirstName());
            }

            if(userDTO.getMiddleName() != null){
                user.setMiddleName(userDTO.getMiddleName());
            }

            if(userDTO.getLastName() != null){
                user.setLastName(userDTO.getLastName());
            }

            if(userDTO.getDateOfBirth() != null){
                user.setDateOfBirth(userDTO.getDateOfBirth());
            }
            
            if(userDTO.getAddress() != null){
                user.setAddress(userDTO.getAddress());
            }

            if(userDTO.getRole() != null){
                user.setRole(userDTO.getRole());
            }
            
            UserDTO returnDto = userMapper.userToUserDTO(userRepository.save(user));

            returnDto.setUserUrl(getUserUrl(id));

            return returnDto;

        }).orElseThrow(ResourceNotFoundException::new);
	}
    private String getUserUrl(Long id) {
        return UserController.BASE_URL + "/" + id;
    }
	@Override
	public void deleteUserById(Long id) 
	{
		userRepository.deleteById(id);
	}

	@Override
	public List<UserDTO> getUserByFirstName(String firstName)
	{
		return userRepository
                .findByFirstName(firstName)
                .stream()
                .map(user -> {
                   UserDTO userDTO = userMapper.userToUserDTO(user);
                   userDTO.setUserUrl(getUserUrl(user.getId()));
                   return userDTO;
                })
                .collect(Collectors.toList());
	}

	@Override
	public List<UserDTO> getUserByMiddleName(String middleName)
	{
		return userRepository
                .findByMiddleName(middleName)
                .stream()
                .map(user -> {
                   UserDTO userDTO = userMapper.userToUserDTO(user);
                   userDTO.setUserUrl(getUserUrl(user.getId()));
                   return userDTO;
                })
                .collect(Collectors.toList());
	}

	@Override
	public List<UserDTO> getUserByLastName(String lastName) {
		return userRepository
                .findByLastName(lastName)
                .stream()
                .map(user -> {
                   UserDTO userDTO = userMapper.userToUserDTO(user);
                   userDTO.setUserUrl(getUserUrl(user.getId()));
                   return userDTO;
                })
                .collect(Collectors.toList());
	}

	@Override
	public List<UserDTO> getUserByFirstNameOrMiddleNameOrLastName(String firstName, String middleName, String lastName) 
	{
		return userRepository
                .findByFirstNameOrMiddleNameOrLastName(firstName, middleName, lastName)
                .stream()
                .map(user -> {
                   UserDTO userDTO = userMapper.userToUserDTO(user);
                   userDTO.setUserUrl(getUserUrl(user.getId()));
                   return userDTO;
                })
                .collect(Collectors.toList());
	}

}
