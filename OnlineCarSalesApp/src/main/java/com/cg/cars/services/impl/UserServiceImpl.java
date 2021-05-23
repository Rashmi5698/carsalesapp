package com.cg.cars.services.impl;

import java.util.List;
import java.util.Optional;

import com.cg.cars.entities.User;
import com.cg.cars.exceptions.UserNotFoundException;
import com.cg.cars.model.UserDTO;
import com.cg.cars.services.UserService;
import com.cg.cars.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.cars.util.UserUtils;

@Service
public class UserServiceImpl implements UserService {
	static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	public UserDTO addUser(User iuser) {
		LOGGER.info("addUser() service is initiated");
		User userEntity = userRepository.save(iuser);
		LOGGER.info("addUser() service has executed");
		return UserUtils.convertToUserDto(userEntity);
	}

	public UserDTO getUserById(Long id) throws UserNotFoundException {
		LOGGER.info("getUserById() service is initiated");
		Optional<User> existUser = userRepository.findById(id);
		if (existUser.isPresent()) {
			User user = existUser.get();
			LOGGER.info("getUserById() service has executed");
			return UserUtils.convertToUserDto(user);
		} else {
			throw new UserNotFoundException("User with id not present");
		}

	}

	public List<UserDTO> getAllUsers() {
		LOGGER.info("getAllUser() service is initiated");
		List<User> userList = userRepository.findAll();
		LOGGER.info("getAllUser() service has executed");
		return UserUtils.convertToUserDtoList(userList);
	}

	public User updateUserById(Long id, User userRequest) throws UserNotFoundException {
		LOGGER.info("updateUser() service is initiated");
		return userRepository.findById(id).map(user -> {
			user.setPassword(userRequest.getPassword());
			user.setRole(userRequest.getRole());
			LOGGER.info("updateUser() service has executed");
			return userRepository.save(user);
		}).orElseThrow(() -> new UserNotFoundException("user with id not present"));

	}

	public UserDTO deleteUserById(Long id) throws UserNotFoundException {
		LOGGER.info("deleteUser() service is initiated");
		User userexist = userRepository.findById(id).orElse(null);
		if (userexist == null)
			throw new UserNotFoundException("user with id not present");
		else
			userRepository.delete(userexist);
		LOGGER.info("deleteUser() service has executed");
		return UserUtils.convertToUserDto(userexist);
	}

}
