package com.cg.cars.services;

import java.util.List;

import com.cg.cars.entities.User;
import com.cg.cars.exceptions.UserNotFoundException;
import com.cg.cars.model.UserDTO;



public interface UserService {
	
	public UserDTO addUser(User iuser);
	
	public UserDTO getUserById(Long id) throws UserNotFoundException;
	
	public List<UserDTO> getAllUsers();
	
	public User updateUserById(Long id, User userRequest) throws UserNotFoundException;
	
	public UserDTO deleteUserById(Long id)throws UserNotFoundException;

	//public User signIn(User user);
	
	//public User signOut(User user);
	
	//public User changePassword(long id, User user);
	


	
}