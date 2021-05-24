package com.cg.cars.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.cars.services.UserService;
import com.cg.cars.model.UserDTO;
import com.cg.cars.entities.User;
import com.cg.cars.exceptions.UserNotFoundException;


@RestController
@RequestMapping("/api/cars")
public class UserController {
	static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/************************************************************************************
	 * Method: addUser 
	 * Description: It is used to add User into Users table
	 * @param User: User's reference variable.
	 * @returns User: It returns User with details
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@PostMapping("/add-user")
	public ResponseEntity<Object> insertUser(@RequestBody User user) {
		LOGGER.info("add-User URL is opened");
		LOGGER.info("addUser() is initiated");
		UserDTO userDTO = null;
		ResponseEntity<Object> userResponse = null;
		userDTO = userService.addUser(user);
		userResponse = new ResponseEntity<>(userDTO, HttpStatus.ACCEPTED);
		LOGGER.info("addUser() has executed");
		return userResponse;
	}

	/************************************************************************************
	 * Method: getUserById 
	 * Description: It is used to view User by id from Users table
	 * @param User: Long id
	 * @returns User: It returns User with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@GetMapping("/view-user/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable Long id) throws UserNotFoundException {
		LOGGER.info("view-User URL is opened");
		LOGGER.info("viewUser() is initiated");
		UserDTO userDTO = userService.getUserById(id);
		LOGGER.info("viewUser() has executed");
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}

	/************************************************************************************
	 * Method: getAllUsers 
	 * Description: It is used to view all Users in Users table
	 * @returns User: It returns User with details
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type.
	 ************************************************************************************/
	@GetMapping("/view-all-user")
	public List<UserDTO> viewAllUsers() {
		LOGGER.info("view-all-User URL is opened");
		LOGGER.info("viewAllUser() is initiated");
		LOGGER.info("viewAllUser() has executed");
		return userService.getAllUsers();
	}

	/************************************************************************************
	 * Method: DeleteUser 
	 * Description: It is used to remove User from Users table
	 * @param User: Long id
	 * @returns User It returns User with details
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain
	 *               object in method parameter or return type.
	 ************************************************************************************/
	@DeleteMapping("/delete-user/{id}")
	public ResponseEntity<Object> deleteUserById(@PathVariable Long id) throws UserNotFoundException {
		LOGGER.info("delete-User URL is opened");
		LOGGER.info("deleteUser() is initiated");
		userService.deleteUserById(id);
		LOGGER.info("deleteUser() has executed");
		return new ResponseEntity<>("deleted successfully:", HttpStatus.ACCEPTED);
	}

	/************************************************************************************
	 * Method: updateUser 
	 * Description: It is used to update User into User table
	 * @param User: User's reference variable.
	 * @returns User: It returns User with details
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@PutMapping("/update-user/{id}")

	public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody User userRequest)
			throws UserNotFoundException {
		LOGGER.info("update-User URL is opened");
		LOGGER.info("updateUser() is initiated");
		userService.updateUserById(id, userRequest);
		LOGGER.info("updateUser() has executed");
		return new ResponseEntity<>("Updated ", HttpStatus.OK);
	}

}
