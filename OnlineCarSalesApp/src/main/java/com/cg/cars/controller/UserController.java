package com.cg.cars.controller;
import java.util.List;
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


//@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/cars")
public class UserController {
	
	@Autowired
	private UserService userService;
	@PostMapping("/add-user")
	public ResponseEntity<Object> insertUser(@RequestBody User user)
	{
		UserDTO userDTO = null;
		ResponseEntity<Object> userResponse = null;
		userDTO =userService.addUser(user);
		userResponse = new ResponseEntity<Object>(userDTO, HttpStatus.ACCEPTED);
		return userResponse;
	}
	@GetMapping("/view-user/{id}")
	public ResponseEntity getUserById(@PathVariable Long id)throws  UserNotFoundException {
	
		UserDTO userDTO = userService.getUserById(id);
		
		return new ResponseEntity(userDTO, HttpStatus.OK);
	}
	
	
	@GetMapping("/view-all-user")
	public List<UserDTO> viewAllUsers() {
		
		return userService.getAllUsers();
	}
	@DeleteMapping("/delete-user/{id}")
	public ResponseEntity<Object> deleteUserById(@PathVariable Long id) throws UserNotFoundException{
	
		userService.deleteUserById(id);
	
		return new ResponseEntity("deleted successfully:", HttpStatus.ACCEPTED);
}
@PutMapping("/update-user/{id}")
	
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody User userRequest) throws UserNotFoundException {
		userService.updateUserById(id,userRequest);
		return new ResponseEntity("Updated ", HttpStatus.OK);
	}
	
	

}
