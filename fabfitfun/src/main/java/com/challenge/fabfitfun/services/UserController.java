package com.challenge.fabfitfun.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.fabfitfun.api.v1.model.UserDTO;
import com.challenge.fabfitfun.api.v1.model.UserListDTO;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController 
{
    public static final String BASE_URL = "/api/v1/user";

    private final UserService userService;

	public UserController(UserService userService) 
	{
		this.userService = userService;
	}
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public UserListDTO getListOfUsers(){
        return new UserListDTO(userService.getAllUsers());
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }


    @PostMapping({"/{id}"})
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createNewUser(@RequestBody UserDTO userDTO, @PathVariable Long id){
        return userService.createNewUser(id,userDTO);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        return userService.saveUserByDTO(id, userDTO);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public UserDTO patchUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        return userService.patchUser(id, userDTO);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
    }
    
    @GetMapping({"/firstName/{firstName}"})
    @ResponseStatus(HttpStatus.OK)
    public UserListDTO getListOfUsersByFirstName(@PathVariable String firstName){
        return new UserListDTO(userService.getUserByFirstName(firstName));
    }

    @GetMapping({"/middleName/{middleName}"})
    @ResponseStatus(HttpStatus.OK)
    public UserListDTO getListOfUsersByMiddleName(@PathVariable String middleName){
        return new UserListDTO(userService.getUserByMiddleName(middleName));
    }

    @GetMapping({"/lastName/{lastName}"})
    @ResponseStatus(HttpStatus.OK)
    public UserListDTO getListOfUsersByLastName(@PathVariable String lastName){
        return new UserListDTO(userService.getUserByLastName(lastName));
    }

    @GetMapping({"/name/{name}"})
    @ResponseStatus(HttpStatus.OK)
    public UserListDTO getListOfUsersByName(@PathVariable String name){
        return new UserListDTO(userService.getUserByFirstNameOrMiddleNameOrLastName(name, name, name));
    }

}
