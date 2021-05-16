package com.cg.cars.services;

import java.util.List;

import com.cg.cars.entities.User;

import com.cg.cars.model.UserDTO;



public interface UserService {
	
	public UserDTO addUser(User iuser);
	
	public UserDTO getUserById(int id);
	
	public List<UserDTO> getAllUsers();
	
	public void deleteUser(UserDTO userdto); 
	
	public void updateUser(UserDTO userdto);

	//public User signIn(User user);
	
	//public User signOut(User user);
	
	//public User changePassword(long id, User user);
	


	
}