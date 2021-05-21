package com.cg.cars.services.impl;

import java.util.List;
import java.util.Optional;

import com.cg.cars.entities.User;
import com.cg.cars.exceptions.UserNotFoundException;
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




public UserDTO getUserById(Long id) throws UserNotFoundException{
	Optional<User> existUser=userRepository.findById(id);
	if(existUser.isPresent()) {
		User user=existUser.get();
	return UserUtils.convertToUserDto(user);
}
	else {
		throw new UserNotFoundException("User with id not present");
	}
	
}


public List<UserDTO> getAllUsers(){
		List<User> userList=userRepository.findAll();
		return UserUtils.convertToUserDtoList(userList);
		}

public User updateUserById(Long id, User userRequest) throws UserNotFoundException{
    return userRepository.findById(id).map( user-> {
    	user.setPassword(userRequest.getPassword());
    	user.setRole(userRequest.getRole());
    return userRepository.save(user);
    }).orElseThrow(()-> new UserNotFoundException("user with id not present"));
    
}

public UserDTO deleteUserById(Long id)throws UserNotFoundException {
	User userexist=userRepository.findById(id).orElse(null);
	if(userexist==null)
		throw new UserNotFoundException("user with id not present");
	else
		userRepository.delete(userexist);
	return UserUtils.convertToUserDto(userexist);
	}

}





