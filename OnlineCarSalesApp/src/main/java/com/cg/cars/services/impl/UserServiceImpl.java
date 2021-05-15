package com.cg.cars.services.impl;

import java.util.List;
import java.util.Optional;

import com.cg.cars.entities.User;

import com.cg.cars.model.UserDTO;

import com.cg.cars.services.UserService;
import com.cg.cars.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.cars.util.UserUtils;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	
public UserDTO addUser(User iuser){
	User userEntity=userRepository.save(iuser);
	return UserUtils.convertToUserDto(userEntity);
}


public void deleteUser(UserDTO userdto) {
	
	userRepository.delete(UserUtils.convertToUser(userdto));
	
}
	
public void updateUser(UserDTO userdto) {
	
	userRepository.save(UserUtils.convertToUser(userdto));
			
	
}

public UserDTO getUserById(int id) {
	Optional<User> existUser=userRepository.findById(id);
	if(existUser.isPresent()) {
		User user=existUser.get();
	return UserUtils.convertToUserDto(user);
}
	else {
		return null;
	}
	
}


public List<UserDTO> getAllUsers(){
		List<User> userList=userRepository.findAll();
		return UserUtils.convertToUserDtoList(userList);
		}
}





